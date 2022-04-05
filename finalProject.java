package finalProject;
import java.util.Scanner;
public class finalProject {

	public static void main(String[] args) {
		final int arrsize = 100;// how big my array is in case they want to write 100 words 
		int useSize = 0;// the number of words that are actually on the array
		Scanner std = new Scanner(System.in);
		int menuResponce;
		String [] words = new String[arrsize];
		String word;
		
		System.out.println("Welcome to WordList!\n"
				+ "--------------------");
		 do {// keeps everything in a loop until the person quits with 4
			 menuResponce = getMenuChoice(std);
			 System.out.println(" ");			 
			 if (menuResponce == 1) {// this if checks what menu option the user inputed and does something according to the input
				 System.out.print("Enter the word to add to the word list: ");
				 word = std.next();
				 System.out.println(" ");
				 boolean add = addWord(words, useSize, word);
			if (add == true){// checks if it was able to add the word or not 
				System.out.println(word + " has been added\n");
				++useSize;
			}else {
				System.out.println(word + " is alredy present\n");
			}
			
			 }else if(menuResponce == 2) {
				 System.out.print("Enter the word you want to remove from word list: ");
				 word = std.next();
				 System.out.println(" ");
				  boolean remove = removeWord(words, useSize, word);
				  if (remove == true){// checks if it was able to remove the word or not 
						System.out.println(word + " has been removed\n");
						--useSize;
					}else {
						System.out.println(word + " is not present\n");
					}
			 }else if(menuResponce == 3) {
				 printWords(words, useSize);
			 }
	}while (menuResponce != 4);
		 System.out.println("Thank you for using our service! :)");
		std.close();// closing the scanner
	}
	
	public static boolean addWord(String[] words, int numWords, String word) {
		int check = findWord(words, numWords, word);
		if (check == -1) {
			words[numWords] = word;
			return true;
		}
		
		return false;
	}
	//This method adds the word parameter to the words array only if words does not already contain it.
	//It returns true if word was added to words; false otherwise.
	public static boolean removeWord(String[] words, int numWords, String word) {
		int check = findWord(words, numWords, word);
		if (check != -1) {
			for (int i = check; i < numWords -1; ++i) {
				words[i] = words [i + 1];
				
			}
			return true;
		}
		
		return false;
	}
	//This method removes the word parameter from the words array only if words contains it. It returns
	//true if word was found and removed from words; false otherwise.
	public static void printWords(String[] words, int numWords) {
		if (numWords >= 1) {// protects the code in case there's no words in the array 
			sort(words, numWords);
			System.out.print("[");
			for (int i = 0; i < numWords- 1; ++i) {
				System.out.print(words[i] + ", ");
			}
			System.out.print(words[numWords - 1] + "]\n\n");
		}else System.out.println("You dont have any words in the list\n");
	}
		
	//This method first sorts the elements in the words parameter, then prints them to the screen.
	private static int findWord (String[] words, int numWords, String word) {
		for (int i = 0; i <= numWords - 1; ++i) {
			if (words[i].equals(word)){
				return i;
			}
		}
		return -1;
	}
	//This method searches for the word parameter in the words array. If found, it returns the index of
	//word; otherwise it returns -1.
	private static int getMenuChoice(Scanner std) {
		//I'm using string instead of integer in case the user inputs a letter and not a number
		String r;
		System.out.println("1. Add Word\n"
				+ "2. Remove Word\n"
				+ "3. Print Words\n"
				+ "4. Quit\n");
		do {
		System.out.print("Choose an option (1-4): ");
		
		r = std.next();
		}while(!(r.equals("1") || r.equals("2") || r.equals("3") || r.equals("4"))); 
		int num = Integer.parseInt(r);// after getting a String that is 1-4 this changes that string into a number
		return num;
	}
	//This method prints the menu options to the screen, reads in the user’s selection, and validates it. It
	//returns the valid option selection.
	public static void sort(String[] words, int numWords)// this sords the array of words using two different methods 
	  {
	    int loc;
	    for (int i = 0; i < numWords - 1; ++i)
	    {
	      loc = findMin(words, i, numWords-1);
	      swap(words, i, loc);
	    }
	  }
	public static int findMin(String [] words, int start, int end)// finds the  min value in the array 
	  {
	    int minSoFarLoc = start;
	    for (int i = start+1; i <= end; ++i)
	      if ( words[i].compareTo(words[minSoFarLoc]) < 0 ) {
	        minSoFarLoc = i;
	      }
	    return minSoFarLoc;
	  }
	public static void swap(String[] words, int ind1, int ind2)// this swaps two words from the array
	  {
	    String tmp = words[ind1];
	    words[ind1] = words[ind2];
	    words[ind2] = tmp;
	  }
}
