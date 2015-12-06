package textGen3;

import java.util.ArrayList;
import java.util.Random;

public class SentenceGeneratorStarterCode {
    TextAnalyzer counter;
    Random random;
    
    public SentenceGeneratorStarterCode(String filename) {
    	counter = new WordCounter(filename);
    	this.random = new Random();
    }
    
    public SentenceGeneratorStarterCode(String filename, Random random) {
    	counter = new WordCounter(filename);
    	this.random = random;
    }
    
    // given any word, randomly choose a word that could come next, using the TextAnalyzer wordsThatCouldComeNext
    // return that sentence as a String
    public String randomlyChooseNextWord(String prevWord) {
    	//TODO: implement this method
   }

    // given a starting word, generate a random word that could come next, and a random word that could come after that, etc.
    // keep going until you generate punctuation that could end a sentence, as determined by TextAnalyzer isSentenceEndingPunctuation
    public String generateRandomSentence(String firstWord) {
    	//TODO: implement this method
    }

    // randomly choose a word that starts with a capital letter, and use that as the first word of the sentence
    // then randomly generate the rest of the sentence using generateRandomSentence(String firstWord)
    public String generateRandomSentence() {
    	//TODO: implement this method
    }
    
    
    private String randomlySelectWord(ArrayList<String> possibleWords) {
    	int randomIndex = random.nextInt(possibleWords.size());
    	return possibleWords.get(randomIndex);
    }

    public static void main (String[] args) {
		SentenceGeneratorStarterCode sg = new SentenceGeneratorStarterCode("alice_tokenized.txt");
		
		System.out.println(sg.generateRandomSentence("Alice"));
		System.out.println(sg.generateRandomSentence("She"));
		System.out.println(sg.generateRandomSentence());
		System.out.println(sg.generateRandomSentence());
		System.out.println(sg.generateRandomSentence());
		System.out.println(sg.generateRandomSentence("There"));
		System.out.println(sg.generateRandomSentence("This"));
		System.out.println("The End");
    }
}
