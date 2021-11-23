import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileExample {

	
	
	public static void addFile(String fileName, Node<String> list) {

		File f = new File(fileName);
		
		try {
			Scanner sc = new Scanner(f);

			while (sc.hasNext()) {
				String s = sc.next();
				list.add(s);
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		
		}

	}

	
	
}
