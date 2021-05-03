public class Card {

    private int value;
    private String name;
    private String suit;

    public Card(String name, String suit, int value) {
	this.suit = suit;
	this.name = name;
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public String getName() {
	return name;
    }

    public String getSuit() {
	return suit;
    }

    public void describe(Card card) {
	System.out.println(card.getName() + card.getSuit() + " = " + card.getValue());
    }
}
