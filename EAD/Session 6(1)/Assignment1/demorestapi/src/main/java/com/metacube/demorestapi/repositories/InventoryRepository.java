package com.metacube.demorestapi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.metacube.demorestapi.pojo.Inventory;

/**
 * 
 * @author Nilesh Patel
 * This is repository class
 */
public class InventoryRepository 
{
	private List<Inventory> inventories;
	
	/**
	 * Constructor for add default values 
	 */
	public InventoryRepository() 
	{
		inventories = new ArrayList<Inventory>();
		Inventory first = new Inventory();
		first.setName("Apples");
		first.setQuantity(3);
		
		Inventory second = new Inventory();
		second.setName("Oranges");
		second.setQuantity(7);
		
		Inventory third = new Inventory();
		third.setName("Pomegranates");
		third.setQuantity(55);
		inventories.add(first);
		inventories.add(second);
		inventories.add(third);
		
	}
	
	/**
	 * This functions returns list of inventory
	 */
	public List<Inventory> getInventories() 
	{
		return inventories;
	}
	
	/**
	 * This method search inventory in the inventory list else return new inventory.  
	 * @param name : name of inventory to be searched.
	 * @return inventory if found else return new inventory.
	 */
	public Inventory getInventory(String name) 
	{
		for (Inventory i : inventories) 
		{
			if (i.getName().equalsIgnoreCase(name)) 
			{
				return i;
			}
		}
		return new Inventory();
	}
	
	/**
	 * This method search inventory object in the inventory list
	 * @param inv
	 * @return inventory if found else return -1;
	 */
	private int isInventoryExist(Inventory inv) 
	{
		int numberOfInventories = inventories.size();
		for (int index = 0; index < numberOfInventories; index++) 
		{
			if (inventories.get(index).getName().equalsIgnoreCase(inv.getName())) 
			{
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * This method add new inventory in the inventory list.
	 * @param inv : inventory to be added
	 */
	public Inventory addInventory(Inventory inv) 
	{
		int index = isInventoryExist(inv);
		if (index == -1) 
		{
			inventories.add(inv);
			return inv;
		}
		Inventory currentInventory = inventories.get(index);
		currentInventory.setQuantity(currentInventory.getQuantity() + inv.getQuantity());
		return currentInventory;
	}
	
	/**
	 * This method delete all the inventories;
	 */
	public List<Inventory> deleteInventories() 
	{
		inventories.clear();
		return inventories;
	}

	/**
	 * This method delete inventory by given name.
	 * @param inventoryName : inventory to be deleted.
	 * @return
	 */
	public Inventory deleteInventory(String inventoryName) 
	{
		Inventory inv = new Inventory();
		inv.setName(inventoryName);
		int index = isInventoryExist(inv);
		if (index == -1) 
		{
			System.out.println("InventoryNotFound.");
			return new Inventory();
		}
		inventories.remove(index);
		return inv;
	}
	
	/**
	 * THis method update the inventory by their specific name.
	 * @param inventoryName
	 * @param inv : inventory object to be update
	 */
	public Inventory updateInventory(String inventoryName, Inventory inv) 
	{
		Inventory tempInventory = new Inventory();
		tempInventory.setName(inventoryName);
		int index = isInventoryExist(tempInventory);
		if (index == -1) 
		{
			return new Inventory();
		}
		inventories.set(index, inv);
		return inventories.get(index);
	}
	
	/**
	 * This method will replace all the old inventory by new inventory list.
	 * @param newInventories
	 * @return
	 */
	public List<Inventory> updateInventories(List<Inventory> newInventories) 
	{
		inventories = newInventories;
		return inventories;
	}
}
