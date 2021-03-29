
public class Card {
	
	private int value;
	private String name;
	
	public Card(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public void describe(Card card) {
		System.out.println(card.getName() + " -> " + card.getValue());
	}
}
