
public class Item 
{	
		private final String name;
		private int quantity=0;
		private double price;
		
		public Item(String name, double price)
		{
			this.name = name;
			this.price = price;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		
		public int getQuantity()
		{
			return this.quantity;
		}

		public double getPrice()
		{
			return this.price;
		}
		
		public void setPrice(double price)
		{
			this.price = price;
		}
		
		public void incQuantity(int incQuantity)
		{
			this.quantity += incQuantity;
		}
		
		public void decQuantity(int decQuantity)
		{
			this.quantity -= decQuantity;
		}
		
}

