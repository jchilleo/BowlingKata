package com.summa_tech.apprentice;

/**
 * @author Justin Chilleo
 * This class will take the frame rolls, and the bonus indicators to determine the totals for each frame and the entire game.
 * Currently finds the frame total before bonuses, with bonuses, and total score at the current frame.
 */
public class EvaluateScore {
	
	private GameFrame gameFrame;
	
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
			gameFrame = Main.gameBoard.get(frameNumber);
			if(frameNumber == 10 && (gameFrame.getBonus()=='X' || gameFrame.getBonus()=='S')){
				totalPreBonus = (byte) ((gameFrame.getFirstRoll() + gameFrame.getSecondRoll()) + gameFrame.getThirdRoll());
				gameFrame.setFramePBTotal(totalPreBonus);
				totalWithBonus = totalPreBonus;
				gameFrame.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gameFrame.setCurrentTotal(currentTotal);
			}
			else if(gameFrame.getBonus() == 'X' || gameFrame.getBonus() == 'S'){
				totalPreBonus = 10;
				gameFrame.setFramePBTotal(totalPreBonus);
				totalWithBonus = (byte) (totalPreBonus + getBonus(frameNumber, gameFrame.getBonus()));
				gameFrame.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gameFrame.setCurrentTotal(currentTotal);
			}
			else{
				totalPreBonus = (byte) (gameFrame.getFirstRoll() + gameFrame.getSecondRoll());
				gameFrame.setFramePBTotal(totalPreBonus);
				totalWithBonus = totalPreBonus;
				gameFrame.setFrameTotal(totalWithBonus);
				currentTotal = (short) (currentTotal + totalWithBonus);
				gameFrame.setCurrentTotal(currentTotal);
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
		GameFrame bonusGameFrame = Main.gameBoard.get(++frameNumber);
		if(bonus =='X'){
			if(frameNumber == 10 && bonusGameFrame.getFirstRoll() == 10){
				return (byte) (bonusGameFrame.getFirstRoll() + bonusGameFrame.getSecondRoll());
			}
			else if(bonusGameFrame.getFirstRoll() == 10){
				GameFrame bonusGameFrameXtra = Main.gameBoard.get((byte)(frameNumber+1));
				return (byte) (bonusGameFrame.getFirstRoll() + bonusGameFrameXtra.getFirstRoll());
			}
			else{
			return (byte) (bonusGameFrame.getFirstRoll() + bonusGameFrame.getSecondRoll());}
		}
		else{
			return (byte) (bonusGameFrame.getFirstRoll());
		}
		
	}

}
