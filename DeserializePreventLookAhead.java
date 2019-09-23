package testserialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class DeserializePreventLookAhead {
	public static void main(String [] args) {
	      Employee e = null;
	    ExploitDeser exp=null;  
		try {
	         FileInputStream fileIn = new FileInputStream("/tmp/malicious.ser");
	         ObjectInputStream in = new LookAheadObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      //e.mailCheck();
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Number: " + e.number);
	   }
}
class LookAheadObjectInputStream extends ObjectInputStream {
	 
    public LookAheadObjectInputStream(InputStream inputStream)
            throws IOException {
        super(inputStream);
    }
 
    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException,
            ClassNotFoundException {
        if (!desc.getName().equals(Employee.class.getName())) {
            throw new InvalidClassException(
                    "Unauthorized deserialization attempt",
                    desc.getName());
        }
        return super.resolveClass(desc);
    }
}