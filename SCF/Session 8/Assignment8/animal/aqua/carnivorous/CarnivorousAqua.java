package animal.aqua.carnivorous;

import animal.aqua.Aqua;

/**
 * 
 * @author Nilesh Patel
 * This class represent animal which are Carnivorous and lives in water
 */
public abstract class CarnivorousAqua extends Aqua 
{
	/**
	 * 
	 * This default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousAqua()
	{
		super.subCatagory = "Carnivorous";
	}
}