package at.chainlet.rse.core;

import at.chainlet.rse.WordStatusObserverExchanger;

public class MockWord implements Word {
	private int executionCounter = 0;
	
	private WordStatusObserverExchanger exchanger;
	
	private String name;
	
	public MockWord(String _name) {
		name = _name;
	}
	
	@Override
	public String getName() { return name; }
	
	@Override
	public void execute() { 
		 synchronized(this) {  
			 executionCounter++;
		 } 
	}
	
	public int getExecutionCounter() { return executionCounter; }
	
	public void setName(String _name) { name = _name; }
	
	@Override
	public void registerVM(StackVM vm) { }
	
	public void setObserverExchanger(WordStatusObserverExchanger ex) { 
		exchanger = ex;
	}
	
	@Override
	public void finished() { exchanger.wordFinished(this); }
}
