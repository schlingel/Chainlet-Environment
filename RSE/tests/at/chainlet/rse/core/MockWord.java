package at.chainlet.rse.core;

public class MockWord implements Word {
	private String name;
	
	public MockWord(String _name) {
		name = _name;
	}
	
	@Override
	public String getName() { return name; }
	
	@Override
	public void execute() { }
	
	public void setName(String _name) { name = _name; }
}
