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

    // h6 q3 change: drawSelection is overriden by class CompundShape
    public void drawSelection(Graphics2D g2)
    {	
    }

   private boolean selected;
}
