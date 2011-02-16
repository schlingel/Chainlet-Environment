package at.chainlet.rse.core;

import java.util.ArrayList;

/*
 * Why an extra exchange center for a simple observer pattern?
 * This design decision is made because I have the future in sense :-)
 * It's needed to ensure simple debug functionality and adds some value
 * to the shell.
 * 
 * In the near future two classes will be notified when a word finishes its
 * work:
 *  - The VM itself
 *  - The RSE shell.
 *  
 *  To ensure this, the architecture camouflages this a little bit:
 *  
 *  +------+       +-----------------------------+           +--------------------+
 *  | word |-------| WordStatusObserverExchanger |-----------| WordStatusObserver |
 *  +------+     / +-----------------------------+           +--------------------+
 *     +------+ /     /                    \
 *     | word |/     /                      \
 *     +------+     /                        \
 *        +------+ /                          \
 *        | word |/                     +--------------------+
 *        +------+                      | WordStatusObserver |
 *                                      +--------------------+
 *                                      
 * As you see its a n:1:m relationship. The words themself only have the instance of
 * the word status observer exchanger and if they finish they call the wordFinished
 * method which in then calls all observers.
 * 
 * The observer themselfes don't have to know the word status observer.
 */
/**
 * This is the center of a observer pattern with multiple observers which all gets
 * notified when some of the observables change.
 */
public class WordStatusObserverExchanger {
	/**
	 * Contains the list of the observers.
	 */
	private ArrayList<WordStatusObserver> observers;
	
	public WordStatusObserverExchanger() {
		observers = new ArrayList<WordStatusObserver>();
	}
	
	/**
	 * Registers the given observer if it isn't allready registered. Throws a null pointer exception
	 * on null values!
	 */
	public void registerObserver(WordStatusObserver statusObserver) {
		if(statusObserver == null)
			throw new IllegalArgumentException("The word status observer must not be null!");
		
		if(!observers.contains(statusObserver))
			observers.add(statusObserver);
	}
	
	/**
	 * Removes the status observer from the observers list if it exists. Returns true if the
	 * observer got removed and false otherwise.
	 */
	public boolean unregisterObserver(WordStatusObserver statusObserver) {
		return observers.remove(statusObserver);
	}
	
	/**
	 * Calls all word status observers in the list that the given word has finished.
	 */
	public void wordFinished(Word w) {
		for(WordStatusObserver observer : observers) {
			observer.wordFinished(w);
		}
	}
}
