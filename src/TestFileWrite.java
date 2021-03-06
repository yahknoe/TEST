import java.util.*;
import java.io.*;


public class TestFileWrite {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	

    	// ---------- Objects to put in array ---------- 		
		Name n1 = new Name("John", "Smith");
		Name n2 = new Name("Karl", "Ng");
		Name n3 = new Name("Jeff", "Smith");
		Name n4 = new Name("Tom", "Rich");
		Name n5 = new Name("Vincent", "Pham");
		Name n6 = new Name("Elena", "M");
		
		// ---------- Add objects to ArrayList ----------
		List<Name> thisIsTheList = new ArrayList<Name>(); //ArrayList!!!
		thisIsTheList.add(n1);
		thisIsTheList.add(n2);
		thisIsTheList.add(n3);
		thisIsTheList.add(n4);
		thisIsTheList.add(n6);
		
        // ---------- Writing to File ---------- 
    	FileOutputStream fos = new FileOutputStream("file.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
		//  ---------- Loop to write to file ---------- 
		for (int i=0; i<thisIsTheList.size(); i++) {
			oos.writeObject(thisIsTheList.get(i));
        }
		oos.close(); //done writing; close oos
		
    	// ---------- Reading from File ---------- 
    	FileInputStream fis = new FileInputStream("file.sav");
        ObjectInputStream ois = new ObjectInputStream(fis);
		
		// ---------- Loop to read from file ---------- 
        List<Name> thisIsTheNewList = new ArrayList<Name>(); // NEW ArrayList!!!
        for (int i=0; i<fis.available();i++) {               //fis.availible() is an int value of remaining bytes that can be read
        	thisIsTheNewList.add((Name)ois.readObject());
        }
        ois.close(); //done with reading; close ois
		
        // ---------- Loop to print NEW ArrayList ---------- 
        for (int i=0; i <thisIsTheNewList.size(); i++) {
        	System.out.println(thisIsTheNewList.get(i).printName());
        }
		
    }
}
		
		
/*		
		//Constructs an array filled with Name Objects
		Name NameArray[] = {n1,n2,n3,n4,n5};
		
		// ---------- Writing to File ---------- 
    	FileOutputStream fos = new FileOutputStream("file.sav");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        //Writing to file from array
        for (int i=0; i<NameArray.length; i++) {
        	oos.writeObject(NameArray[i]);
        }
       
        oos.close();
    	
        // ---------- Reading from File ---------- 
        FileInputStream fis = new FileInputStream("file.sav");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        //Construct an array to be filled with names
        Name NewArray[] = new Name[100];
        
        //Fill the new array with info from file
        for (int i=0; i<fis.available();i++) {              //fis.availible() is an int value of remaining bytes that can be read
        	NewArray[i] = (Name)ois.readObject();
        }
        
        ois.close();
        
        //Print the new array
        Name newName;
        for (int i=0; i<NewArray.length;i++) {
        	if (NewArray[i] != null) {
        		newName = NewArray[i];
        		System.out.println(newName.printName());
        	}
        }
    }
}
		*/