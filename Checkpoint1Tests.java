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
		verify.that(wc.getWordCounts("It")).isEqualTo(1);
		verify.that(wc.getWordCounts("it")).isEqualTo(9);
		verify.that(wc.getWordCounts("was")).isEqualTo(11);
		verify.that(wc.getWordCounts("of")).isEqualTo(12);
	}
	
	@Test
	public void testMostCommonWord() {
		String mostCommonWord = wc.getMostCommonWord();
		String expectedMostCommonWord = ",";
		verify.that(expectedMostCommonWord).isEqualTo(mostCommonWord);
	}
	
	@Test
	public void testStartsWithCapitalLetter() {
		verify.that(wc.startsWithCapitalLetter("It")).isTrue();
		verify.that(wc.startsWithCapitalLetter("BY")).isTrue();
		verify.that(wc.startsWithCapitalLetter("A")).isTrue();
		
		verify.that(wc.startsWithCapitalLetter("tt")).isFalse();
	}
	
	@Test
	public void testIsSentenceEndingPunctuation() {
		verify.that(wc.isSentenceEndingPunctuation(".")).isTrue();
		verify.that(wc.isSentenceEndingPunctuation("?")).isTrue();
		verify.that(wc.isSentenceEndingPunctuation("!")).isTrue();
		
		verify.that(wc.isSentenceEndingPunctuation("a")).isFalse();
	}
}
