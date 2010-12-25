package at.chainlet.rse.core;

import java.util.ArrayList;


/**
 * The historized word list contains the functionality of a word array list 
 * with additionally the option to store information which index should
 * be returned per default.
 */
public class HistorizedWordList extends ArrayList<Word> {
	/**
	 * Contains the index of the current set word.
	 */
	private int curIndex;
	
	public HistorizedWordList() {
		super();
		curIndex = 0;
	}
	
	public HistorizedWordList(int length) {
		super(length);
		curIndex = 0;
	}
	
	/**
	 * Checks if the word list has older versions.
	 */
	public boolean hasOlderVersions() {
		return (curIndex != 0);
	}
	
	/**
	 * Checks if the word list has newer versions.
	 */
	public boolean hasNewerVersions() { 
		return (curIndex != (count() - 1) && (count() != 0));
	}
	
	/**
	 * Returns the length of the word list.
	 */
	public int count() { return toArray().length; }
}
