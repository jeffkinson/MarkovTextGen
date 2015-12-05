import java.util.ArrayList;

public interface TextAnalyzer {
    /*
     *  Checkpoint 1 methods
     */

    // return how many times a word occurs
    int getWordCounts(String word);

    // return the word that occurs most often in the text
    String getMostCommonWord();

    // return the word that occurs second most often in the text
    String getSecondMostCommonWord();

    // return the count of the most common word
    int getCountOfMostCommonWord();

    // return true if the word starts with a capital letter; false otherwise
    boolean startsWithCapitalLetter(String word);

    /*
     *  Checkpoint 2 methods
     *  For Checkpoint  1, your code will have to include these methods, but they will not be tested until Checkpoint 2
     *  You can just return null for now, or throw new UnsupportedOperationException();
     */

    // given a word from the text, return a list of all the words that could come next. Includes duplicates.
    ArrayList<String> getWordsCouldComeNext(String prevWord);

    // return a list of all the words in the text that start with a capital letter. Includes duplicates.
    ArrayList<String> getAllWordsThatStartWithACapitalLetter();
}