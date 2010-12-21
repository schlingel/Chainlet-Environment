package at.chainlet.rse.core;

import java.util.LinkedList;

/**
 * Manages the dictionaries and the order in which they get interpreted.
 */
public class Library {
	private LinkedList<Dictionary> dictionaries;
	
	public Library() {
		dictionaries = new LinkedList<Dictionary>();
	}
}
