import java.io.*;

public class Name implements Serializable{
	private String first;
	private String last;
	
	public Name(String f, String l) {
		first = f;
		last = l;
	}
	
	public String printName() {
		return first + ", " + last;
	}
}
