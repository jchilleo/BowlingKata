package com.summa_tech.apprentice;

/**
 * @author Justin Chilleo
 * This class will take the frame rolls, and the bonus indicators to determine the totals for each frame and the entire game.
 * Currently finds the frame total before bonuses, with bonuses, and total score at the current frame.
 */
public class EvaluateScore {
	
	private GameFrame gf;
	
	/**
	 * access method
	 */
	public void beginEvaluation(){
		getFrameTotals();
	}
	
	/**
	 * this method will find the totals for the frames.
	 * Using their recorded values for each roll and any bonuses.
	 */
	private void getFrameTotals(){
		byte totalPreBonus, totalWithBonus;
		short currentTotal = 0;
		for (byte frameNumber = 1; frameNumber < 11; frameNumber++){
			gf = Main.gameBoard.get(frameNumber);
			if(frameNumber == 10 && (gf.getBonus()=='X' || gf.getBonus()=='S')){
				totalPreBonus = (byte) ((gf.getFirstRoll() + gf.getSecondRoll()) + gf.getThirdRoll());
				gf.setFramePBTotal(totalPreBonus);
				totalWithBonus = totalPreBonus;
				gf.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gf.setCurrentTotal(currentTotal);
			}
			else if(gf.getBonus() == 'X' || gf.getBonus() == 'S'){
				totalPreBonus = 10;
				gf.setFramePBTotal(totalPreBonus);
				totalWithBonus = (byte) (totalPreBonus + getBonus(frameNumber, gf.getBonus()));
				gf.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gf.setCurrentTotal(currentTotal);
			}
			else{
				totalPreBonus = (byte) (gf.getFirstRoll() + gf.getSecondRoll());
				gf.setFramePBTotal(totalPreBonus);
				totalWithBonus = totalPreBonus;
				gf.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gf.setCurrentTotal(currentTotal);
			}
		}
		PrintScreen ps = new PrintScreen();
		ps.beginPrint(2);
		ps.beginPrint(3);
		ps.beginPrint(4);
	}
	
	/**
	 * If a frame had a bonus indicator this method will get the additional values to add to the frame score.
	 * @param frameNumber - frame with the bonus.
	 * @param bonus - what type of bonus.
	 * @return - returns the bonus value that needs to be added to the combined roll score.
	 */
	private byte getBonus(byte frameNumber, char bonus){
		GameFrame bonusGF = Main.gameBoard.get(++frameNumber);
		if(bonus =='X'){
			if(frameNumber == 10 && bonusGF.getFirstRoll() == 10){
				return (byte) (bonusGF.getFirstRoll() + bonusGF.getSecondRoll());
			}
			else if(bonusGF.getFirstRoll() == 10){
				GameFrame bonusGFX = Main.gameBoard.get((byte)(frameNumber+1));
				return (byte) (bonusGF.getFirstRoll() + bonusGFX.getFirstRoll());
			}
			else{
			return (byte) (bonusGF.getFirstRoll() + bonusGF.getSecondRoll());}
		}
		else{
			return (byte) (bonusGF.getFirstRoll());
		}
		
	}

}
