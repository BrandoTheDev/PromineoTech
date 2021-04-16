
public class App {
	public static void main(String[] args) {
		
		
		//Create an array of int called ages that contains the following values: 3, 9, 23, 64, 2, 8, 28, 93
		int[] ages = new int[9];
		ages[0] = 3;
		ages[1] = 9;
		ages[2] = 23;
		ages[3] = 64;
		ages[4] = 2;
		ages[5] = 8;
		ages[6] = 28;
		ages[7] = 93;
		
		
		// Programmatically subtract the value of the first element in the array from the value in the last element of the array 
		// (i.e. do not use ages[7] in your code). Print the result to the console.
		// Add a new age to your array and repeat the step above to ensure it is dynamic (works for arrays of different lengths).
		System.out.println(ages[0] - ages[ages.length-1]);
		ages[8] = 3;
		System.out.println(ages[0] - ages[ages.length-1]);
		
		
		//Use a loop to iterate through the array and calculate the average age. Print the result to the console
		int result = 0;
		for (int age : ages) {
			result += age;
		}
		System.out.println(result / ages.length);
		
		
		 // Create an array of String called names that contains the following values: “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		String[] names = new String[6];
		names[0] = "Sam";
		names[1] = "Tommy";
		names[2] = "Tim";
		names[3] = "Sally";
		names[4] = "Buck";
		names[5] = "Bob";
		
		
		//Use a loop to iterate through the array and calculate the average number of letters per name. Print the result to the console.
		int sum = 0;
		for (String name : names) {
			sum += name.length();
		}
		System.out.println(sum / names.length);
		
		
		//Use a loop to iterate through the array again and concatenate all the names together, separated by spaces, and print the result to the console.
		String connectedNames = "";
		for (String name : names) {
			connectedNames += name;
			connectedNames += " ";
		}
		System.out.println(connectedNames);
		
		
		//Create a new array of int called nameLengths. Write a loop to iterate over the previously created names array and add the length of each name to the nameLengths array.
		int[] nameLengths = new int[6];	
		for(int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
		}
		
		
		// Write a loop to iterate over the nameLengths array and calculate the sum of all the elements in the array. Print the result to the console.
		int sumOfNameLength = 0;
		for (int nameLength : nameLengths) {
			sumOfNameLength += nameLength;
		}
		System.out.println(sumOfNameLength);

	}
	
	
	//Write a method that takes a String, word, and an int, n, as arguments and returns the word concatenated to itself n number of times
	public static String echo(String word, int repeat) {
		String phrase = "";
		for(int i = 0; i < repeat; i++) {
			phrase += word;
		}
		return phrase;
	}
	
	//Write a method that takes two Strings, firstName and lastName, and returns a full name 
	public static String fullname(String firstName, String lastName) {
		return firstName + " " + lastName;
	}
	
	//Write a method that takes an array of int and returns true if the sum of all the ints in the array is greater than 100.
	public static boolean isOverOneHundred(int[] arr) {
		int sum = 0;
		for (int n : arr) {
			sum += n;
		}
		return sum > 100;
	}
	
	//Write a method that takes an array of double and returns the average of all the elements in the array.
	public static double arrayAverage(double[] arr) {
		double result = 0;
		for (double n : arr) {
			result += n;
		}
		return result / arr.length;
	}
	
	//Write a method that takes two arrays of double and returns true 
	//if the average of the elements in the first array is greater than the average of the elements in the second array.
	public static boolean isFirstArrayBigger(double[] arr1, double[] arr2) {
		double firstArrSum = 0, secondArrSum = 0;
		for(double n : arr1) {
			firstArrSum += n;
		}
		for(double n: arr2) {
			secondArrSum += n;
		}
		
		double firstArrResult = firstArrSum / arr1.length;
		double secondArrResult = secondArrSum / arr2.length;
		
		return firstArrResult > secondArrResult;
	}
	
	//Write a method called willBuyDrink that takes a boolean isHotOutside, and a double moneyInPocket, 
	//and returns true if it is hot outside and if moneyInPocket is greater than 10.50.
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		return isHotOutside && moneyInPocket > 10.50;
	}
	
	// This method checks if your custom license plate is valid
	// First parameter is boolean to see if the plate is vanity as vanity plates get 1 char increased in length.
	// Second parameter is a string of characters to check for fitting
	// Returns a boolean true if the words will fit a plate
	public static boolean validForPlates(boolean isVanity, String words) {
		int wordLength = words.length();
		int minimumLetters = 5, maximumLetters = 7;
		if(isVanity) {
			maximumLetters++;
		}
		return wordLength >= minimumLetters && wordLength <= maximumLetters;
	}
	
}