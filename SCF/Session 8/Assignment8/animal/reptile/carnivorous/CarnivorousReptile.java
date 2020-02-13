package animal.reptile.carnivorous;

import animal.reptile.Reptile;

/**
 * 
 * @author Nilesh Patel
 * This class represent Carnivorous Reptiles
 */
public abstract class CarnivorousReptile extends Reptile 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousReptile()
	{
		super.subCatagory = "Carnivorous";
	}

}