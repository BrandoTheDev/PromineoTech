
public class App {

	public static void main(String[] args) {
		// Question 1
		// Inside the main method, create two variables for the following real-life examples and assign them values
		double itemPrice1 = 42.00;
		double itemPrice2 = 13.37;
		
		//Declaring and Initializing variables to avoid errors in Question 2
		double moneyInWallet1 = 100.00;
		double moneyInWallet2 = 100.00;
		int numberOfFriends = 40;
		int myAge = 28;
		String firstName = "Brandon";
		String lastName = "Thiem";
		char middleInitial = 'S';
		
		// Question 2
		//  Create the following variables by performing operations on the variables created in the previous step
		double myMoneyAfterPurchase = moneyInWallet1 - itemPrice1;
		double myFriendsMoneyAfterPurchase = moneyInWallet2 - itemPrice2;
		int friendsPerYear = numberOfFriends / myAge; 
		String myFullName = firstName + " " + middleInitial + " " + lastName;
		
		System.out.println("I have $" + myMoneyAfterPurchase + " after purchasing item 1.");
		System.out.println("My friend has $" + myFriendsMoneyAfterPurchase + " after purchasing item 2.");
		System.out.println("I have made about " + friendsPerYear + " friends every year.");
		System.out.println("My full name is " + myFullName);		

	}

}