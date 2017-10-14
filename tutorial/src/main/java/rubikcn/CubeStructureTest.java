package rubikcn;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CubeStructureTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CubeStructureTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CubeStructureTest.class);
	}

	public void testColorCount() {
		CubeStructure cube = new CubeStructure();
		int whiteCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		int redCount = 0;
		int yellowCount = 0;
		int orangeCount = 0;

		ArrayList<String> temp = new ArrayList<String>();
		temp.addAll(cube.back_side);
		temp.addAll(cube.down_side);
		temp.addAll(cube.front_side);
		temp.addAll(cube.left_side);
		temp.addAll(cube.right_side);
		temp.addAll(cube.up_side);

		for (String str : temp) {
			switch (str.charAt(0)) {
			case 'w':
				whiteCount++;
				break;
			case 'b':
				blueCount++;
				break;
			case 'g':
				greenCount++;
				break;
			case 'r':
				redCount++;
				break;
			case 'y':
				yellowCount++;
				break;
			case 'o':
				orangeCount++;
				break;
			default:
				throw new RuntimeException();
			}
		}

		assertEquals(whiteCount, 9);
		assertEquals(blueCount, 9);
		assertEquals(greenCount, 9);
		assertEquals(redCount, 9);
		assertEquals(yellowCount, 9);
		assertEquals(orangeCount, 9);
	}

}
