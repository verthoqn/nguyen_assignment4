package nguyen_problem2;

public class Application {
	public static void main(String[] args) {
		DuplicateCounter duplicateCounter = new DuplicateCounter();
		
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");
	}
}
