package com.summa_tech.apprentice;

import static java.lang.System.out;

public class PrintScreen {

	/**
	 * Access point for printing the various outputs.
	 * @param keyValue -value for which field to print
	 */
	public void beginPrint(int keyValue){
		
		switch (keyValue) {
        case 1:  keyValue = 1;
         		 printRolls();
                 break;
        case 2:  keyValue = 2;
        		 printTotalPB();
                 break;
        case 3:  keyValue = 3;
        		 printTotal();
                 break;
        case 4:  keyValue = 4;
        		 printCurrent();
                 break;
        default: keyValue = 0;
        		 addHeader();
                 break;
    }
	}
	
	/**
	 * Method to add header output
	 */
	private void addHeader(){
		out.printf("%17s", "" + "|");
		for(byte i = 1; i<11; i++){
			out.printf("%-6s", "Frame ");
			out.printf("%-3s", i);
			out.print("|");
		}
		out.println();
	}
	
	/**
	 * method print out the values for each roll in a frame.
	 */
	private void printRolls(){
		byte frameNumber = 0;
		out.printf("%-16s", "Rolls");
		out.print("|");
		for(byte k = 1; k < 10; k++){
			GameFrame gf = Main.gameBoard.get(++frameNumber);
				out.printf("%-4s", " " + gf.getFirstRoll());
				out.print("|");
				out.printf("%-4s", " " + gf.getSecondRoll());
				out.print("|");
		}
		GameFrame gf = Main.gameBoard.get(++frameNumber);
		if(gf.getBonus() == 'X' || gf.getBonus() == 'S'){
			out.printf("%-2s", gf.getFirstRoll());
			out.print("|");
			out.printf("%-2s", gf.getSecondRoll());
			out.print("||");
			out.printf("%-2s", gf.getThirdRoll());
			out.println("|");
		}
		else{
			out.printf("%-2s", " " + gf.getFirstRoll());
			out.print("|");
			out.printf("%-2s", " " + gf.getSecondRoll());
			out.print("||");
			out.printf("%-2s", "--");
			out.println("|");
		}
	}
	
	/**
	 * Prints out the combined score for each frame before the bonuses are added
	 */
	private void printTotalPB(){
		byte frameNumber = 0;
		out.printf("%-16s", "Total pre-Bonus");
		out.print("|");
		for(byte k = 1; k < 11; k++){
			GameFrame gf = Main.gameBoard.get(++frameNumber);
				out.printf("%-9s", "   " + gf.getFramePBTotal());
				out.print("|");
		}
		out.println();
	}
	
	/**
	 * prints out the combined score for each frame with the bonuses added.
	 */
	private void printTotal(){
		byte frameNumber = 0;
		out.printf("%-16s", "Total post Bonus");
		out.print("|");
		for(byte k = 1; k < 11; k++){
			GameFrame gf = Main.gameBoard.get(++frameNumber);
				out.printf("%-9s", "   " + gf.getFrameTotal());
				out.print("|");
		}
		out.println();
	}
	
	/**
	 * prints out the current total score for the current frame and the preceeding ones.
	 */
	private void printCurrent(){
		byte frameNumber = 0;
		out.printf("%-16s", "Current Score");
		out.print("|");
		for(byte k = 1; k < 11; k++){
			GameFrame gf = Main.gameBoard.get(++frameNumber);
				out.printf("%-9s", "   " + gf.getCurrentTotal());
				out.print("|");
		}
		out.println();
	}
}
