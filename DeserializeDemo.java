package testserialization;
import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;


public class DeserializeDemo {
	public static void main(String [] args) {
	      Employee e = null;
	    
		try {
	         FileInputStream fileIn = new FileInputStream("/tmp/malicious.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
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
