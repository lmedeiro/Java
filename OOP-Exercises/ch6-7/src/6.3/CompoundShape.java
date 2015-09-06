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

    // h6 q3 midification
    public void drawSelection(Graphics2D g2) {
	Rectangle bounds = path.getBounds();
	// draw the dashed rectangle
	Stroke oldStroke = g2.getStroke();
	Color oldcolor = g2.getColor();

	g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 1,
				     new float[]{5.0F, 5.0F}, 0));
	//	g2.setColor(...);
	Rectangle frame = new Rectangle((int)bounds.getX()-CORNER_GAP, (int)bounds.getY()-CORNER_GAP, 
					(int)bounds.getWidth()+CORNER_GAP, (int)bounds.getHeight()+CORNER_GAP);

	g2.setColor(Color.black);
	g2.draw(frame);
	
	// now draw the rectangles on the bounds' corners:
	g2.setStroke(oldStroke);

	g2.fill(new Rectangle((int)frame.getX()-CORNER_RADIUS, (int)frame.getY()-CORNER_RADIUS, 
			      2*CORNER_RADIUS, 2*CORNER_RADIUS));

	g2.fill(new Rectangle((int)frame.getX()+(int)frame.getWidth()-CORNER_RADIUS, (int)frame.getY()-CORNER_RADIUS, 
			      2*CORNER_RADIUS, 2*CORNER_RADIUS));

	g2.fill(new Rectangle((int)frame.getX()+(int)frame.getWidth()-CORNER_RADIUS, (int)frame.getY()+(int)frame.getHeight()-CORNER_RADIUS, 2*CORNER_RADIUS, 2*CORNER_RADIUS));

	g2.fill(new Rectangle((int)frame.getX()-CORNER_RADIUS, (int)frame.getY()+(int)frame.getHeight()-CORNER_RADIUS, 2*CORNER_RADIUS, 2*CORNER_RADIUS));

	g2.setColor(oldcolor);	
    }

   
   private GeneralPath path;

   private static final int CORNER_RADIUS = 3; 
   private static final int CORNER_GAP = 7; 
}







