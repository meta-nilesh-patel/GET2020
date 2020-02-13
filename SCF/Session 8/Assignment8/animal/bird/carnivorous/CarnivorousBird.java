package animal.bird.carnivorous;

import animal.bird.Bird;

/**
 * 
 * @author Nilesh Patel
 * This class represent Carnivorous Birds
 */
public abstract class CarnivorousBird extends Bird 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousBird()
	{
		super.subCatagory = "Carnivorous";
	}

}