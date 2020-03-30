package nguyen_problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
	private Integer wordCounter;
	private Map<String, Integer>countWords;
	
	public DuplicateCounter() {
		this.wordCounter = 0;
		this.countWords = new HashMap<>();
	}
	
	public void count(String dataFile) {
		Scanner fileReader;
		try {
			fileReader = new Scanner(new File(dataFile));
			while(fileReader.hasNextLine()) {
				String line = fileReader.nextLine().trim();
				String[] data = line.split("[\\W]+");
				for(String word:data) {
					this.wordCounter = countWords.get(word);
					this.wordCounter = (this.wordCounter == null)?1:++this.wordCounter;
					countWords.put(word, this.wordCounter);
				}
			}
			fileReader.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("File" + dataFile + " cannot be found.");
			System.exit(1);
		}
	}
	
	public void write(String outputFile) {
		FileWriter fw;
		PrintWriter pw;
		try {
			fw = new FileWriter(new File(outputFile));
			pw = new PrintWriter(fw);
			for(Map.Entry<String, Integer> entry : countWords.entrySet()) {
				pw.write(entry.getKey() + " occurs " + entry.getValue() + " times" + System.lineSeparator());
			}
			System.out.println("Map data written to file: " + outputFile);
			pw.flush();
			fw.close();
			pw.close();
		}
		catch(IOException ioex) {
			System.out.println("Error writing to " + outputFile + ": " + ioex.getMessage());
			System.exit(1);
		}
	}
}
