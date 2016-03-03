package model;

import java.io.Serializable;

public class DataStorage implements Serializable {
	private int activePlayerIndex;
	private int mode;

	/**
	 * Creates the storage with the necessary information to successfully save and load a game
	 * @param activePlayerIndex
	 * @param mode
	 * @param boardColors
	 */
	public DataStorage(){

	}
	/**
	 * Returns who's turn it is
	 * @return int
	 */
	public int getActivePlayerIndex(){
		return activePlayerIndex;
	}
	/**
	 * Return what game mode it is (AI vs Player or Player vs Player)
	 * @return int
	 */
	public int getMode(){
		return mode;
	}
	/**
	 * Returns the board setup
	 * @return OthColor[][]
	 */
//	public OthColor[][] getBoardColors(){
//		return boardColors;
//	}
	
	
	private static final long serialVersionUID = 1L;
	
}
