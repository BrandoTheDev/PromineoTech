/*
* Create a new class called Loops. 
* In the main method of this class, create the following loops with any variables you feel are needed. 
*/
public class Loops {
	public static void main(String[] args) {
		
		// A while loop that prints all even numbers from 0 to 100
		int i = 0;
		while (i < 101) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		
		// A while loop that prints every 3rd number going backwards from 100 until we reach 0
		int j = 100;
		while (j >= 0) {
			j -= 3;
			System.out.println(j);
		}
		
		// A for loop that prints every other number from 1 to 100
		for (int k = 0; k <= 100; k+=2) {
			System.out.println(k);
		}
		
		
		/*
		 * A for loop that prints every number from 0 to 100, 
		 * but if the number is divisible by 3, it prints “Hello” instead of the number, 
		 * and if the number is divisible by 5, it prints “World” instead of the number, 
		 * and if it is divisible by both 3 and 5, it prints “HelloWorld” instead of the number.
		 * 
		 */
		for (int l = 0; l <= 100; l++) {
			if (l % 5 == 0 && l % 3 == 0) {
				System.out.println("HelloWorld");
			}
			else if (l % 5 == 0) {
				System.out.println("World");
			}
			else if (l % 3 == 0) {
				System.out.println("Hello");
			}	
			else {
				System.out.println(l);
			}
		}
	}
}
