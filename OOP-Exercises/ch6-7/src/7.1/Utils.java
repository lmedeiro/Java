import java.lang.reflect.*;


public class Utils {
    public static String explain(Class<?> cl) {
	
	StringBuffer sb = new StringBuffer();

	formatClassHeader(cl, sb);
	
	formatConstructors(cl, sb);

	formatMethods(cl, sb);

	formatFields(cl, sb);

	sb.append("};");
	return sb.toString();
    }


    private static void formatClassHeader(Class <?> cl, StringBuffer sb) {
	int i;
	int modif = cl.getModifiers();
	Class<?> supercl = cl.getSuperclass();
	Class<?>[] interfaces = cl.getInterfaces();

	Package pkg = cl.getPackage();
	if (pkg != null) {
	    sb.append("package " + pkg.getName() + ";\n\n\n");
	}

	sb.append(Modifier.toString(modif));
	if (modif > 0) {
	    sb.append(" ");
	}

	sb.append("class " + cl.getName());

	if (supercl != null) {
	    sb.append(" extends " + supercl.getName());
	}

	if (interfaces.length > 0) {
	    sb.append(" implements ");
	    for (i=0; i<interfaces.length; i++) {
		Class interf = interfaces[i];
		if ((i > 0) && (i < interfaces.length)) {
		    sb.append(", ");
		}
		sb.append(interf.getName());
	    }
	}
	
	sb.append(" {\n");
    }

    private static void formatConstructors(Class<?> cl, StringBuffer sb) {
	int i;
	Constructor[] constructors = cl.getConstructors();

	sb.append("\t// constructors:\n");
	for (Constructor cons: constructors) {
	    sb.append("\t" + cons.toGenericString() + ";\n");
	    //	    TypeVariable<?>[] tparams = cons.getTypeParameters();
	    
	    //	    formatOneMethodOrCons(sb, cons.getModifiers(), tparams);
	}
	sb.append("\n");
    }

    private static void formatMethods(Class<?> cl, StringBuffer sb) {
	int i;
	Method[] meths = cl.getMethods();

	sb.append("\t// methods:\n");

	for (Method m: meths) {
	    sb.append("\t" + m.toGenericString() + ";\n");
	    //	    TypeVariable<?>[] tparams = m.getTypeParameters();
	    
	    //	    formatOneMethodOrCons(sb, cons.getModifiers(), tparams);
	}
    }

    private static void formatFields(Class<?> cl, StringBuffer sb) {
	int i;
	Field[] dfields = cl.getDeclaredFields();

	sb.append("\t// declared fields:\n");

	for (Field f: dfields) {
	    f.setAccessible(true);
	    sb.append("\t" + f.toGenericString() + ";\n");
	}
    }
}

