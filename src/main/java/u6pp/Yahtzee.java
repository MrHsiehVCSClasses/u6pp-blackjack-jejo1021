package u6pp;
import java.util.Scanner;
import java.lang.Math;

public class Yahtzee{
	Scanner sc;
	int[] playerDices = new int[5];
	int[] dealerDices = new int[5];
	int[] tempDices = new int[5];
	Dice[] Dices = new Dice[5];
	public Yahtzee(){
		 sc = new Scanner(System.in);
		
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
	
}