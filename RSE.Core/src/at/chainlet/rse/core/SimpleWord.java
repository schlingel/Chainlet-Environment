package at.chainlet.rse.core;

import java.util.*;

/**
 * The simple word interface is for most of the words of the words because
 * the greater parts of the words shouldn't interact with the system.
 * 
 * The simple word only gets an reference to the system stack.
 */
public interface SimpleWord extends Word {
	/**
	 * Gets the data stack of the RSE interpreter.
	 */
	public Stack<Object> getStack();
	
	/**
	 * Gets the return stack of the RSE interpreter.
	 */
	public Stack<Object> getReturnStack();
}
