import java.util.Scanner;

/**
 * 
 * @author Nilesh Patel
 * AreaMain Class used to perform test on Area Class
 * It interact with user and take input and get the result 
 * from Area Class and print to console
 */
public class TestArea 
{

	public static void main(String[] args) 
	{
		Area area = new Area();
		Scanner userInput = new Scanner(System.in);
		do
		{	
			System.out.println("1. Get Area Of Right Angle Triangle");
			System.out.println("2. Get Area Of Rectangle");
			System.out.println("3. Get Area Of Square");
			System.out.println("4. Get Area Of Circle");
			System.out.println("5. Exit");
			System.out.print("Please Select Opion : ");
			int userChoice = userInput.nextInt();
			
			//loop termination logic
			if(userChoice == 5)
			{
				System.out.println("Thank You");
				System.exit(0);
			}
			//switch case for option selection
			switch(userChoice)
			{
				//for getting area of Right Angle Triangle
				case(1):
				{
					try
					{
						System.out.print("Enter Height Of Right Angle Triangle : ");
						double heightOfRightAngleTriangle = userInput.nextDouble();
						System.out.print("Enter Base Of Right Angle Triangle : ");
						double baseOfRightAngleTriangle = userInput.nextDouble();
						
						double areaOfRightAngleTriangle = area.getAreaOfTriangle(heightOfRightAngleTriangle, baseOfRightAngleTriangle);
						System.out.printf("Area Of Right Angle Triangle is : %.2f \n", areaOfRightAngleTriangle);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
				}
				
				//for getting area of Rectangle
				case(2):
				{
					try
					{
						System.out.print("Enter Height Of Rectangle : ");
						double heightOfRectangle = userInput.nextDouble();
						System.out.print("Enter Base Of Rectangle : ");
						double baseOfRectangle = userInput.nextDouble();
						
						double areaOfRectangle = area.getAreaOfRectangle(heightOfRectangle, baseOfRectangle);
						System.out.printf("Area Of Rectangle is : %.2f \n", areaOfRectangle);	
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
				}
				
				//for getting area of Square
				case(3):
				{
					try
					{				
						System.out.print("Enter Base Of Square : ");
						double baseOfSquare = userInput.nextDouble();
						
						double areaOfSquare = area.getAreaOfSquare(baseOfSquare);
						System.out.printf("Area Of Square is : %.2f \n",areaOfSquare);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
				}
				
				//for getting area of Circle
				case(4):
				{
					try
					{
						System.out.print("Enter Radius Of Circle : ");
						double radiusOfCircle = userInput.nextDouble();
						
						double areaOfCircle = area.getAreaOfCircle(radiusOfCircle);
						System.out.printf("Area Of Circle is : %.2f \n" , areaOfCircle);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
				}
				
				default:
				{
					System.out.println("Invalid Option!!!");
					break;
				}
			}
		}while(true);

	}

}
