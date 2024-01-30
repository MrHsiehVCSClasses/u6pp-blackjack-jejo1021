package u6pp;
import java.util.Scanner;

public class Blackjack{
	Scanner sc;
	Deck D;
	String playerName;
	Card[] playerHand;
	int playerHandProgress;
	int dealerHandProgress;
	Card[] dealerHand;

	public Blackjack() {
		sc = new Scanner(System.in);
		D = new Deck();
		playerHand = new Card[0];
		dealerHand = new Card[0];
	}
	
	public static int calcPoints(Card[] hand) {
		int count = 0;
		String test;
		for(int i = 0; i < hand.length; i++) {
			test = hand[i].getValue();
			if(test.equals("2")) {
				count += 2;
			}
			else if(test.equals("3")) {
				count += 3;
			}
			else if(test.equals("4")) {
				count += 4;
			}
			else if(test.equals("5")) {
				count += 5;
			}
			else if(test.equals("6")) {
				count += 6;
			}
			else if(test.equals("7")) {
				count += 7;
			}
			else if(test.equals("8")) {
				count += 8;
			}
			else if(test.equals("9")) {
				count += 9;
			}
			else if(test.equals("10")) {
				count += 10;
			}
			else if(test.equals("Jack") || test.equals("King") || test.equals("Queen")) {
				count += 10;
			}
			else if(test.equals("Ace")) {
				count += 11;
			}
		}
		return count;
	}
	public static String determineResult(Card[] userHand, Card[] dealerHand) {
		int userCount = calcPoints(userHand);
		int compCount = calcPoints(dealerHand);
		if(userCount > compCount || isBust(dealerHand)) {
			return "User Wins";
		}
		else if(userCount < compCount || isBust(userHand) || (isBust(userHand) && isBust(dealerHand))){
			return "User Loses";
		}
		else {
			return "User Pushes";
		}
		
		
	}
	public static boolean isBust(Card[] hand) {
		int handCount = calcPoints(hand);
		if(handCount > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean isBlackjack(Card[] hand) {
		
		int handCount = calcPoints(hand);
		if(handCount == 21 && hand.length == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean dealerKeepHitting(Card[] hand) {
		int handCount = calcPoints(hand);
		if(handCount <= 16) {
			return true;
		}
		else {
			return false;
		}
	}
//	private void playerDeal() {
//		playerHand[playerHandProgress] = D.deal();
//		playerHandProgress++;
//		if(D.progressInDeck > 51) {
//			D.shuffle();
//		}
//	}
//	private void dealerDeal() {
//		dealerHand[dealerHandProgress] = D.deal();
//		dealerHandProgress++;
//		if(D.progressInDeck > 51) {
//			D.shuffle();
//		}
//	}
	private String handToString(Card[] hand) {
		String handString = "";
		for(int i = 0; i < hand.length; i++) {
			handString += hand[i].toString() + " ";
		}
		return handString;
	}
	private boolean getYesNoInput(String prompt) {
		String input;
		boolean done = false;
		while(done == false) {
			System.out.println(prompt);
			String inputLine = sc.next();
			input = inputLine.substring(0,1);
			if(inputLine.length() > 0) {
				if(!(input.equals("Y")  || input.equals("y") || input.equals("N")  || input.equals("n"))){
					System.out.println("Invalid input - does not start with \"y\" or \"n\". Please try again.");
				}else if(input.equals("Y")  || input.equals("y")) {
					done = true;
					return true;
				}else if((input.equals("N")  || input.equals("n"))) {
					done = true;
					return false;
				}
			}else if(inputLine.equals("")){
				System.out.println("Invalid input - empty line. Please try again.");
			}
		}
		return true;
	}
	
	private boolean getHitStayInput(String prompt) {
		String input;
		boolean done = false;
		while(done == false) {
			System.out.println(prompt);
			String inputLine = sc.next();
			input = inputLine.substring(0,1);
			if(inputLine.length() > 0) {
				if(!(input.equals("H")  || input.equals("h") || input.equals("S")  || input.equals("s"))){
					System.out.println("Invalid input - does not start with \"h\" or \"s\". Please try again.");
				}else if(input.equals("H")  || input.equals("h")) {
					done = true;
					return true;
				}else if((input.equals("S")  || input.equals("s"))) {
					done = true;
					return false;
				}
			}else if(inputLine.equals("")){
				System.out.println("Invalid input - empty line. Please try again.");
			}
		}
		return true;
	}
	
	
//	private void addCard(Card[] hand) {
//		
//		Card[] tempArray = new Card[hand.length+1];
//		Card add = D.deal();
//		for(int i = 0; i < hand.length; i++) {
//			tempArray[i] = hand[i];
//		}
//		tempArray[tempArray.length - 1] = add;
//		hand = tempArray;
//		
//		if(D.progressInDeck > 51) {
//			D.shuffle();
//		}
//	}
	private void playerAddCard() {
		Card[] tempArray = new Card[playerHand.length+1];
		Card add = D.deal();
		for(int i = 0; i < playerHand.length; i++) {
			tempArray[i] = playerHand[i];
		}
		tempArray[tempArray.length - 1] = add;
		playerHand = tempArray;
		
		if(D.progressInDeck > 51) {
			D.shuffle();
		}
	}
	private void dealerAddCard() {
		Card[] tempArray = new Card[dealerHand.length+1];
		Card add = D.deal();
		for(int i = 0; i < dealerHand.length; i++) {
			tempArray[i] = dealerHand[i];
		}
		tempArray[tempArray.length - 1] = add;
		dealerHand = tempArray;
		
		if(D.progressInDeck > 51) {
			D.shuffle();
		}
	}
	public void play(){
		D.shuffle();
		String name;
		
		boolean yN;
		
		System.out.println("Welcom to Blackjack! What is your name?");
		name = sc.nextLine();
		System.out.println("Hello " + name + "! I am Gamletron 5000! Let's play some cards.");
		boolean play = true;
		while(play==true) {
			boolean phS = true;
			boolean dhS = true;
			playerHand = new Card[0];
			dealerHand = new Card[0];
			
			playerAddCard();
			dealerAddCard();
			playerAddCard();
			dealerAddCard();
			
			System.out.println("Your Hand: " + handToString(playerHand));
			System.out.println("Dealer's Hand: "+ handToString(dealerHand));
			
			if(isBlackjack(dealerHand)) {
				
				phS = false;
				dhS = false;
			}
			if(isBlackjack(playerHand)) {
				System.out.println("Congrants " + name + " you got a Blackjack!");
				phS = false;
				dhS = false;
			}
			
			
			while(phS) {
				phS = getHitStayInput("Would you like to (H)it or (S)tay: ");
				if(phS){
					playerAddCard();
					System.out.println("Your new hand: " + handToString(playerHand));
					if(isBust(playerHand)) {
						phS = false;
						System.out.println(name + " I'm so sorry you busted!");
					}
					
				}
			}
			while(dhS) {
				dhS = dealerKeepHitting(dealerHand);
				if(dhS) {
					dealerAddCard();
					if(isBust(dealerHand)) {
						System.out.println("dealer busted!");
						dhS = false;
					}
				}
			}
			
			System.out.println("Your Hand: " + handToString(playerHand));
			System.out.println("Dealer's Hand: "+ handToString(dealerHand));
			System.out.println("Result: " + determineResult(playerHand, dealerHand));
			
			
			yN = getYesNoInput("Would you like to play again? (Y)es/(N)o: ");
			if(yN) {
				play=true;
			}else {
				play=false;
			}
		}
		System.out.println("Thanks for playing " + name + "! Have a great day!");
		
		
		
	}
}