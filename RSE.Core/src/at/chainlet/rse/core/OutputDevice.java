package at.chainlet.rse.core;

/**
 * Used for words to append output to a generic output device like a 
 * CLI or a Swing-GUI.
 */
public interface OutputDevice {
	/**
	 * Prints the given output string to 
	 * @param output
	 */
	public void print(String output);
}
