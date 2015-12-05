import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordCounter implements TextAnalyzer {
    private HashMap<String, Integer> wordCounts;

    public WordCounter(String filename) {
	wordCounts = new HashMap<>();
	try {
	    Scanner fileScanner = new Scanner(new FileReader(filename));
	    countWords(fileScanner);
	} catch (IOException e) {
	    System.out.println("Could not load filename " + filename);
	}
    }
    
    private void countWords(Scanner scanner) {
	while (scanner.hasNext()) {
	    String word = scanner.next();
	    int oldWordCount = getWordCounts(word);
	    wordCounts.put(word, oldWordCount + 1);
	}
    }

    public int getWordCounts(String word) {
	if (wordCounts.containsKey(word)) {
	    return wordCounts.get(word);
	}
	return 0;
    }

    public void printCounts() {
	for (String key : wordCounts.keySet()) {
	    Integer count = wordCounts.get(key);
	    System.out.println(key + ": " + count);
	}
    }

    public boolean startsWithCapitalLetter(String word) {
	return true;
    }

    public ArrayList<String> getAllWordsThatStartWithACapitalLetter() {
	return false;
    }

    public static void main (String[] args) {
	WordCounter wc = new WordCounter("alice_tokenized.txt");	
    }
}