package u6pp;
public class Deck{
	Card[] Deck = new Card[52];
	int progressInDeck = 0;
	public Deck(){
		int d = 0;
			for(int i = 0; i < 4; i++) {
				for(int x = 0; x < 13; x++) {
					Deck[d] = new Card(Card.SUITS[i],Card.VALUES[x]);
					d++;
					
				}
			}
			
		
	}
	public int numLeft() {
		return Deck.length - progressInDeck;
	}

	
	public Card deal() {
		int temp = progressInDeck;
		progressInDeck++;
		return Deck[temp];
	
		
	}
	
	public void shuffle() {
		Card A;
		progressInDeck = 0;
		int rand;
		for(int i = 0; i < Deck.length; i++) {
			rand = (int)(Math.random()*51);
			A = Deck[i];
			Deck[i] = Deck[rand];
			Deck[rand] = A;
		}
			
		
	}
	
	
	
}