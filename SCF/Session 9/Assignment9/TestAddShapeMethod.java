package graphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * @author Nilesh Patel
 * This class test addShape method of screen class.
 */
@RunWith(Parameterized.class)
public class TestAddShapeMethod
{
	private String shapeType;
	private Point point;
	private ArrayList<Integer> listOfParameter;
	private boolean expectedOutput;

	public TestAddShapeMethod(String shapeType, Point point, ArrayList<Integer> listOfParameter, boolean output) 
	{
		this.shapeType = shapeType;
		this.point = point;
		this.listOfParameter = listOfParameter;
		this.expectedOutput = output;
	}

	@Parameters
	public static Collection<Object[]> testCases()
	{
		return Arrays.asList(new Object[][]
				{
				{ "Square", new Point(1, 1), new ArrayList<Integer>(){{ add(2); }}, true },
				{ "Circle", new Point(2, 2), new ArrayList<Integer>(){{ add(3); }}, true },
				{ "Rectangle", new Point(4, 4), new ArrayList<Integer>(){{ add(2); add(4); }}, true },
				{ "Triangle", new Point(1, 5), new ArrayList<Integer>(){{ add(3); add(4); add(5); }}, true },
				{ "RegularPolygon", new Point(3, 5), new ArrayList<Integer>(){{ add(5); add(4); }}, true },
				{ "Eclipse", new Point(1, 5), new ArrayList<Integer>(){{ add(3); }}, false }
				});		
	}

	@Test
	public void test_AddShapeMethod_Positive_Negative()
	{
		try
		{
			Screen newScreen = new Screen();
			assertEquals(expectedOutput, newScreen.addShape(shapeType, point, listOfParameter));

		}
		catch(Exception e)
		{
			assertEquals("Shape Not Found", e.getMessage());
		}
	}
}