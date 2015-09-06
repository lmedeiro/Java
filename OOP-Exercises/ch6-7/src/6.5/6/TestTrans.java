// check out scaling affine transformation

import java.awt.geom.*;
import java.awt.*;

public class TestTrans {
    public static void main(String... args) {
	Rectangle r = new Rectangle(2,3, 100, 200);

	AffineTransform tsc = AffineTransform.getScaleInstance(2, 4);
	Shape transr = tsc.createTransformedShape(r);
	PathIterator pathit = transr.getPathIterator(null);

	System.out.println(r+"\n\n");

	double coords[] = new double[6];
	while (! pathit.isDone()) {
	    int segtype = pathit.currentSegment(coords);
	    System.out.println(""+coords[0]+" "+coords[1]+" ");
	    pathit.next();
	}
	System.out.println(transr);

    }
};