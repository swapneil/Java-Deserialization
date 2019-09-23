package testserialization;
import java.io.*;

public class SerializeDemo {
	public static void main(String [] args) {
//	      Employee e = new Employee();
//	    
//	      e.name = "Reyan Ali";
//	      e.address = "Phokka Kuan, Ambehta Peer";
//	      e.SSN = 11122333;
//	      e.number = 101;
		ExploitDeser e=new ExploitDeser();
	      try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/malicious.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/malicious.ser");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	   }
}
