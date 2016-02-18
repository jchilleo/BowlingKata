package com.summa_tech.apprentice;


/**
 * 
 * @author jchilleo
 * This is the game frame object, which will hold the score values in addition to totals/bonus data.
 */
public class GameFrame {
	
	/*
	 * score for each roll in a frame.
	 * Third is only used in the final 10th frame, when applicable.
	 */
	private byte firstRoll = 0, secondRoll = 0, thirdRoll=0;
	/*
	 * frameTotal = frame score value with bonuses added.
	 * framePBTotal = frame score pre-bonus value. 
	 */
	private byte frameTotal = 0, framePBTotal = 0;
	// currentTotal = total of this frame plus all previous frames.
	private short currentTotal = 0;
	/*
	 * bonus indicates if the frame contained a strike, spare, none.
	 * stirke = X or x
	 * spare = S or s
	 * none = N or n
	 */
	private char bonus = 'n';
	
	/**
	 * Constructor for frames 1-9
	 * @param firstRoll - value for first roll in frame.
	 * @param secondRoll - value for second roll in frame.
	 */
	public GameFrame(byte firstRoll, byte secondRoll){
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
	}
	
	/**
	 * Constructor for 10th frame
	 * @param firstRoll - value for first roll in frame.
	 * @param secondRoll - value for second roll in frame.
	 * @param thirdRoll - value for third roll in frame.
	 * @param bonus - value for bonus slot.
	 */
	public GameFrame(byte firstRoll, byte secondRoll, byte thirdRoll, char bonus){
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
		this.thirdRoll = thirdRoll;
		this.bonus = bonus;
	}
	
	/**
	 * Constructor for frame with an strike.
	 * @param firstRoll
	 */
	public GameFrame(byte firstRoll, char bonus){
		this.firstRoll = firstRoll;
		this.bonus = bonus;
	}
	
	/**
	 * constructor for a frame with a spare
	 * @param firstRoll
	 * @param secondRoll
	 * @param bonus
	 */
	public GameFrame(byte firstRoll, byte secondRoll, char bonus){
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
		this.bonus = bonus;
	}
	
	/**
	 * @return value for firstRoll
	 */
	public byte getFirstRoll(){
		return firstRoll;
	}
	
	/**
	 * @return value for firstRoll
	 */
	public byte getSecondRoll(){
		return secondRoll;
	}
	
	/**
	 * @return value for firstRoll
	 */
	public byte getThirdRoll(){
		return thirdRoll;
	}
	
	/**
	 * @return value for frame total with bonuses added.
	 */
	public byte getFrameTotal(){
		return frameTotal;
	}
	
	/**
	 * @return value for frame total before bonuses.
	 */
	public byte getFramePBTotal(){
		return framePBTotal;
	}
	
	/**
	 * @return value for current total of preceding frames and this frame.
	 */
	public short getCurrentTotal(){
		return currentTotal;
	}
	
	/**
	 * @return bonus indicator (strike, spare, none)
	 */
	public char getBonus(){
		return bonus;
	}
	
	/**
	 * @param frameTotal - value of frameTotal with bonuses
	 */
	public void setFrameTotal(byte frameTotal){
		this.frameTotal = frameTotal;
	}
	
	/**
	 * @param framePBTotal - value of frame total before bonuses.
	 */
	public void setFramePBTotal(byte framePBTotal){
		this.framePBTotal = framePBTotal;
	}
	
	/**
	 * @param currentTotal - value of frame total including preceding frames.
	 */
	public void setCurrentTotal(short currentTotal){
		this.currentTotal = currentTotal;
	}
	
	/**
	 * @param bonus - status marker for bonus.
	 */
	public void setBonus(char bonus){
		this.bonus = bonus;
	}
	
}
