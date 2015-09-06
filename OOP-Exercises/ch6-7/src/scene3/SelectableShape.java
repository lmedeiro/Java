package scene3;

import java.awt.*;
import java.awt.geom.*;

/**
   A shape that manages its selection state.
*/
public abstract class SelectableShape implements SceneShape
{
   public void setSelected(boolean b)
   {
      selected = b;
   }

   public boolean isSelected()
   {
      return selected;
   }

   public void drawSelection(Graphics2D g2)
   {
      // translate(1, 1);
      // draw(g2);
      // translate(2, 2);
      // draw(g2);
      // translate(-3, -3);
	// GeneralPath path= new GeneralPath((Shape)g2);
	  
	  // Shape rec= path.getBounds2D();
	  
	  // g2.draw(rec);
	  Shape rec= g2.getClipBounds();
	  
	  
	  
	  
	  //g2.setStroke(new BasicStroke());
	  g2.draw(rec);
	  // draw(g2);
   }

   private boolean selected;
}
