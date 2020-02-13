package animal.mammal.omnivorous;

import animal.mammal.Mammal;

/**
 * 
 * @author Nilesh Patel
 * This class represent Omnivorous Mammals
 */
public abstract class OmnivorousMammal extends Mammal 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousMammal()
	{
		super.subCatagory = "Omnivorous";
	}
}