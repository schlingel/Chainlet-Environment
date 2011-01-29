package at.chainlet.rse.core;

import java.util.HashMap;

import at.chainlet.rse.core.exceptions.RSEInvalidStateException;

/**
 * Representation of a dictionary. A dictionary is a named word list.
 */
public class Dictionary {
	/**
	 * Contains the name of the dictionary.
	 */
	private String name;
	
	/**
	 * Contains the words.
	 */
	private HashMap<String, JournalingWordList> words;
	
	/**
	 * Initializes the dictionary.
	 */
	public Dictionary(String _name, HashMap<String, JournalingWordList> _words) {
		words = _words;
		name = _name;
	}
	
	public Dictionary(String _name) { this(_name, new HashMap<String, JournalingWordList>()); }
	
	public Dictionary() { this(""); }
	
	/**
	 * Adds the given word to the words list.
	 */
	public void add(Word word) throws RSEInvalidStateException {
		if(word == null) 
			throw new IllegalArgumentException("A word definition must not be null!");
		
		if(word.getName() == "")
			throw new RSEInvalidStateException("Every word must have a set name!");
		
		JournalingWordList wordList = new JournalingWordList();
		
		if(words.containsKey(word.getName())) {
			wordList = words.get(word.getName());
		}
		
		wordList.add(word);
		words.put(word.getName(), wordList);					
	}
	
	/**
	 * Checks if the given word exists in the words list. The method checks for the name and
	 * not the object identity.
	 */
	public boolean contains(Word word) throws RSEInvalidStateException {
		if(word == null)
			throw new IllegalArgumentException("A word definition must not be null!");
		
		if(word.getName() == "")
			throw new RSEInvalidStateException("Every word must have a set name!");
		
		return words.containsKey(word.getName());
	}
	
	/**
	 * Checks if a word with the given name exists in the word list.
	 */
	public boolean contains(String name) {
		return words.containsKey(name);
	}
	
	/**
	 * Returns the word with the name from word list in the dictionary.
	 */
	public Word get(String name) { 
		JournalingWordList wordList = words.get(name);
		if(wordList == null)
			return null;
		
		return wordList.current();
	}
	
	/**
	 * Returns the name of the dictionary.
	 * @return
	 */
	public String getName() { return name; }
	
	/**
	 * Sets the dictionary pointer to the next older version of the given word. If there's an older
	 * version the method returns true, if not it returns false.
	 */
	public boolean setOlderVersionOf(String wordName) {
		if(contains(wordName)) {
			JournalingWordList wl = words.get(wordName);
			return wl.goBackInJournal();
		}
		
		return false;
	}
	
	/**
	 * Sets the dictionary pointer to the next newer version of the given word. If there's a newer
	 * version the method returns true, if not it returns false.
	 */
	public boolean setNewerVersionOf(String wordName) {
		if(contains(wordName)) {
			JournalingWordList wl = words.get(wordName);
			return wl.goForthInJournal();
		}
		
		return false;
	}
}
