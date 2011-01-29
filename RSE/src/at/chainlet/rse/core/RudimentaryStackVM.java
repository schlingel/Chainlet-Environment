package at.chainlet.rse.core;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * This is the core of the RSE system. It contains the logic for managing and starting
 * words and contains the shared stacks.
 */
public class RudimentaryStackVM implements WordStatusObserver {
	/**
	 * Contains dictionaries in the configured order. 
	 */
	private Library library;
	
	/**
	 * Contains the return stack.
	 */
	private Stack<Object> returnStack;
	
	/**
	 * Contains the data stack.
	 */
	private Stack<Object> dataStack;
	
	/**
	 * Contains the term queue. The term queue contains the splitted parts of the input
	 * string which gets step by step meaning by the interpret method.
	 */
	private ConcurrentLinkedQueue<String> termQueue;
	
	/**
	 * Initializes the VM.
	 */
	public RudimentaryStackVM() {
		initializeDataStructures();
	}
	
	/**
	 * Returns the term queue
	 */
	public ConcurrentLinkedQueue<String> getTermQueue() { return termQueue; }
	
	/**
	 * Gets the library object of this VM object.
	 */
	public Library getLibrary() { return library; }
	
	/**
	 * Returns the return stack.
	 */
	public Stack<Object> getReturnStack() { return returnStack; }
	
	/**
	 * Returns the data stack.
	 */
	public Stack<Object> getDataStack() { return dataStack; }
	
	/**
	 * Initializes the data structures in the VM.
	 */
	private void initializeDataStructures() {
		returnStack = new Stack<Object>();
		dataStack = new Stack<Object>();
		termQueue = new ConcurrentLinkedQueue<String>();
		library = new Library();
	}

	/**
	 * Gets called when a word finishs.
	 */
	@Override
	public void wordFinished(Word w) {
		pollNextTerm();
	}
	
	/**
	 * Splits the input string and enqueues them in the term queue.
	 */
	public void parse(String input) {
		String terms[] = split(input);
		
		for(String term : terms) {
			termQueue.add(term);
		}
	}
	
	/**
	 * Splits the String by the delimiter char space
	 */
	private String[] split(String input) {
		return input.split(" ");
	}
	
	/**
	 * The next term gets fetched if the term queue isn't empty and the VM
	 * interprets it. If it's a word it gets executed if its not the 
	 * parsed value is put on top of data stack.
	 */
	public void pollNextTerm() {
		if(!termQueue.isEmpty()) {
			String term = termQueue.poll();
			
			if(library.wordExists(term)) { 
				runWord(library.getWord(term));
			}
			else { 
				parseValueAndPutItOnStack(term); 
			}
		}
	}
	
	/**
	 * Executes the given word in the environment of this VM.
	 */
	private void runWord(Word w) {
		w.registerVM(this);
		w.execute();
	}
	
	/**
	 * Checks the converters and tries to generate an data type out of the literal. If there's
	 * no converter for the given literal it is put as String on the stack.
	 */
	private void parseValueAndPutItOnStack(String name) {
		throw new IllegalArgumentException();
	}
}
