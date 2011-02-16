package at.chainlet.rse.core;

import at.chainlet.rse.WordStatusObserverExchanger;

public abstract class RSECoreTest {
	private static int dictCount = 0;
	
	protected synchronized Dictionary getEmptyMockDict() { 
		return new Dictionary("Dictionary " + dictCount);
	}	
	
	protected synchronized Word getMockWord(String name) { return new MockWord(name); }
	
	protected synchronized Dictionary getMockDict(String name) { return new Dictionary(name); }
	
	protected synchronized Library getMockLibrary() { return new Library(); }
	
	protected synchronized WordStatusObserver getMockWordStatsObserver() { return new MockWordStatusObserver(); }

	protected synchronized WordStatusObserverExchanger getWordStatusObserverExchanger() { return new WordStatusObserverExchanger(); }
}
