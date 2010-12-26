package at.chainlet.rse.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class JournalingWordList_Test extends RSECoreTest {
	
	@Test
	public void emptyListShouldReturnFalseOnHasOlderVersions() {
		JournalingWordList wl = new JournalingWordList();
		assertFalse(wl.hasOlderVersions());
	}
	
	@Test
	public void emptyListShouldReturnFalseOnHasNewerVersions() {
		JournalingWordList wl = new JournalingWordList();
		assertFalse(wl.hasNewerVersions());
	}
	
	@Test
	public void notEmptyListShouldReturnTrueOnHasOlderVersions() {
		JournalingWordList wl = new JournalingWordList();
		for(int i = 0; i < 10; i++) {
			wl.add(getMockWord("word" + i));
		}
			
		assertTrue(wl.hasOlderVersions());
	}
	
	@Test
	public void getCurrentVersionShouldReturnSecondVersion() {
		JournalingWordList wl = new JournalingWordList();
		Word[] words = new Word[3];
		
		for(int i = 0; i < 3; i++) {
			words[i] = getMockWord("word");
			wl.add(words[i]);
		}
		
		wl.goBackInJournal();
		assertEquals(words[1], wl.current());
	}
	
	@Test
	public void getCurrentVersionShouldReturnFirstVersion() {
		JournalingWordList wl = new JournalingWordList();
		Word[] words = new Word[3];
		
		for(int i = 0; i < 3; i++) {
			words[i] = getMockWord("word");
			wl.add(words[i]);
		}
		
		wl.goBackInJournal();
		wl.goBackInJournal();
		assertEquals(words[0], wl.current());
	}
	
	@Test
	public void goBackInJournalShouldReturnFalseInEmptyWordList() {
		JournalingWordList wl = new JournalingWordList();
		Word[] words = new Word[100];
		
		for(int i = 0; i < 100; i++) {
			words[i] = getMockWord("word");
			wl.add(words[i]);
		}
		
		// Remove entries but not in a straight row
		for(int i = 0; i < 30; i++) { wl.remove(wl.count() - 1); }
		for(int i = 0; i < 70; i++) { wl.remove(0); }
		
		assertEquals(0, wl.count());
		assertFalse(wl.goBackInJournal());
	}
	
	@Test
	public void goBackInJournalShouldReturnFalseInNewWordList() {
		JournalingWordList wl = new JournalingWordList();
		assertFalse(wl.goBackInJournal());
	}
	
	@Test
	public void goForthInJournalShouldReturnFalseIfTheCurrentIsTheLatest() {
		JournalingWordList wl = new JournalingWordList();
		for(int i = 0; i < 100; i++) {
			wl.add(getMockWord("word"));
		}
		
		assertFalse(wl.goForthInJournal());
	}
	
	@Test
	public void goForthInJournalInEmptyWordListShouldReturnFalse() {
		JournalingWordList wl = new JournalingWordList();
		for(int i = 0; i < 100; i++) {
			wl.add(getMockWord("word"));
		}
		
		for(int i = 0; i < 30; i++) { wl.remove(wl.count() - 1); }
		for(int i = 0; i < 70; i++) { wl.remove(0); }
		
		assertEquals(0, wl.count());
		assertFalse(wl.goForthInJournal());
	}
	
	@Test
	public void goForthInJournalShouldReturnLatestAfterGoBackOnce() {
		JournalingWordList wl = new JournalingWordList();
		for(int i = 0; i < 100; i++) {
			wl.add(getMockWord("word"));
		}
		
		wl.goBackInJournal();
		wl.goForthInJournal();
		assertEquals(wl.get(wl.count() - 1), wl.current());
	}
	
	@Test
	public void currentShouldReturnLatestEntryAfterRemovingEntries() {
		JournalingWordList wl = new JournalingWordList();
		for(int i = 0; i < 100; i++) { wl.add(getMockWord("word")); }
		for(int i = 0; i < 50; i++) { wl.remove(wl.count() - 1); }
		
		assertEquals(wl.get(wl.count() - 1), wl.current());
	}
	
	@Test
	public void currentShouldReturnFirstIfItsCalledToManyTimes() {
		JournalingWordList wl = new JournalingWordList();
		Word w = getMockWord("test");
		wl.add(w);
		for(int i = 0; i < 100; i++) { wl.add(getMockWord("test")); }
		for(int i = 0; i < 300; i++) { wl.goBackInJournal(); }
		
		assertEquals(w, wl.current());
	}
}
