package com.summa_tech.apprentice;

import java.util.HashMap;
import static java.lang.System.out;
/**
 * 
 * @author Justin Chilleo
 * This program will take an array of integers as input to calculate a bowling score total.
 * The program will support an array of size 20 or 21 total numbers.
 * If the input array does not contain at least 20 numbers, the program will auto-fill the array with zeros.
 */

public class Main {
	
	static HashMap<Byte, GameFrame> gameBoard = new HashMap<Byte, GameFrame>();
	public static void main(String[] args) {
		InputBox ib = new InputBox();
		ib.begin();
		EvaluateScore es = new EvaluateScore();
		es.beginEvaluation();
		printGameData();

	}
	
	private static void printGameData(){
		for(byte i = 1; i<11; i++){
		GameFrame gf = gameBoard.get(i);
		out.println(gf.getCurrentTotal());
		}
	}

}
