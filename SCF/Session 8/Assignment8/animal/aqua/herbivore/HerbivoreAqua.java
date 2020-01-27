package animal.aqua.herbivore;

import animal.aqua.Aqua;

/**
 * 
 * @author Nilesh Patel
 * This class represent animal which are Herbivore and lives in water
 */
public abstract class HerbivoreAqua extends Aqua 
{
	/**
	 * 
	 * This default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivoreAqua()
	{
		super.subCatagory = "Herbivorous";
	}

}