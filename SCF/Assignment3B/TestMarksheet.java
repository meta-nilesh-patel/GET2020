import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Nilesh Patel
 * MarksheetMain Class used to check methods of 
 * Marksheet Class. It take input from user console
 * and get the result from Marksheet Class and print
 * them on console
 */
public class TestMarksheet 
{
	public static void main(String[] args)
	{
		Marksheet marksheet = new Marksheet();
		Scanner userInput = new Scanner(System.in);
		
		//taking number of student input
		System.out.println("Enter Number Of Student : ");
		int numberOfStudent = userInput.nextInt();
		
		while(numberOfStudent == 0)
		{
			System.out.println("No of students should be greater than 0);
			System.out.println("Enter Number Of Student : ");
			numberOfStudent = userInput.nextInt();
		}
		//array stores all student grades
		double studentGrades[] = new double[numberOfStudent];
		
		//taking student grades
		for(int studentIndex = 0; studentIndex < numberOfStudent; studentIndex++)
		{
			System.out.print("Enter Grade Of "+ (studentIndex+1)+" Student : ");
			studentGrades[studentIndex] = userInput.nextDouble();
		}
		//option selecting loop
		do
		{
			System.out.println("1. Print Average Grades Of All Student");
			System.out.println("2. Print Maximum Grades Of All Student");
			System.out.println("3. Print Minimum Grades Of All Student");
			System.out.println("4. Print Precentage Of Pass Student");
			System.out.println("5. Exit");
			
			int userChoice = userInput.nextInt();
			if(userChoice == 5)
			{
				System.out.println("Thank You");
				System.exit(0);
			}
			
			switch(userChoice)
			{
				//for getting average grades of student
				case(1):
				{
					try
					{
						double averageGradesOfAllStudent = marksheet.getAverageOfAllGrades(studentGrades, numberOfStudent);
						System.out.printf("Average Grades Of All Student is : %.2f \n", averageGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					break;
				}
				
				//for getting maximum grades of student
				case(2):
				{
					try
					{
						double maximumGradesOfAllStudent = marksheet.getMaximumOfAllGrades(studentGrades, numberOfStudent);
						System.out.printf("Maximum Grades Of All Student is : %.2f \n", maximumGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					break;
				}
				
				//for getting minimum grades of student
				case(3):
				{
					try
					{
						double minimumGradesOfAllStudent = marksheet.getMinimumOfAllGrades(studentGrades, numberOfStudent);
						System.out.printf("Minimum Grades Of All Student is :%.2f \n", minimumGradesOfAllStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
					}
					break;
				}
				
				//for getting percentage of pass student
				case(4):
				{
					try
					{
						double precentageOfPassStudent = marksheet.getPercentageOfPassStudent(studentGrades, numberOfStudent);
						System.out.printf("Precentage Of Pass Student is : %.2f \n", precentageOfPassStudent);
					}
					catch(IOException io)
					{
						System.out.println(io);
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
