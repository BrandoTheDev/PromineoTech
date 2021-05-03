
public class App {

	public static void main(String[] args) {
		
		// Instantiate a Deck and two Players, call the shuffle method on the deck.
		Deck deck = new Deck();
		
		Player player1 = new Player("Brandon");
		Player player2 = new Player("Tony");
		deck.shuffle();
		
		// Loop for every card in the deck. 52 cards / 2 players = 26
		for (int i = 0; i < 26; i++) {
			player1.draw(deck);
			player2.draw(deck);
		}
		
		// Flip through every card in both players hands to see who has the higher value per turn
		for (int i = 0; i < 26; i++) {

			int player1Card = player1.flip(player1.flipCard());
			int player2Card = player2.flip(player2.flipCard());
			
			player1.describe();
			player2.describe();
			
			// Increment the players score with the higher value card
			if (player1Card == player2Card) {
				System.out.println("*** WAR! ***");
			} else if (player1Card > player2Card) {
				player1.incrementScore();
			} else {
				player2.incrementScore();
			}
		}
		
		// After the loop, compare the final score from each player
		// Print the final score of each player and either “Player 1”, “Player 2”, or “Draw” depending on which score is higher or if they are both the same.
		int player1Score = player1.getScore();
		int player2Score = player2.getScore();
		
		if (player1Score == player2Score) {
			System.out.println("The game is a DRAW!");
			System.out.println(player1.fancyScore());
			System.out.println(player2.fancyScore());
		} else if (player1Score > player2Score) {
			System.out.println(player1.getName() + " WINS!");
			System.out.println(player1.fancyScore());
			System.out.println(player2.fancyScore());
		} else {
			System.out.println(player2.getName() + " WINS!");
			System.out.println(player1.fancyScore());
			System.out.println(player2.fancyScore());
		}
	}
}
