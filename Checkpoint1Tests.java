package textGen1;

import org.junit.Before;
import org.junit.Test;

import testHelp.verify;

public class Checkpoint1Tests {
	TextAnalyzer wc;
	
	@Before
	public void setUp() throws Exception {
		wc = new WordCounter("tale_of_two_cities_tokenized.txt");
	}

	@Test
	public void testWordCounts() {
		verify.that(wc.getWordCounts("It") == 1);
		verify.that(wc.getWordCounts("it") == 9);
		verify.that(wc.getWordCounts("was") == 11);
		verify.that(wc.getWordCounts("of") == 12);
	}
	
	@Test
	public void testMostCommonWord() {
		String mostCommonWord = wc.getMostCommonWord();
		String expectedMostCommonWord = ",";
		verify.that(expectedMostCommonWord.equals(mostCommonWord));
	}
	
	@Test
	public void testStartsWithCapitalLetter() {
		verify.that(wc.startsWithCapitalLetter("It"));
		verify.that(wc.startsWithCapitalLetter("BY"));
		verify.that(wc.startsWithCapitalLetter("A"));
		
		verify.that(!wc.startsWithCapitalLetter("tt"));
	}
	
	@Test
	public void testIsSentenceEndingPunctuation() {
		verify.that(wc.isSentenceEndingPunctuation("."));
		verify.that(wc.isSentenceEndingPunctuation("?"));
		verify.that(wc.isSentenceEndingPunctuation("!"));
		
		verify.that(!wc.isSentenceEndingPunctuation("a"));
	}

}
