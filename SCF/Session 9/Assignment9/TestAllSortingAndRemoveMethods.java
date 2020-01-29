package graphicsLibrary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/**
 * 
 * @author Nilesh Patel
 * This class test methods of Screen class
 */
public class TestAllSortingAndRemoveMethods
{	
	private Screen newScreen = new Screen(); 
	private ArrayList<Shapes> input = new ArrayList<Shapes>();

	@Before
	public void createAScreen()
	{
		try
		{
			newScreen.addShape("Square", new Point(1, 1), new ArrayList<Integer>(){{ add(2); }});
			newScreen.addShape("Square", new Point(5, 5), new ArrayList<Integer>(){{ add(2); }});
			newScreen.addShape("Circle", new Point(3, 3), new ArrayList<Integer>(){{ add(8); }});
			newScreen.addShape("Rectangle", new Point(4, 4), new ArrayList<Integer>(){{ add(1); add(2); }});
			this.input = new ArrayList<>( newScreen.listOfShapes.values());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test
	public void test_SortByArea()
	{
		ArrayList<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(3).getArea());
		expectedOutput.add(input.get(0).getArea());
		expectedOutput.add(input.get(1).getArea());
		expectedOutput.add(input.get(2).getArea());

		ArrayList<Double> output = new ArrayList<Double>();
		ArrayList<Shapes> outputShapes = newScreen.sortAllShapessByArea();

		output.add(outputShapes.get(0).getArea());
		output.add(outputShapes.get(1).getArea());
		output.add(outputShapes.get(2).getArea());
		output.add(outputShapes.get(3).getArea());

		for(int i = 0; i < 4; i++ )
		{
			assertEquals(expectedOutput.get(i), output.get(i));
		}
	}
	@Test
	public void test_SortByPerimeter()
	{
		ArrayList<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(3).getPerimeter());
		expectedOutput.add(input.get(0).getPerimeter());
		expectedOutput.add(input.get(1).getPerimeter());
		expectedOutput.add(input.get(2).getPerimeter());

		ArrayList<Double> output = new ArrayList<Double>();
		ArrayList<Shapes> outputShapes = newScreen.sortAllShapessByPerimeter();

		output.add(outputShapes.get(0).getPerimeter());
		output.add(outputShapes.get(1).getPerimeter());
		output.add(outputShapes.get(2).getPerimeter());
		output.add(outputShapes.get(3).getPerimeter());

		for(int i = 0; i < 4; i++ )
		{
			assertEquals(expectedOutput.get(i), output.get(i));
		}	
	}
	@Test
	public void test_SortByOriginDistance()
	{
		ArrayList<Double> expectedOutput = new ArrayList<Double>();
		expectedOutput.add(input.get(0).getOriginDistance());
		expectedOutput.add(input.get(2).getOriginDistance());
		expectedOutput.add(input.get(3).getOriginDistance());
		expectedOutput.add(input.get(1).getOriginDistance());

		ArrayList<Double> output = new ArrayList<Double>();
		ArrayList<Shapes> outputShapes = newScreen.sortAllShapessByOriginDistance();

		output.add(outputShapes.get(0).getOriginDistance());
		output.add(outputShapes.get(1).getOriginDistance());
		output.add(outputShapes.get(2).getOriginDistance());
		output.add(outputShapes.get(3).getOriginDistance());

		for(int i = 0; i < 4; i++ )
		{
			assertEquals(expectedOutput.get(i), output.get(i));
		}	
	}
	@Test
	public void test_SortByTimeStamp()
	{
		ArrayList<Date> expectedOutput = new ArrayList<Date>();
		expectedOutput.add(input.get(0).getDate());
		expectedOutput.add(input.get(1).getDate());
		expectedOutput.add(input.get(2).getDate());
		expectedOutput.add(input.get(3).getDate());

		ArrayList<Date> output = new ArrayList<Date>();
		ArrayList<Shapes> outputShapes = newScreen.sortAllShapessByTimestamp();

		output.add(outputShapes.get(0).getDate());
		output.add(outputShapes.get(1).getDate());
		output.add(outputShapes.get(2).getDate());
		output.add(outputShapes.get(3).getDate());

		for(int i = 0; i < 4; i++ )
		{
			assertEquals(0, expectedOutput.get(i).compareTo(output.get(i)));
		}
	}
	@Test
	public void test_PointEnclosed()
	{
		Point point = new Point(2, 2);
		ArrayList<Boolean> expectedOutput = new ArrayList<Boolean>();
		
		expectedOutput.add(input.get(0).isPointEnclosed(point));
		expectedOutput.add(input.get(2).isPointEnclosed(point));
		
		ArrayList<Boolean> output = new ArrayList<Boolean>();
		ArrayList<Shapes> outputShapes = newScreen.isPointEnclosedByShapess(point);
		
		output.add(outputShapes.get(0).isPointEnclosed(point));
		output.add(outputShapes.get(1).isPointEnclosed(point));
		
		for(int i = 0; i < 2; i++)
			assertEquals(expectedOutput.get(i), output.get(i));
	}
	
	@Test
	public void test_RemoveAndRemoveAllMethod()
	{
		assertEquals(true, newScreen.deleteShapes(input.get(2).getShapeId()));
		assertEquals(true, newScreen.deleteAllShapessOfParticularType("Square"));
	}
}