package question2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Nilesh Patel
 * UniqueCharacterCountTest class is for testing UniqueCharacterCount
 */
public class UniqueCharacterCountTest {
	/**
	 * positive test cases for method numberOfUniqueCharacter of UniqueCharacterCount class
	 */
	@Test
	public void testUniqueCharacter() {
		assertEquals(2, CountCharacter.numberOfUniqueCharacter("mmmmmmmmmn"));
		assertEquals(4, CountCharacter.numberOfUniqueCharacter("hello"));
		assertEquals(4, CountCharacter.numberOfUniqueCharacter("malyalam"));
		assertEquals(9, CountCharacter.numberOfUniqueCharacter("asdfgghjkl"));
	}

}