package com.summa_tech.apprentice;

import java.util.Scanner;
import static java.lang.System.out;

/**
 * @author Justin Chilleo
 *
 * This class will take the input array list, and begin sorting the values into their respective frames. 
 */
public class InputBox {
	
	private byte[] rolls;
	private String inputData;
	
	/**
	 * Calls each class, to get the input data, then parse the data and lastly add the data to the hashmap.
	 */
	public void begin(){
		gatherInput();
		parseInput();
		addToBoard();
	}
	
	/**
	 * Uses a scanner to take a string of score values.
	 */
	private void gatherInput(){
		
		out.println("Enter in a bowling game score card.");
		Scanner input = new Scanner(System.in);
		inputData = input.nextLine();
		input.close();
	}
	
	/**
	 * parses a string of score values into a byte array.
	 */
	private void parseInput(){
		
		String[] values = inputData.replaceAll("\\s+","").replaceAll("\\[", "").replaceAll("\\]", "").split(",");
		rolls = new byte[values.length];
		
		for(byte i = 0; i < values.length; i++){
			rolls[i] = Byte.parseByte(values[i]);
		}
	}
	
	/**
	 * takes the values from the byte array and adds them to the game board, for later processing.
	 */
	private void addToBoard(){
		byte frameNumber = 0;
		char bonus = 'N';
		for(byte j = 0; j < rolls.length; j+=2){
			if(frameNumber == 9 && (rolls.length - j)>2){
				if(rolls[j] == 10){
					bonus = 'X';
				}
				else{
					bonus = 'S';
				}
				out.println(rolls[j] + ", " + rolls[j+1] + ", " + rolls[j+2]);
				Main.gameBoard.put(++frameNumber, new GameFrame(rolls[j],rolls[j+1],rolls[j+2],bonus));
				j = (byte) rolls.length;
			}
			else if(rolls[j] == 10){
				bonus = 'X';
				out.println(rolls[j]);
				Main.gameBoard.put(++frameNumber, new GameFrame(rolls[j--],bonus));
			}
			else if(rolls[j] + rolls[j+1] == 10){
				bonus = 'S';
			Main.gameBoard.put(++frameNumber, new GameFrame(rolls[j],rolls[j+1], bonus));
			out.println(rolls[j] + ", " + rolls[j+1]);
			}
			else{
				out.println(rolls[j] + ", " + rolls[j+1]);
				Main.gameBoard.put(++frameNumber, new GameFrame(rolls[j],rolls[j+1]));
			}
		}
	}

}
