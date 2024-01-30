package u6pp;

import java.util.Scanner;
/*
 * instance variable:
 * scanner - used for too take in user input for other methods
 * 
 * methods:
 * getYesNoInput - tests whether an input has a y or n, then retursn true or false\
 * getIntegerinput - confirms that a user inputed integer is within a specified range and is an int
 */
public class InputHelper {
	//instance variable
	Scanner scanner;
	public InputHelper(Scanner scanner){
		this.scanner = scanner;
	}
	//methods
	/**
	 * checks if a user response to a yes/no question is valid
	 * @param prompt: user inputed prompt
	 * @return true or false if user input has y or n as the first character
	 */
	public boolean getYesNoInput(String prompt) {
		String input;
		boolean done = false;
		while(done == false) {
			System.out.println(prompt);
			String inputLine = scanner.next();
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
	/**
	 * checks if an integer input is valid
	 * @param prompt: user inputed prompt
	 * @param min: minimun possible value
	 * @param max: maximum possible value
	 * @return the user inputed integer if it is a valid input
	 */
	public int getIntegerInput(String prompt, int min, int max) {
		String input;
		
		int x = 0;
		while(x==0) {
			System.out.println(prompt);
			input = scanner.nextLine();
			
			
			if(input.equals("")) {
				System.out.println("Invalid input - empty line. Please try again.");
			}else if(checkIfInt(input) == false) {
				System.out.println("Invalid input - not a number. Please try again.");
			}else if(Integer.parseInt(input) > max) {
				System.out.println("Invalid input - too high. Please try again.");
			}else if(Integer.parseInt(input) < min) {
				System.out.println("Invalid input - too low. Please try again.");
			}else {
				return Integer.parseInt(input);
			}
				
		}
		return 1;
	}
	//checks if the input, which is originally a string, is an integer
	//returns true if input is a integer, false if input contains a character
	private boolean checkIfInt(String input) {
		if (input.contains("a")){
			return false;
		}else if(input.contains("b")){
			return false;
		}else if(input.contains("c")){
			return false;
		}else if(input.contains("d")){
			return false;
		}else if(input.contains("e")){
			return false;
		}else if(input.contains("f")){
			return false;
		}else if(input.contains("g")){
			return false;
		}else if(input.contains("h")){
			return false;
		}else if(input.contains("i")){
			return false;
		}else if(input.contains("j")){
			return false;
		}else if(input.contains("k")){
			return false;
		}else if(input.contains("l")){
			return false;
		}else if(input.contains("m")){
			return false;
		}else if(input.contains("n")){
			return false;
		}else if(input.contains("o")){
			return false;
		}else if(input.contains("p")){
			return false;
		}else if(input.contains("q")){
			return false;
		}else if(input.contains("r")){
			return false;
		}else if(input.contains("s")){
			return false;
		}else if(input.contains("t")){
			return false;
		}else if(input.contains("u")){
			return false;
		}else if(input.contains("v")){
			return false;
		}else if(input.contains("w")){
			return false;
		}else if(input.contains("x")){
			return false;
		}else if(input.contains("y")){
			return false;
		}else if(input.contains("z")){
			return false;
		}else if(input.contains("A")){
			return false;
		}else if(input.contains("B")){
			return false;
		}else if(input.contains("C")){
			return false;
		}else if(input.contains("D")){
			return false;
		}else if(input.contains("E")){
			return false;
		}else if(input.contains("F")){
			return false;
		}else if(input.contains("G")){
			return false;
		}else if(input.contains("H")){
			return false;
		}else if(input.contains("I")){
			return false;
		}else if(input.contains("J")){
			return false;
		}else if(input.contains("K")){
			return false;
		}else if(input.contains("L")){
			return false;
		}else if(input.contains("M")){
			return false;
		}else if(input.contains("N")){
			return false;
		}else if(input.contains("O")){
			return false;
		}else if(input.contains("P")){
			return false;
		}else if(input.contains("Q")){
			return false;
		}else if(input.contains("R")){
			return false;
		}else if(input.contains("S")){
			return false;
		}else if(input.contains("T")){
			return false;
		}else if(input.contains("U")){
			return false;
		}else if(input.contains("V")){
			return false;
		}else if(input.contains("W")){
			return false;
		}else if(input.contains("X")){
			return false;
		}else if(input.contains("Y")){
			return false;
		}else if(input.contains("Z")){
			return false;
		}else{
			return true;
		}
		
	}
}