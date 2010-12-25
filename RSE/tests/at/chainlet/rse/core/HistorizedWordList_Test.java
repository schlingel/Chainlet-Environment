package at.chainlet.rse.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class HistorizedWordList_Test extends RSECoreTest {
	
	@Test
	public void emptyListShouldReturnFalseOnHasOlderVersions() {
		HistorizedWordList wl = new HistorizedWordList();
		assertFalse(wl.hasOlderVersions());
	}
	
	@Test
	public void emptyListShouldReturnFalseOnHasNewerVersions() {
		HistorizedWordList wl = new HistorizedWordList();
		assertFalse(wl.hasNewerVersions());
	}
	
	@Test
	public void notEmptyListShouldReturnTrueOnHasOlderVersions() {
		HistorizedWordList wl = new HistorizedWordList();
		for(int i = 0; i < 10; i++) {
			wl.add(getMockWord("word" + i));
		}
			
		assertTrue(wl.hasOlderVersions());
	}
}
