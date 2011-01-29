package at.chainlet.rse.core.exceptions;

/**
 * This class represents every error which appears because of not allowed actions. An action
 * needs definied conditions and otherwhise this action is throwen. For example: The dup word
 * needs a not empty stack. If the stack is empty the word within throws an InvalidActionException.
 */
public class RSEInvalidActionException extends Exception {
	private static final long serialVersionUID = 1L;

	public RSEInvalidActionException(String msg) { super(msg); }
	
	public RSEInvalidActionException() { super(); }
}
