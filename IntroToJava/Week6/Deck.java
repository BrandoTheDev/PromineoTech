import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		Card ace = new Card("ace", 1);
		Card two = new Card("two", 2);
		Card three = new Card("three", 3);
		Card four = new Card("four", 4);
		Card five = new Card("five", 5);
		Card six = new Card("six", 6);
		Card seven = new Card("seven", 7);
		Card eight = new Card("eight", 8);
		Card nine = new Card("nine", 9);
		Card ten = new Card("ten", 10);
		Card jack = new Card("jack", 11);
		Card queen = new Card("queen", 12);
		Card king = new Card("king", 13);
	
		for(int i = 0; i < 4; i ++) {
			cards.add(ace);
			cards.add(two);
			cards.add(three);
			cards.add(four);
			cards.add(five);
			cards.add(six);
			cards.add(seven);
			cards.add(eight);
			cards.add(nine);
			cards.add(ten);
			cards.add(jack);
			cards.add(queen);
			cards.add(king);
		}
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	} 

	
	public Card draw() {
		Card removedFromDeck =  cards.remove(0);
		return removedFromDeck;
	}
}
