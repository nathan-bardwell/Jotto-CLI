package jotto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JottoTest {

	@Test
	public void testGameCompareWords() {
		Game game = new Game();
		Word secret = new Word("robin");
		
		assertEquals("'rocks' and 'robin' have 2 common letters", 2, game.compareWords("rocks", secret));
		assertEquals("'money' and 'robin' have 2 common letters", 2, game.compareWords("money", secret));
		assertEquals("'takes' and 'robin' have 0 common letters", 0, game.compareWords("takes", secret));
		assertEquals("'rains' and 'robin' have 3 common letters", 3, game.compareWords("rains", secret));
		assertEquals("'robin' and 'robin' have 5 common letters", 5, game.compareWords("robin", secret));
	}

}
