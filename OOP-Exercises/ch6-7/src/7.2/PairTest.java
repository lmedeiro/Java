import java.io.*;


public class PairTest {
    public static void main(String[] args) {
	Pair <Integer, String> p11 = new Pair <Integer, String>(1, "one");
	Pair <Integer, String> p12 = new Pair <Integer, String>(1, "onetwo");
	Pair <Integer, String> p1 = new Pair <Integer, String>(1, "one");

	assert p1.equals(p11): "Fails: p1.equals(p11)";
	assert ! p1.equals(p12): "Fails: p1.equals(p12)";

	// serialization:
	String filename = "serialized.dat";
	try {
	    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));
	    os.writeObject(p1);
	    os.close();

	    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
	    Pair <Integer, String> p1restored = (Pair <Integer, String>) in.readObject();
	    assert p1.equals(p1restored): "Fails: serialization";
	} catch (Exception ex) {
	    ex.printStackTrace(System.err);
	}

	Pair <Integer, String> p1copy = (Pair <Integer, String>) p1.clone();
	assert p1.equals(p1copy): "Fails: p1.equals(p1copy)";
	assert p1.hashCode() == p1copy.hashCode(): "Fails: hashCode";

    }
}