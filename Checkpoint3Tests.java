package textGen3;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import testHelp.verify;

public class Checkpoint3Tests {
	SentenceGenerator generator;
	
	@Before
	public void setUp() throws Exception {
		generator = new SentenceGenerator("cp3_tests.txt");
	}
	
	@Test
	public void testSentenceCreationWithStarterWord() {
		verify.that(generator.generateRandomSentence("This")).isEqualTo("This is a test.");
	}

	@Test
	public void testSentenceCanEndWithQuestionMark() {
		verify.that(generator.generateRandomSentence("Only")).isEqualTo("Only three paths?");
	}
	
	@Test
	public void testSentenceCanEndWithExclaimationMark() {
		verify.that(generator.generateRandomSentence("Few")).isEqualTo("Few solutions exist!");
	}
	
	@Test
	public void testSentenceCreationWithoutStarterWord() {
		String sentence = generator.generateRandomSentence();
		boolean isValidSentence = sentence.equals("This is a test.")
				|| sentence.equals("Few solutions exist!")
				|| sentence.equals("Only three paths?");
		
		verify.that(isValidSentence).isTrue();
	}
	
	@Test
	public void testCommasDoNotHaveWhiteSpaceOnBothSides() {
		verify.that(generator.generateRandomSentence("what")).isEqualTo("what, the llama?");
	}
	
	@Test
	public void testRandomWordSelectionWhenGeneratingSentence() {
		for (int i = 0; i < 10; ++i) {
			String sentence = generator.generateRandomSentence("New");
			verify.that(hasWords(sentence, "foo", "New", "baz", "bar")).isTrue();
			verify.that(sentence.charAt(sentence.length() - 1)).isEqualTo('.');
		}
	}

	private boolean hasWords(String sentence, String required, String... expectedWords) {
		List<String> expected = Arrays.asList(expectedWords);
		boolean foundRequired = false;
		
		for (String word : sentence.replace(".",  "").split(" ")) {
			if (word.equals(required)) {
				foundRequired = true;
				continue;
			}
			
			if (!expected.contains(word)) {
				return false;
			}
		}
		
		return foundRequired;
	}
}