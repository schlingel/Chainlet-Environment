package at.chainlet.rse.core;

/**
 * Observes all words which run in a RSE VM.
 */
public interface WordStatusObserver {
	/**
	 * Gets called when a word finishes.
	 */
	public void wordFinished(Word w);
}
