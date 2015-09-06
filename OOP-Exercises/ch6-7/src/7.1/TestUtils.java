public class TestUtils {
    public static void main(String[] args) {
	final int localvar = 0;

	Object[] objs = {
	    new java.util.Date(),
	    new Object() {
		int returnLocalVar() {
		    return localvar;  // access outside scope local var
		}
	    }  // anonymous class object
	}; // objs array
		
	for (Object obj: objs) {

	    try {
		Class<?> cl = obj.getClass();
		String s = Utils.explain(cl);
		System.out.println(s + "\n================================\n\n\n");
							    
	    } catch(Exception ex) {
		ex.printStackTrace(System.out);
	    }
	}
    }
}

