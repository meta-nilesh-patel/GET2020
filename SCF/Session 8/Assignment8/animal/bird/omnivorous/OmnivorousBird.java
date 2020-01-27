package animal.bird.omnivorous;

import animal.bird.Bird;

/**
 * 
 * @author Nilesh Patel
 * This class represent Omnivorous Birds
 */
public abstract class OmnivorousBird extends Bird 
{
	/**
	 * 
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousBird()
	{
		super.subCatagory = "Omnivorous";
	}

}