
public class App {
	public static void main(String[] args) {
		// In Eclipse, create the following Boolean variables and choose what values they hold:
		boolean isHotOutside = true;
		boolean isWeekday = true;
		boolean hasMoneyInPocket = true;
		
		// Create the following variables (not boolean type, choose the best data type for the variable):
		double costOfMilk = 3.15;
		float moneyInWallet = 20;
		int thirstLevel = 3;
		
		// Using the variables you created above and Boolean operators, create variables for the following scenarios:
	
		//this should be true if it is hot outside and there is money in your pocket
		boolean shouldBuyIcecream = isHotOutside && hasMoneyInPocket;
		System.out.println("Should you buy icecream? " + shouldBuyIcecream);
		
		// this should be true if it is hot outside and it is not a weekday
		boolean willGoSwimming = isHotOutside && !isWeekday; 
		System.out.println("Will you go swimming? " + willGoSwimming);
		
		// this should be true if it is hot outside, there is money in your pocket, and it is not a weekday
		boolean isAGoodDay = isHotOutside && hasMoneyInPocket && !isWeekday;
		System.out.println("Is today a good day? " + isAGoodDay);
		
		// this should be true if it is hot outside, and thirstLevel is greater than or equal to 3, 
		// and moneyInWallet is greater than or equal to 2 times the cost of milk.
		boolean willBuyMilk = isHotOutside && thirstLevel >= 3 && moneyInWallet >= (costOfMilk * 2);
		System.out.println("Will you buy milk? " + willBuyMilk);
	}
}