# MarkovTextGen
Generate simple English text using Markov chains. Implemented in Java. Intended for APCS high school students.

One interesting area of computer science is natural language processing: writing software like Siri to recognize and understand human speech, or to generate new sentences. 

It would be great if a program could understand a single sentence, but this is incredibly difficult. A better solution is to learn from examples. We can write software to read example sentences, and count words and phrases.

The easiest way to read in a file is to use a Scanner and a class called FileReader, like the example below. A Scanner can scan through a textfile using the usual methods: hasNext(), next(), nextLine(), etc.

```
String filename = "book.txt";
FileReader file = new FileReader(filename);
Scanner fileScanner = new Scanner(file);
```


## HashMap

Another useful class is a HashMap. A HashMap stores a mapping from one class to another. For example, a HashMap to store student grades might map from a student's name to their grade. HashMaps are similar to ArrayLists: you don't need to know its size ahead of time, just its type. 

```
import java.util.HashMap;

public class StudentGrades {
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
	if (grades.containsKey(studentName))
	{
	    double grade = grades.get(studentName);
	    System.out.println(studentName + " has a grade of " + grade);
	} else
	{
	    System.out.println("No grades stored for " + studentName);
	}

    }
}
```

## Checkpoint 1

For Checkpoint 1, you'll write a class called `main.TextGenerator.WordCounter` that reads in a text file called "alice.txt" and counts how many times each word occurs. The program should scan through the entire text file, and has a HashTable to count how many times each word occurs. There should be a method with the signature

`public int getWordCounts(String word)`

that returns how many times a word occurs in the text, or 0 if the word doesn't occur anywhere. For example, `getWordCounts("Cheshire")` should return `6`. `getWordCounts("jumped") should return `5`.

You will probably want to use a `FileReader` to read in the text file, and a `HashMap<String, Integer>` to count how many times each word occurs.

You should also add the following methods:

`public String getMostCommonWord()' returns the word that occurs most often in the text

`public int getCountOfMostCommonWord()` returns how often the most common word occurs in the text

`public String getSecondMostCommonWord()' returns the word that occurs second most often in the text

## Checkpoint 2

For checkpoint 2, you'll expand the capability of the `main.TextGenerator.WordCounter`. Add a method `public ArrayList<String>` getWordsThatFollow(String previousWord). Given a word that occurs, the program should return an ArrayList of every word that could possibly occur next.

For example, `getWordsThatFollow("Cheshire")` should return `[cat, cats, Cat, Cat:, Cat, Cat]`. The order of this list does not matter. `getWordsThatFollow("jumped") should return [up, into, up, up, up].



## Checkpoint 3

For Checkpoint 3, you'll create a new class called `main.TextGenerator`. The `main.TextGenerator` class should have a `main.TextGenerator.WordCounter` class. It should also have a new method

`public void generateRandomSentence(String firstWord)`

This method should generate and print out a random sentence starting with `firstWord`. To find the next word, it should call `getWordsThatFollow(firstWord)` and randomly choose one of the words that can come ofter `firstWord`. It should keep generating a random word until it generates sentence-ending punctuation: '.', '?', or '!'.

For example, say we call `generateRandomSentence("Alice")`.  ...
`getWordsThatFollow("Alice")` returns a very large list, which includes `[was, think, started, after, had ...]`

Let's say it randomly chooses the word "was". The program would now call `getWordsThatFollow("was")`. This also returns a large list of options, which includes: `[beginning, reading, considering, nothing, just, to, very, going, coming, too, sneezing ...]`

Let's say it randomly chooses the word "always". Calling `getWordsThatFollow("always")` returns a much shorter list: `[HATED, ready, ready, growing, grinned;, six, tea-time, took, getting, pepper, get]`

Let's say it randomly chooses the word "tea-time". There are only two options for the next word: `[., ,]`

Let's say it randomly chooses ".". This is punctuation that would could end a sentence, so we'll end our sentence here. Alice was always tea-time .


