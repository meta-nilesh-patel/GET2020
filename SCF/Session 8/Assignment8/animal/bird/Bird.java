package animal.bird;

import animal.Animal;

/**
 * 
 * @author Nilesh Patel
 * This class represent Birds
 */
public abstract class Bird extends Animal 
{
	/**
	 * 
	 * default constructor set the category of this type of animal to "Bird"
	 */
	protected Bird()
	{
		super.category = "Bird";
	}

}