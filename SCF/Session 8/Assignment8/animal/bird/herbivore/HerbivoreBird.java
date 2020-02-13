package animal.bird.herbivore;

import animal.bird.Bird;

/**
 * 
 * @author Nilesh Patel
 * This class represent Herbivorous Birds
 */
public abstract class HerbivoreBird extends Bird 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivoreBird()
	{
		super.subCatagory = "Herbivorous";
	}

}