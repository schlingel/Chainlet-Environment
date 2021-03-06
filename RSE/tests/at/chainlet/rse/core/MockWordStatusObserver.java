package at.chainlet.rse.core;

public class MockWordStatusObserver implements WordStatusObserver {
	private Word lastWord;
	
	private boolean isCalled;
	
	public MockWordStatusObserver() { isCalled = false; }
	
	@Override
	public void wordFinished(Word w) {
		isCalled = true;
		lastWord = w;
	}
	
	public Word lastWord() { return lastWord; }

	public boolean gotCalled() { return isCalled; }
	
	public void reset() { lastWord = null; isCalled = false; }
}
