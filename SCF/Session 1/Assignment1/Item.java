
public class Item {
	
		private final String Name;
		private int quantity=0;
		private double Price;
		
		public Item(String name, double price){
			this.Name = name;
			this.Price = price;
		}
		
		public String getName(){
			return this.Name;
		}
		
		public int getQuantity(){
			return this.quantity;
		}
		
		public double getPrice(){
			return this.Price;
		}
		
		public void IncQuantity(int incQuantity){
			this.quantity += incQuantity;
		}
		
		public void DecQuantity(int decQuantity){
			this.quantity -= decQuantity;
		}
		
}

