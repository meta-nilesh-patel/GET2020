package graphicsLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 
 * @author Nilesh Patel
 * This Class represent screen and contain method related to it
 */
public class Screen 
{
	/**
	 * HashMap listOfShapes Store all the Shapes where key is ShapesId of Shapes and value is Shapes object.
	 */
	public HashMap<Integer, Shapes> listOfShapes = new HashMap<>();
	public int totalNoOfScreens = 0;

	/**
	 * 
	 * This method is used to add Shapes to screen
	 * @param ShapesType : type of the Shapes that need to be added
	 * @param startPoint : object of Point Class represent the start point of the Shapes
	 * @param listOfParameters :  ArrayList contain the values for Shapess attribute
	 * @return true if Shapes is added successfully else false
	 * @throws Exception when Shapes can't be added
	 */
	public boolean addShape(String shapesType, Point startPoint, ArrayList<Integer> listOfParameter) throws Exception 
	{
		Shapes newShapes = FactoryShapes.getShape(shapesType, startPoint, listOfParameter);
		newShapes.setShapeId(++totalNoOfScreens);
		this.listOfShapes.put(newShapes.getShapeId(), newShapes);
		return true;
	}

	/**
	 * 
	 * This method is use to delete Shapes from screen
	 * @param shapId : ShapesId of the Shapes to be deleted
	 * @return true if Shapes is deleted else false
	 */
	public boolean deleteShapes(int shapesId)
	{	
		this.listOfShapes.remove(shapesId);
		return true;
	}

	/**
	 * 
	 * This method is use to delete all Shapes from screen
	 * @return true if all Shapes deleted
	 * @throws Exception if no Shapes is available
	 */
	public boolean deleteAllShapess() throws Exception
	{
		if(this.listOfShapes.isEmpty()) 
		{
			throw new Exception("No Shapes on screen");
		}
		this.listOfShapes.clear();
		return true;
	}

	/**
	 * 
	 * This method is use to delete all Shapess of a given type from screen
	 * @param ShapesType : type of Shapes you want to delete
	 * @return true if all shapes deleted.
	 */
	public boolean deleteAllShapessOfParticularType(String shapesType)
	{
		ArrayList<Shapes> localShapesList = new ArrayList<>(this.listOfShapes.values());
		for(Shapes shape : localShapesList)
		{
			String currentshapType = shape.getShapeType();
			if(currentshapType.equalsIgnoreCase(shapesType))
			{
				this.listOfShapes.remove(shape.getShapeId());
			}
		}
		return true;
	}

	/**
	 * 
	 * This method is use to check if any given point is enclosed by Shapes
	 * @param point object of Point Class containing details about the point
	 * @return List of Shapes enclosing the point
	 * @throws Exception when no Shapes on screen
	 */
	public ArrayList<Shapes> isPointEnclosedByShapess(Point point)
	{	
		ArrayList<Shapes> listOfShapessThatEnclosedPoint = new ArrayList<>();
		for(Entry<Integer, Shapes> entry : this.listOfShapes.entrySet()) 
		{
			if (((Shapes)entry.getValue()).isPointEnclosed(point)) 
			{
				listOfShapessThatEnclosedPoint.add((Shapes)entry.getValue());
			}
		}
		return listOfShapessThatEnclosedPoint;
	}

	/**
	 * To sort All the Shapes of Screen by Area
	 * @return Sorted List of Shapes
	 */
	public ArrayList<Shapes> sortAllShapessByArea()
	{
		/**
		 * Comparator for sort by area
		 */
		Comparator<Shapes> shortByArea = new Comparator<Shapes>()
		{
			public int compare(Shapes shapesOne, Shapes shapesTwo) 
			{
				if(shapesOne.getArea() > shapesTwo.getArea())
				{
					return 1;
				}	
				else
				{	
					return -1;
				}	
			}
		};
		ArrayList<Shapes> newShapesObject = new ArrayList<Shapes>(this.listOfShapes.values());
		newShapesObject.sort(shortByArea);
		return newShapesObject;
	}

	/**
	 * To sort All the Shapes of Screen by Perimeter
	 * @return Sorted List of Shapes
	 */
	public ArrayList<Shapes> sortAllShapessByPerimeter()
	{
		/**
		 * Comparator for sort by perimeter
		 */
		Comparator<Shapes> shortByPerimeter = new Comparator<Shapes>()
		{
			public int compare(Shapes shapesOne, Shapes shapesTwo) 
			{
				if(shapesOne.getPerimeter() > shapesTwo.getPerimeter())
				{
					return 1;
				}	
				else
				{	
					return -1;
				}	
			}
		};
		ArrayList<Shapes> newShapesObject = new ArrayList<Shapes>(this.listOfShapes.values());
		newShapesObject.sort(shortByPerimeter);
		return newShapesObject;
	}

	/**
	 * To sort All the Shapess of Screen by Time stamp
	 * @return Sorted List of Shapess
	 */
	public ArrayList<Shapes> sortAllShapessByTimestamp()
	{
		/**
		 * Comparator for sort by time stamp
		 */
		Comparator<Shapes> shortByTimestamp = new Comparator<Shapes>()
		{
			public int compare(Shapes shapesOne, Shapes shapesTwo) 
			{
				return shapesOne.getDate().compareTo(shapesTwo.getDate());
			}
		};
		ArrayList<Shapes> newShapesObject = new ArrayList<Shapes>(this.listOfShapes.values());
		newShapesObject.sort(shortByTimestamp);
		return newShapesObject;
	}

	/**
	 * To sort All the Shapes of Screen by OriginDistance
	 * @return Sorted List of Shapes
	 */
	public ArrayList<Shapes> sortAllShapessByOriginDistance()
	{
		/**
		 * Comparator for sort by OriginDistance
		 */
		Comparator<Shapes> shortByOriginDistance = new Comparator<Shapes>()
		{
			public int compare(Shapes shapeOne, Shapes shapeTwo) 
			{
				if(shapeOne.getOriginDistance() > shapeTwo.getOriginDistance())
				{
					return 1;
				}
				else
				{	
					return -1;
				}
			}
		};
		ArrayList<Shapes> newShapesObject = new ArrayList<Shapes>(this.listOfShapes.values());
		newShapesObject.sort(shortByOriginDistance);
		return newShapesObject;
	}
}