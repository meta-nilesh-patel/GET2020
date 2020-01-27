import java.util.*;

public class ShoppingCart 
{
	//cart store all the item which user will buy!
	Set<Item> cart=new HashSet<Item>();
	
	//Hash map created in it key will be name of item and value will be object of that item! 
	static Map< String, Item> itemsByName =  new HashMap< String, Item>();
    
	//initializing store items add them into HashMap items;
	static
	{
		Item a = new Item("a",20.0);
		itemsByName.put(a.getName(), a);
		Item b = new Item("b", 60.5);
		itemsByName.put(b.getName(), b);
		Item c = new Item("c",34.0);
		itemsByName.put(c.getName(), c);
		Item d = new Item("d",20.0);
		itemsByName.put(d.getName(), d);
		Item e = new Item("e", 60.5);
		itemsByName.put(e.getName(), e);
		Item f = new Item("f",34.0);
		itemsByName.put(f.getName(), f);
		Item g = new Item("g",20.0);
		itemsByName.put(g.getName(), g);
		Item h = new Item("h", 60.5);
		itemsByName.put(h.getName(), h);
		Item i = new Item("i",34.0);
		itemsByName.put(i.getName(), i);
		Item j = new Item("j",20.0);
		itemsByName.put(j.getName(), j);
		Item k = new Item("k", 60.5);
		itemsByName.put(k.getName(), k);
		Item l = new Item("l",34.0);
		itemsByName.put(l.getName(), l);
		
	}
	
	
	public static void main(String[] args) 
	{
		//creating a scanner object for taking inputs!
		 Scanner input = new Scanner(System.in);
		 	
		 //creating object of ShoopingCart Class for user! 
		 ShoppingCart cart = new ShoppingCart();
			
		//display available items with their price!
		System.out.println("Available Items! \nName \t\t price");
			
		for (Map.Entry<String, Item> entry : items.entrySet())
		{  
	            System.out.println(entry.getKey() + " \t\t " + entry.getValue().getPrice()); 
	        } 
			
		int choice;// taking choice from user!
			
		do
		{
			System.out.println("Choose your Choice!");				
			System.out.println("Enter 1 for Display items of Cart!");
			System.out.println("Enter 2 for Add an item from Cart");
			System.out.println("Enter 3 for Remove an item in cart!");
			System.out.println("Enter 4 for when you are done and want to Generate bill!");
			System.out.println("Enter 5 for Exit.");
				
			choice = input.nextInt();
			//consume the \n character which left by nextInt!
			input.nextLine();
				
			switch(choice)
				{
					case 1:
						cart.displayCart();
						break;
						
					case 2:
						String item;
						int incQuantity;
						System.out.println("Enter the name of the item!");
						item=input.nextLine();
						System.out.println("enter quantity of item you want to add");
						incQuantity = input.nextInt();
						input.nextLine();
						
						if(cart.isItemInStore(item))
						{
							cart.addItemInCart(item, incQuantity);
							cart.displayCart();
						}
						else
						{
							System.out.println("Please Enter the item name correctly!");
						}
						break;
						
					case 3:
						String tempItem;
						int decQuantity;
						cart.displayCart();
						System.out.println("Enter the name of the item!");
						tempItem=input.nextLine();
						System.out.println("enter quantity of item you want to remove");
						decQuantity = input.nextInt();
						input.nextLine();
						if(cart.isItemInCart(tempItem))
						{
							cart.removeItemFromCart(tempItem, decQuantity);
							cart.displayCart();
						}
						else
						{
							System.out.println("Please Enter the item name correctly!");
						}
						break;
						
					case 4:
						double totalAmount = cart.generateBill();
						System.out.println(totalAmount);
						break;
						
					default :
						System.out.println("Please Select Correct coice!");
						break;
					}
					
			}while(choice != 4);
			
	}
	
	
	/**
	 * search an item in store.
	 * @param item : item to be searched.
	 * @return : true if item found in list else false.
	 */
	public boolean isItemInStore(String item)
	{
	    for (Map.Entry<String, Item> entry : itemsByName.entrySet())
	    {
            	if(entry.getValue().getName().equals(item))
		{
            		return true;
            	}; 
            }
	    return false;		 
	}
	
	
	/** 
	 * search an item in users cart.
	 * @param item : item to be searched.
	 * @return : true if item found in list else false.
	 */
	public boolean isItemInCart(String item){
		Iterator<Item> value = this.cart.iterator();
		
		while(value.hasNext())
		{
			if(value.next().getName().equals(item))
			{
				return true;
			}
		}
		return false;
	}
	
	/**	
	 * display all the Cart items!
	 */
	public void displayCart()
	{
		Iterator<Item> value = this.cart.iterator();
		
		if (value.hasNext() == false)
		{
			System.out.println("Cart is Empty!");
		}
		else
		{
			System.out.println("Name\tQuantity");		
			while (value.hasNext())
			{
		         Item tempItem = value.next();
		         System.out.println(tempItem.getName()+"\t"+tempItem.getQuantity());
		 	}
		 }	
	}
	
	/** 
	 * add item in user's cart.
	 * @param item : item to be added.
	 * @param incQuantity : quantity of item user want to add in Cart.
	 */
	public void addItemInCart(String item, int incQuantity)
	{
		this.cart.add(itemsByName.get(item));
		itemsByName.get(item).incQuantity(incQuantity);
	}
	
	/**
	 * remove item from user's Cart.
	 * @param item : item to be removed.
	 * @param decQuantity : quantity of item user want to remove from Cart. 
	 */
	public void removeItemFromCart(String item, int decQuantity)
	{
		if(itemsByName.get(item).getQuantity()<=decQuantity)
		{
			this.cart.remove(itemsByName.get(item));
			itemsByName.get(item).decQuantity(itemsByName.get(item).getQuantity());
		}
		else
		{
			itemsByName.get(item).decQuantity(decQuantity);
		}
		
	}
	
	/** 
	 * generate the Cart bill!
	 * @return totalAmount : total value of cart items.
	 */
	public double generateBill()
	{
		double totalAmount=0.0;
		Iterator<Item> value = this.cart.iterator();
		while (value.hasNext())
		{
			Item tempItem=value.next();
			totalAmount += tempItem.getPrice() * tempItem.getQuantity();
		}
		return totalAmount;
	}
	 
}
