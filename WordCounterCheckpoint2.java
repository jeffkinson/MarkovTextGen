import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class WordCounter {
    private HashMap<String, Integer> wordCounts;
    private HashMap<String, ArrayList<String>> wordsThatFollow;

    public WordCounter(String filename) {
	wordCounts = new HashMap<String, Integer>();
	wordsThatFollow = new HashMap<String, ArrayList<String>>();
	try {
	    Scanner fileScanner = new Scanner(new FileReader(filename));
	    countWords(fileScanner);
	} catch (IOException e) {
	    System.out.println("Could not load filename " + filename);
	}
    }

    private void countWords(Scanner scanner) {
	String prevWord = "";
	while (scanner.hasNext()) {
	    String word = scanner.next();
	    int oldWordCount = getWordCounts(word);
	    wordCounts.put(word, oldWordCount + 1);

	    if (!prevWord.equals("")) {
		addWordThatFollows(prevWord, word);
	    }
	    prevWord = word;
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

    public void addWordThatFollows(String prevWord, String nextWord) {
	ArrayList<String> existingWords = getWordsThatFollow(prevWord);
	existingWords.add(nextWord);
	wordsThatFollow.put(prevWord, existingWords);
    }

    public ArrayList<String> getWordsThatFollow(String prevWord) {
	ArrayList<String> existingWords = new ArrayList<String>();
	if (wordsThatFollow.containsKey(prevWord)) {
	    existingWords = wordsThatFollow.get(prevWord);
	}
	return existingWords;
    }


    public static void main (String[] args) {
	WordCounter wc = new WordCounter("alice_tokenized.txt");	
    }
}