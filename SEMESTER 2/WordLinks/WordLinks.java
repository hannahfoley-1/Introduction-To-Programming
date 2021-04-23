import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have defined my method as a public static and it returns an array of strings which consists of the word in the dictionary
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Yes, my method does this, reading the words one at a time from the file
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: Yes, my program returns an array of Strings. 

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, i have defined my method as a public static which will return an ArrayList of Strings each of which is one of the words entered in the input
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: Yes, my method does this by getting the word count, then filling an array of this size with the Strings entered (without their commas)

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, my method is public static and returns a boolean true if the words are unique and otherwise, false
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: Yes, my method takes each word in the array and compares it with every other word in the array, being carful to not compare it to 
  itself which would result in mistakingly returning false from the function
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Yes, as soon as a match is found, false is returned as not to continue with the function
- Returns true is all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: Yes, my function returns true is all the words are unique and false otherwise

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes my method is public static and returns a boolean true or false
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment: Yes, my method makes use of binary search from the array library class to find the sent in word in the dictionary
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: yes, if the value returned from the binary search is not less than 0, then true is returned as the value has been found in the dictionary

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: yes my method is public static and takes the correct parameters of 2 strings and returns a boolean 
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: yes my method compares the characters at the same indexes in each word, if a difference is found the differnce count is incremented by 1, the method will only
  continue so long as the difference count is less than or equal to 1

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: yes my method has the correct name and is public static, it returns a boolean
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment: yes, my method calls the other methods within the wordlinks class and prints out whether the word link is successful or not back in the main based 
  on the boolean result

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: My file is entered as a file and a scanner reads it in the function readDictionary
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: yes, my main takes in user input and so long as the input has words, calls isWordChain

 Total Mark out of 100 (Add all the previous marks): 100
*/
public class WordLinks {

	public static void main(String[] args) throws IOException {
		File words = new File ("words");
		
		//read dictionary and make array
	    String [] dictionaryWords = null;
		dictionaryWords = readDictionary(words);
		
		boolean quit = false;
		Scanner input = new Scanner (System.in);
		
		while (!quit)
		{
			//ask for user input
			System.out.println("Enter a comma separated list of words (or an empty list to quit):   ");
			String listEntered = input.nextLine();
			
			if (listEntered != null)
			{
				//create array list from input words
				ArrayList<String> enteredWordsArr = readWordList(listEntered);
				if (enteredWordsArr.size() == 0)
				{
					quit = true;
				}
				else
				{
					//send this array list to isWordChain
					boolean wordChain = isWordChain(enteredWordsArr, dictionaryWords);
					if (wordChain)
					{
						System.out.println("Valid chain of words from Lewis Carroll's word-links game. ");
					}
					else
					{
						System.out.println("Not a valid chain of words from Lewis Carroll's word-links game. ");
					}
				}
			}
			else
			{
				quit = true;
			}
		}
	}
		//readDictionary which reads all the English words within the file "words.txt" and which returns all the read words as an array or an
		//ArrayList of String values (objects). 
		public static String[] readDictionary(File words) throws IOException
		{
			Scanner scanner = new Scanner(words);
			
			String [] dictArray = new String[0];
			String [] tempArray = new String[dictArray.length + 1];
			
			while(scanner.hasNext())
			{
				String currentWord = scanner.next();
				if (!currentWord.equals(","))
				{
					tempArray[dictArray.length] = currentWord;
					dictArray = tempArray;
				}
				String [] temp2 =  Arrays.copyOf(tempArray, tempArray.length+1);
				tempArray = temp2;
			}
			scanner.close();
		    return dictArray;
		}
		
		
		//readWordList which reads a comma (,) separated String of words from the standard input and which returns the list represented as an
		// array or an ArrayList of String values (objects).
		public static ArrayList<String> readWordList (String input)
		{
			ArrayList<String> enteredWordsArr = new ArrayList<String>();
			
			//counting the number of words in the list entered
	        int wordCount = 0;  
	        char ch[ ]= new char[input.length()];     
	        for(int i = 0; i < input.length(); i++)  
	        {  
	            ch[i]= input.charAt(i);  
	            if(((i > 0) && (ch[i] != ' ') && (ch[i-1] == ' '))||((ch[0] != ' ') && (i == 0))) 
	            {
	                 wordCount++;  
	            }  
	        }
			
			Scanner scanner = new Scanner (input);
			
			//putting the words in the list entered into an array list
			for (int i = 0; i < wordCount; i++)
			{
				//if were on the last word, there wont be a comma so we can add it without taking away the comnna
				String currentWord = scanner.next(); 
				String wordWithoutComma = "";
				if (i != wordCount-1)
				{
					int currentWordLength = currentWord.length();
					for (int j = 0; j < currentWordLength-1; j++)
					{
						//get the word without comma to enter as the string into the array list
						char currentChar = currentWord.charAt(j);
						wordWithoutComma += currentChar;
					}
				}
				else
				{
					wordWithoutComma = currentWord;
				}
				//add word to array list
				enteredWordsArr.add(i, wordWithoutComma);
			}
			scanner.close();
			return enteredWordsArr;
		}
		
		
		//isUniqueList takes an array or an ArrayList of String values and which determines whether list contains unique String values, 
		// i.e., no two String values at different locations in the array are equal.
		public static boolean isUniqueList (ArrayList<String> Strings) 
		{
			for (int i = 0; i < Strings.size(); i++)
			{
				String compare1 = Strings.get(i);
				for (int j = 0; j < Strings.size(); j++)
				{
					if (i != j)
					{
						String compare2 = Strings.get(j);
						if (compare1.equalsIgnoreCase(compare2)) 
						{
							return false;
						}
					}
				}
			}
			return true;
			
		}
		
		
		//isEnglishWord which takes a String value and which determines whether the String value is an English word.
		//[Hint: Use the binarySearch function (static method) from the library class Arrays (which contains static methods for manipulating arrays) 
		//to search for the String value in the array of Strings formed from reading the file "words.txt".]
		public static boolean isEnglishWord (String word, String[] dictionaryWords)
		{
			if (Arrays.binarySearch(dictionaryWords, word) != -1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//isDifferentByOne which takes two Strings and which determines whether the two Strings are of the same length and
		//differ by exactly one character only.
		public static boolean isDifferentByOne (String string1, String string2)
		{
			int lengthst1 = string1.length();
			int lengthst2 = string2.length();
			
			int differences = 0;
			
			if (lengthst1 == lengthst2)
			{
				while (differences < 1)
				{
					for (int i = 0; i < lengthst1; i++)
					{
						char string1ch = string1.charAt(i);
						char string2ch = string2.charAt(i);
						if (string1ch != string2ch)
						{
							differences ++;
						}
					}
				}
				if (differences > 1)
				{
					return false;
				}
				else
				{
					return true;
				}
				
			}
			else
			{
				return false;
			}
			
		}
		
		
		//isWordChain which takes a list of words (represented as an array or an ArrayList of Strings) and which determines whether the list
		//of words is a valid chain of words for Lewis Carroll's word-links game.
		public static boolean isWordChain(ArrayList<String> words, String [] dictionaryWords)
		{
			// 1. check if all the words are valid in English
			for (int i = 0; i < words.size(); i++)
			{
				String currentWord = words.get(i);
				boolean isEnglishWord = isEnglishWord(currentWord, dictionaryWords);
				if (!isEnglishWord)
				{
					return false;
				}
			}
			
			//2. Check that all the strings in the list are unique
			boolean isUniqueList = isUniqueList(words);
			if (!isUniqueList)
			{
				return false;
			}
			
			//3. check that all words only differ by one char
			for (int i = 0; i < words.size()-1; i++)
			{
				String string1 = words.get(i);
				String string2 = words.get(i+1);
				boolean isDifferentByOne = isDifferentByOne(string1, string2);
				if (!isDifferentByOne)
				{
					return false;
				}
			}
			
			// if all these tests have been passed - return true
			return true;
		}
		

	

}
