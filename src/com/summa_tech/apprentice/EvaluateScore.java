package com.summa_tech.apprentice;

public class EvaluateScore {
	
	private GameFrame gf;
	public void beginEvaluation(){
		getFramePBTotals();
	}
	
	private void getFramePBTotals(){
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
	}
	
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
