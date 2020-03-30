package question3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Nilesh Patel
 *test class for compound class 
 */
public class CalculateMassTest {
	@Test
	public void compoundtest1() {

		assertEquals(32,Compounds.calculateMass("CHHHOH"));
	}
	@Test
	public void compoundtest2() {

		assertEquals(30,Compounds.calculateMass("CHHHCHHH"));
	}
	@Test
	public void compoundtest3() {

		assertEquals(18, Compounds.calculateMass("HOH"));
	}
	@Test
	public void compoundtest4() {

		assertEquals(46, Compounds.calculateMass("CHHHCHHOH"));
	}
	@Test
	public void compoundtest5() {

		assertEquals(60, Compounds.calculateMass("CHHHCOOH"));
	}

}