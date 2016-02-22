package com.summa_tech.apprentice;

import java.util.HashMap;

/**
 * 
 * @author Justin Chilleo This program will take an array of integers as input
 *         to calculate a bowling score total. The program will support an array
 *         of size 20 or 21 total numbers. If the input array does not contain
 *         at least 20 numbers, the program will auto-fill the array with zeros.
 */

public class Main {

	static HashMap<Byte, GameFrame> gameBoard = new HashMap<Byte, GameFrame>();

	public static void main(String[] args) {
		InputBox inputBox = new InputBox();
		inputBox.beginInputProcesses();
		EvaluateScore evaluateScore = new EvaluateScore();
		evaluateScore.beginEvaluation();

	}

}
