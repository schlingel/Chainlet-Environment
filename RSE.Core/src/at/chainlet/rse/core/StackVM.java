package at.chainlet.rse.core;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface StackVM extends WordStatusObserver {

	/**
	 * Returns the term queue
	 */
	public abstract ConcurrentLinkedQueue<String> getTermQueue();

	/**
	 * Gets the library object of this VM object.
	 */
	public abstract Library getLibrary();

	/**
	 * Returns the return stack.
	 */
	public abstract Stack<Object> getReturnStack();

	/**
	 * Returns the data stack.
	 */
	public abstract Stack<Object> getDataStack();

	/**
	 * Gets called when a word finishs.
	 */
	public abstract void wordFinished(Word w);

	/**
	 * Parses the given input and starts interpreting the terms in the term queue.
	 */
	public abstract void interpret(String input);

	/**
	 * Splits the input string and enqueues them in the term queue.
	 */
	public abstract void parse(String input);

	/**
	 * The next term gets fetched if the term queue isn't empty and the VM
	 * interprets it. If it's a word it gets executed if its not the 
	 * parsed value is put on top of data stack.
	 */
	public abstract void pollNextTerm();

	/**
	 * Adds the given device to the output chaine. Every device in this chain prints
	 * the output from the executed words to the the given device. (E.g. console line)
	 */
	public abstract void addOutputDevice(OutputDevice device);
	
	/**
	 * Returns the list of the output devices.
	 * @return
	 */
	public abstract OutputDevice[] getOutputDevices();
}