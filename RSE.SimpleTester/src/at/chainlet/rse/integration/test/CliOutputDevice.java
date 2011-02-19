package at.chainlet.rse.integration.test;

import at.chainlet.rse.core.OutputDevice;

public class CliOutputDevice implements OutputDevice {
	@Override
	public void print(String output) {
		System.out.print(output);
	}
}
