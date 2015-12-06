# Sentence Generator
Generate simple English text using Markov chains. Implemented in Java. Intended for APCS high school students.

One interesting area of computer science is natural language processing: writing software like Siri recognize and understand human speech, or to generate new sentences. 

There are many real-world scenarios where it's useful for a program to create new sentences. For example, Google Translate analyzes a sentence in a foreign language, and generates a new sentence in English with the same meaning. Siri listens to questions, and generates new sentences that answer those questions.

When programs generate sentences, they usually follow a simple trick. First, they analyze lots of existing sentences that are similar to what they want to generate, and record which words and phrases occur frequently. Then, they randomly choose phrases that occur, and rearrange them in a way that makes sense. 

In this lab, you'll write a program that studies an example of written English, analyzes the words and phrases, and then uses them to create new sentences. Your program will be sort of like a parrot: it doesn't really understand what it's saying, but it listens to and repeats words that it hears.

## But first...

Before getting started, there are a few Java classes that are very useful to know about for this lab.

### Reading text files
For several parts of this lab, your program will read in a text file. The easiest way to read in a file is to use a Scanner and a class called FileReader, like the example below. A Scanner can scan through a textfile using the usual methods: `hasNext()`, `next()`, `nextLine()`, etc.

```
String filename = "book.txt";
FileReader file = new FileReader(filename);
Scanner fileScanner = new Scanner(file);
```

### HashMap

Another useful class is a HashMap. A HashMap stores a mapping from one class to another. For example, a HashMap to store student grades might map from a student's name to their grade. HashMaps are similar to ArrayLists: you don't need to know its size ahead of time, just its type. 

```
import java.util.HashMap;

public class StudentGrades
{
    public static void main (String[] args)
    {
		HashMap<String, Double> gradebook = new HashMap<String, Double>();
	
		// store some student grades
		grades.put("Fred Flintstone", 98.0);
		grades.put("Barney Rubble", 59.8);
		
		// print out grades
		printGrade(gradebook, "Fred Flintstone");
		printGrade(gradebook, "Pebbles");
		printGrade(gradebook, "Barney Rubble");
	    }
	
	    private static void printGrade(HashMap<String, Double> grades, String studentName)
	    {
		if (grades.containsKey(studentName)) // check if we've entered any grades for the student
		{
		    double grade = grades.get(studentName); // if we have, retrieve them from the HashMap
		    System.out.println(studentName + " has a grade of " + grade);
		}
		else // if there aren't any grades stored
		{
		    System.out.println("No grades stored for " + studentName);
		}
    }
}
```

## Checkpoint 1

For Checkpoint 1, you'll write a class called `WordCounter` that reads in a text file and counts how many times each word occurs. 

Download the files `TextAnalyzer.java`, `tale_of_two_cities_tokenized.txt`, and `Checkpoint1Tests.java`. 

`TextAnalyzer.java` is an interface that your `WordCounter` class must implement. Note that some of your methods won't be tested until Checkpoint 2. For now, these methods can just return an empty string, or whatever type is appropriate for your method.

`tale_of_two_cities_tokenized.txt` is a text file containing the opening sentence of A Tale of Two Cities. We've tokenized the file by adding some extra spaces to separate some punctuation into separate tokens. Copy this file into the **root** directory of your project.

`Checkpoint1Tests.java` contains tests that your program should pass for this checkpoint.

The program should scan through the entire text file, one word at a time, and use a `HashMap` to count how many times each word occurs. There should be a method with the signature

`public int getWordCounts(String word)`

that returns how many times a word occurs in the text, or 0 if the word doesn't occur anywhere. For example, `getWordCounts("It")` should return `1`. `getWordCounts("it") should return `9`, and `getWordCounts("was")` should return 11.

You will probably want to use a `FileReader` to read in the text file, and a `HashMap<String, Integer>` to count how many times each word occurs.

You should also impelement the methods `getMostCommonWord()`, `getMostCommonWord()`, `startsWithCapitalLetter(String word)`, and `isSentenceEndingPunctuation(String word)`. Check the `TextAnalyzer` interface for information on what these methods should do.


## Checkpoint 2

For checkpoint 2, you'll expand the capability of the `WordCounter`. Create a new package called `textGen2`, and Download the `Checkpoint2Tests.java` file, and add them as tests to your project.

Implement method `public ArrayList<String>` getWordsThatCouldComeNext(String previousWord). Given a word that occurs, the program should return an ArrayList of every word that could possibly occur next.

For example, `getWordsThatCouldComeNext("It")` should return `["was"]`. 

`getWordsThatCouldComeAfter("was")` should return an `ArrayList` containing the elements `["so", "the", "the", "the", "the", "the", "the", "the", "the", "the", "the"]`. The order of this `ArrayList` doesn't matter, but the number times each element occurs does matter. Since the phrase `"was the"` occurs 10 times and the phrase `"was so"` appears once, the `ArrayList` returned should include `"the"` 10 times and `"so"` once.



## Checkpoint 3

For Checkpoint 3, you'll work on a class called `SentenceGenerator`. This class will use your existing `WordCounter` class to study the words and phrases in a text file, and then use those words and phrases to generate new sentences in the same style. But in order to make this interesting, we need a lot more text to learn from. Download the file `alice_tokenized.txt`, and put it in the same directory as `tale_of_two_cities_tokenized.txt`. 

Download the `SentenceGeneratorStarterCode.java` starter code, and rename it to `SentenceGenerator.java`. There are several methods here that you will have to implement, including the method

`public String generateRandomSentence()`

This method should generate and a random sentence starting with `firstWord`. To find the next word, it should call the `WordCounter` method `getWordsThatFollow(firstWord)` and randomly choose one of the words that can come ofter `firstWord`. It should keep generating a random word until it generates sentence-ending punctuation: '.', '?', or '!'.

For example, say we call `generateRandomSentence("Alice")`.  ...
`getWordsThatFollow("Alice")` returns a very large list, which includes `[was, think, started, after, had ...]`

Let's say it randomly chooses the word "was". The program would now call `getWordsThatFollow("was")`. This also returns a large list of options, which includes: `[beginning, reading, considering, nothing, just, to, very, going, coming, too, sneezing ...]`

Let's say it randomly chooses the word "always". Calling `getWordsThatFollow("always")` returns a much shorter list: `[HATED, ready, ready, growing, grinned;, six, tea-time, took, getting, pepper, get]`

Let's say it randomly chooses the word "tea-time". There are only two options for the next word: `[., ,]`

Let's say it randomly chooses ".". This is punctuation that would could end a sentence, so we'll end our sentence here. Alice was always tea-time .


Once you've implemented your program, try running it several times. It should output some interesting "sentences". Some of them will make more sence than others.
