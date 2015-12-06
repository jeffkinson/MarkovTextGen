package textGen3;

import java.util.ArrayList;
import java.util.Random;

public class SentenceGenerator {
    TextAnalyzer counter;
    Random random;
    
    public SentenceGenerator(String filename) {
    	counter = new WordCounter(filename);
    	this.random = new Random();
    }
    
    public SentenceGenerator(String filename, Random random) {
    	counter = new WordCounter(filename);
    	this.random = random;
    }
    
    // given any word, randomly choose a word that could come next, using the TextAnalyzer wordsThatCouldComeNext
    // return that sentence as a String
    public String randomlyChooseNextWord(String prevWord) {
    	ArrayList<String> candidateWords = counter.getWordsThatCouldComeNext(prevWord);
    	return randomlySelectWord(candidateWords);
   }

    // given a starting word, generate a random word that could come next, and a random word that could come after that, etc.
    // keep going until you generate punctuation that could end a sentence, as determined by TextAnalyzer isSentenceEndingPunctuation
    public String generateRandomSentence(String firstWord) {
    	String sentence = "";
    	String word = firstWord;
    	while (!counter.isSentenceEndingPunctuation(word)) {
    		sentence += word + " ";
    		word = randomlyChooseNextWord(word);
    	}
    	sentence += word;
    	return sentence;
    }

    // randomly choose a word that starts with a capital letter, and use that as the first word of the sentence
    // then randomly generate the rest of the sentence using generateRandomSentence(String firstWord)
    public String generateRandomSentence() {
    	String firstWord = randomlySelectWord(counter.getAllWordsThatStartWithACapitalLetter());
    	return generateRandomSentence(firstWord);
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
