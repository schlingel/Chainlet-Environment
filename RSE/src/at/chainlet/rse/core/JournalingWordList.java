package at.chainlet.rse.core;

import java.util.ArrayList;


/**
 * The historized word list contains the functionality of a word array list 
 * with additionally the option to store information which index should
 * be returned per default.
 */
public class JournalingWordList extends ArrayList<Word> {
	/**
	 * Contains the index of the current set word.
	 */
	private int curIndex;
	
	public JournalingWordList() {
		super();
		curIndex = 0;
	}
	
	public JournalingWordList(int length) {
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
	
	/**
	 * Returns the current selected word. When the list is empty it returns null.
	 * @return
	 */
	public Word current() {
		if(count() == 0)
			return null;
		
		return get(curIndex);
	}
	
	/**
	 * Selects the next newer word in the journal as current selected word. If
	 * there are newer versions the method returns true, otherwise false.
	 */
	public boolean goForthInJournal() {
		if(hasNewerVersions()) {
			curIndex++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Selects the next older word in the journal as current selected word.
	 * If there are older versions the method returns true, otherwise false.
	 */
	public boolean goBackInJournal() {
		if(hasOlderVersions()) {
			curIndex--;
			return true;
		}
		
		return false;
	}
	
	/**
	 * Adds a new word to the list and sets the pointer of the current selected word to the 
	 * index of the new word.
	 */
	@Override
	public boolean add(Word word) {
		curIndex = count();
		return super.add(word);
	}
}
