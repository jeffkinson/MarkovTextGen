import java.util.ArrayList;

import main.TextGenerator.WordCounter;

public class MarkovGenerator {
    WordCounter counter;

    public MarkovGenerator(String filename) {
	counter = new WordCounter(filename);
    }
    

    public String randomlyChooseNextWord(String prevWord) {
	ArrayList<String> candidateWords = counter.getWordsThatFollow(prevWord);
	int randomIndex = (int)(Math.random()*candidateWords.size());
	return candidateWords.get(randomIndex);
   }

    public boolean isEndOfSentence(String token) {
	return  (token.contains(".") || token.contains("?") || token.contains("!"));
    }

    public void generateRandomSentence(String firstWord) {
	String word = firstWord;
	while (!isEndOfSentence(word)) {
	    System.out.print(word + " ");
	    word = randomlyChooseNextWord(word);
	}
	System.out.println(word);
    }

    
    

    public static void main (String[] args) {
	MarkovGenerator mg = new MarkovGenerator("alice_tokenized.txt");
	//mg.printCounts();
	//System.out.println("Cheshire count: " + mg.getWordCounts("jumped"));
	//System.out.println(mg.getWordsThatFollow("jumped"));
	
	mg.generateRandomSentence("Alice");
	mg.generateRandomSentence("She");
	mg.generateRandomSentence("There");
	mg.generateRandomSentence("This");
	System.out.println("The End");
    }
}
