import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private int score;
	private String name;
	
	public Player(String name) {
		this.name = name;
		score = 0;
	}
	
	public void describe() 
	{
		if (hand.size() >= 0) {
			System.out.println(name + " has " + hand.get(hand.size()-1).getName());
		}
	}
	
	public int flip(Card flipCard)
	{
		return flipCard.getValue();
	}
	
	public Card flipCard() {
		Card topCard = hand.remove(hand.size()-1);
		return topCard;
	}
	
	public void draw(Deck deck)
	{
		hand.add(deck.draw());
	}
	
	public void incrementScore() {
		score += 1;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}
	
	public String fancyScore() {
		return name + " has a score of " + score;
	}

}
