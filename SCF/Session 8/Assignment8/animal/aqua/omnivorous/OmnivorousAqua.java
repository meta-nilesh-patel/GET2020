package animal.aqua.omnivorous;

import animal.aqua.Aqua;

/**
 * 
 * @author Nilesh Patel
 * This class represent animal which are Omnivorous and lives in water
 */
public abstract class OmnivorousAqua extends Aqua 
{
	/**
	 * 
	 * This default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousAqua()
	{
		super.subCatagory = "Omnivorous";
	}

}