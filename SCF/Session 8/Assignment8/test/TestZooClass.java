package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import zoo.Cage;
import zoo.Zone;
import zoo.Zoo;
import animal.Animal;
import animal.aqua.carnivorous.Shark;
import animal.bird.carnivorous.Owl;

/**
 * 
 * @author Nilesh Patel
 * This class designed for test Zoo class methods.
 */
public class TestZooClass 
{
    @Before
    public void testCageAddition()
    {
        Zone addNewZoneInstance1 = new Zone(10, "Aqua", "Carnivorous", true, true); 
        Zone addNewZoneInstance2 = new Zone(15, "Mammal", "Herbivore", true, true); 
        Zone addNewZoneInstance3 = new Zone(1, "Reptile", "Carnivorous", true, true); 
        Cage addnewCageInstance1 = new Cage(1, "Shark");
        Cage addnewCageInstance2 = new Cage(4, "Deer");
        Cage addnewCageInstance3 = new Cage(4, "Crocodile");
        Cage addnewCageInstance4 = new Cage(1, "Duck");
        
        Zoo.addZone(addNewZoneInstance1);
        Zoo.addZone(addNewZoneInstance2);
        Zoo.addZone(addNewZoneInstance3);
        
        assertEquals(true, Zoo.addCage(addNewZoneInstance1, addnewCageInstance1));
        assertEquals(true, Zoo.addCage(addNewZoneInstance2, addnewCageInstance2));
        assertEquals(true, Zoo.addCage(addNewZoneInstance3, addnewCageInstance3));
        assertEquals(false, Zoo.addCage(addNewZoneInstance3, addnewCageInstance4));
    }
    
    
    @Test
    public void testAnimalAdditionAndRemoval() 
    {
        Animal instance1 = new Shark("Shark1", 22, 1000);
        Animal instance2 = new Shark("Shark1", 22, 1000);
        Animal instance3 = new Owl("Owl1", 22, 1000);
        try
        {
            assertEquals(true, Zoo.addAnimal(instance1));
            assertEquals(false, Zoo.addAnimal(instance3));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            assertEquals(false, Zoo.addAnimal(instance2));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            assertEquals(true, Zoo.removeAnimal(instance1));
            assertEquals(false, Zoo.removeAnimal(instance3));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
