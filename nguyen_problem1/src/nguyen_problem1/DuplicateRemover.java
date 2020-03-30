package nguyen_problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

	private Set<String> uniqueWords;
	
	public DuplicateRemover() {
		uniqueWords = new HashSet<>();
	}

	public void remove(String dataFile) {
		try {
			Scanner scanner = new Scanner(new File(dataFile));
			while(scanner.hasNext()) {
				uniqueWords.add(scanner.next());
			}
			scanner.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.exit(1);
		}		
	}

	public void write(String outputFile) {
		try {
			PrintWriter output = new PrintWriter(new File(outputFile));
			for(String string:uniqueWords) {
				output.println(string);
			}
			output.flush();
			output.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
			System.exit(1);
		}
	}
}
