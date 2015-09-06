// modified for Homework 6, q6

import java.awt.*;
import java.awt.geom.*;

/**
   A scene shape that is composed of multiple geometric shapes.
*/
public abstract class CompoundShape extends SelectableShape
{
   public CompoundShape()
   {
      path = new GeneralPath();
   }

   protected void add(Shape s)
   {
      path.append(s, false);
   }

   public boolean contains(Point2D aPoint)
   {
      return path.contains(aPoint);
   }

   public void translate(int dx, int dy)
   {
      path.transform(
            AffineTransform.getTranslateInstance(dx, dy));
   }

   public void draw(Graphics2D g2)
   {
      g2.draw(path);
   }

    // h6 q3 modification
   public void drawSelection(Graphics2D g2) {
	   Stroke oldStroke = g2.getStroke();
	   Color oldcolor = g2.getColor();

	   g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1,
			   new float[]{5.0F, 5.0F}, 0));

	   Rectangle frame = getSelectionFrame();

	   g2.setColor(Color.blue);
	   g2.draw(frame);

	   // now draw the rectangles on the bounds' corners:
	   g2.setStroke(oldStroke);
	   for (Rectangle r: this.getResizeCorners(frame)) {
		   g2.fill(r);
	   }

	   // restore color
	   g2.setColor(oldcolor);	
   }

   /**
     * Homework 6, q6
       Check whether the user clicks on one of the shape's resizing corners.
       @param p the mouse coordinate
    */
   public boolean isResizing(Point2D p) {
//	   System.out.println("isresizing p="+p);
	   for (Rectangle r: this.getResizeCorners(this.getSelectionFrame())) {
//		   System.out.println("      r="+r+", IN="+r.contains(p));
		   
		   if (r.contains(p))
			   return true;
	   }
	   return false;
   }

   /**
     * Homework 6, q6
       Resize shape. It 'kinda' works only for one shape at a time,
       but don't try to wrap corners.
         
       @param oldp the original mouse coordinate when dragging one corner
       @param newp the new mouse coordinate when dragging one corner
    */
   public void resize(Point2D oldp, Point2D newp) {
	   // find the pivot corner:
	   Rectangle frame = this.getSelectionFrame();
	   Rectangle[] cornerArray = this.getResizeCorners(frame);

	   int[] otherCornerIndex = new int[]{2, 3, 0, 1};

	   int pivotIndex, otherIndex;
	   for (otherIndex=0; otherIndex<4; otherIndex++) {
		   if (cornerArray[otherIndex].contains(oldp))
			   break;	
	   }
	   if (otherIndex == 4) {
		   throw(new RuntimeException("Old point not on resize corner"));
	   }
	   pivotIndex = otherCornerIndex[otherIndex];

	   Rectangle bounds = path.getBounds();
	   double dx = newp.getX() - oldp.getX();
	   double dy = newp.getY() - oldp.getY();

	   if (pivotIndex==1 || pivotIndex==2)
		   dx *= -1;
	   if (pivotIndex==2 || pivotIndex==3)
		   dy *= -1;

	   double xfactor = bounds.getWidth() > 0 ? ((bounds.getWidth() + dx) / bounds.getWidth()) : 1.0;
	   double yfactor = bounds.getHeight() > 0 ? ((bounds.getHeight() + dy) / bounds.getHeight()) : 1.0;

	   // build and apply scaling transformation:
	   AffineTransform tsc = AffineTransform.getScaleInstance(xfactor, yfactor);

	   Path2D newPathScaled = (Path2D)path.clone();
	   newPathScaled.transform(tsc);
	   Rectangle newBoundsScaled = newPathScaled.getBounds();
	   
	   double moveDx = 0;
	   double moveDy = 0;

	   switch (pivotIndex) {
	   case 0: 
		   moveDx = bounds.getX() - newBoundsScaled.getX();
		   moveDy = bounds.getY() - newBoundsScaled.getY();
		   break;
	   case 1:
		   moveDx = bounds.getX() + bounds.getWidth() - newBoundsScaled.getX() - newBoundsScaled.getWidth();
		   moveDy = bounds.getY() - newBoundsScaled.getY();
		   break;
	   case 2:
		   moveDx = bounds.getX() + bounds.getWidth() - newBoundsScaled.getX() - newBoundsScaled.getWidth();
		   moveDy = bounds.getY() + bounds.getHeight() - newBoundsScaled.getY() - newBoundsScaled.getHeight();
		   break;
	   case 3:
		   moveDx = bounds.getX() - newBoundsScaled.getX();
		   moveDy = bounds.getY() + bounds.getHeight() - newBoundsScaled.getY() - newBoundsScaled.getHeight();
		   break;
	   }

	   // translate back so original pivot and new pivot corners don't move:
	   AffineTransform ttranslate = AffineTransform.getTranslateInstance(moveDx, moveDy);

	   Path2D newPath = (Path2D)newPathScaled.clone();
	   newPath.transform(ttranslate);

	   // save new path:
	   path = newPath;
   }


   /**
       Return the rectangle that encloses the shape and is used for drawing 
       selection and foe resizing.
       @return a new Rectangle object that encloses the shape
    */
   private Rectangle getSelectionFrame() {
	   Rectangle bounds = path.getBounds();
	   Rectangle frame = new Rectangle((int)bounds.getX()-CORNER_GAP, (int)bounds.getY()-CORNER_GAP, 
			   (int)bounds.getWidth()+CORNER_GAP, (int)bounds.getHeight()+CORNER_GAP);

	   return frame;
   }

   /**
       Create and return an array with the Rectangles for the 4 corners of the
       frame that bounds the shape.
       @param frame the bounding rectangle of this shape
       @return array with 4 Rectangle objects
    */
   private Rectangle[] getResizeCorners(Rectangle frame) {
	   Rectangle[] ar = new Rectangle[4];

	   ar[0] = new Rectangle((int)frame.getX()-CORNER_RADIUS, (int)frame.getY()-CORNER_RADIUS, 
			   2*CORNER_RADIUS, 2*CORNER_RADIUS);

	   ar[1] = new Rectangle((int)frame.getX()+(int)frame.getWidth()-CORNER_RADIUS, (int)frame.getY()-CORNER_RADIUS, 
			   2*CORNER_RADIUS, 2*CORNER_RADIUS);

	   ar[2] = new Rectangle((int)frame.getX()+(int)frame.getWidth()-CORNER_RADIUS, (int)frame.getY()+(int)frame.getHeight()-CORNER_RADIUS, 2*CORNER_RADIUS, 2*CORNER_RADIUS);

	   ar[3] = new Rectangle((int)frame.getX()-CORNER_RADIUS, (int)frame.getY()+(int)frame.getHeight()-CORNER_RADIUS, 2*CORNER_RADIUS, 2*CORNER_RADIUS);

	   return ar;
   }


   // changed from GeneralPath to Path2D
   private Path2D path;

   private static final int CORNER_RADIUS = 3; 
   private static final int CORNER_GAP = 7; 
}
