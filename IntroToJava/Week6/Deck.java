import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();
    private Map<Integer, String> rankAndValue = new HashMap<Integer, String>();
    private String[] suits = { " of Hearts", " of Spades", " of Diamonds", " of Clubs" };

    public Deck() {
	initCardMap();
	for (String suit : suits) {
	    rankAndValue.forEach((value, name) -> cards.add(new Card(name, suit, value)));
	}
    }

    private void initCardMap() {
	rankAndValue.put(2, "Two");
	rankAndValue.put(3, "Three");
	rankAndValue.put(4, "Four");
	rankAndValue.put(5, "Five");
	rankAndValue.put(6, "Six");
	rankAndValue.put(7, "Seven");
	rankAndValue.put(8, "Eight");
	rankAndValue.put(9, "Nine");
	rankAndValue.put(10, "Ten");
	rankAndValue.put(11, "Jack");
	rankAndValue.put(12, "Queen");
	rankAndValue.put(13, "King");
	rankAndValue.put(14, "Ace");
    }

    public void shuffle() {
	Collections.shuffle(cards);
    }

    public Card draw() {
	Card removedFromDeck = cards.remove(0);
	return removedFromDeck;
    }
}
