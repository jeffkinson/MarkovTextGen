package textGen2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testHelp.verify;

public class Checkpoint2Tests {
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
	
	@Test
	public void testWordsThatStartWithCapitalLetter() {
	    verify.that(hasWords(wc.getAllWordsThatStartWithACapitalLetter(), "It", "Light", "Darkness", "Heaven"));
	}
	
	@Test
	public void testWordsThatCouldComeNext() {
		verify.that(hasWords(wc.getWordsThatCouldComeNext("It"),   "was"));
		verify.that(hasWords(wc.getWordsThatCouldComeNext("best"), "of"));
		verify.that(hasWords(wc.getWordsThatCouldComeNext("was"),  "so", "the", "the", "the", "the", "the", "the", "the", "the", "the", "the"));
		verify.that(hasWords(wc.getWordsThatCouldComeNext(","),    "for", "in", "it", "it", "it", "it", "it", "it", "it", "it", "it", "that", "the", "we", "we", "we", "we"));
	}
	
	private boolean hasWords(List<String> list, String... expectedWords) {
		Collections.sort(list);
		List<String> expectedWordsList = Arrays.asList(expectedWords);
		Collections.sort(expectedWordsList);
		return expectedWords.equals(list);
	}

}
