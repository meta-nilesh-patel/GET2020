import java.io.IOException;

/**
 * 
 * @author Nilesh Patel
 * Marksheet Class implement methods to perform on all student grades
 * This include finding maximum,minimum grades or average grades,percentage of pass student
 */
public class Marksheet 
{
	
	public static final int minimumPassingGrade = 40;
	
	/**
	 * 
	 * Find average grade from all student grades
	 * @param grades : array containing grades of all student
	 * @param numberOfStudent : total number of students.
	 * @return average grade from all student grades
	 */
	public double getAverageOfAllGrades(double grades[], int numberOfStudent) throws IOException
	{		
		//grades and student validation
		if(numberOfStudent <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent))
		{
			throw new IOException("Invalid Grades!!!");
		}
		
		double averageGrades = 0.0;
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++)
		{
			averageGrades += grades[gradeIndex];
		}
		averageGrades = (double) averageGrades / numberOfStudent;
		return averageGrades;
	}
	
	/**
	 * 
	 * Find maximum grade of all student grades
	 * @param grades : array containing grades of all student
	 * @param numberOfStudent : total number of students.
	 * @return maximum grade.
	 */
	public double getMaximumOfAllGrades(double grades[], int numberOfStudent) throws IOException
	{	
		//grades and student validation
		if(numberOfStudent <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent))
		{
			throw new IOException("Invalid Grades!!!");
		}
						
		double maximumGrade = 0.0;
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++)
		{
			if(maximumGrade < grades[gradeIndex])
			{
				maximumGrade = grades[gradeIndex];
			}
		}
		return maximumGrade;
	}
	
	/**
	 * 
	 * Find minimum grade in all student grades
	 * @param grades : array containing grades of all student
	 * @param numberOfStudent : total number of students.
	 * @return minimum grade in all student grades
	 */
	public double getMinimumOfAllGrades(double grades[], int numberOfStudent) throws IOException
	{
		//grades and student validation
		if(numberOfStudent <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent))
		{
			throw new IOException("Invalid Grades!!!");
		}
								
		double minimumGrade = Double.MAX_VALUE;
		
		for(int gradeIndex = 0; gradeIndex < numberOfStudent; gradeIndex++)
		{
			if(minimumGrade > grades[gradeIndex])
			{
				minimumGrade = grades[gradeIndex];
			}
		}
		return minimumGrade;
	}
	
	/**
	 * 
	 * Find percentage of student passed
	 * @param grades : array containing grades of all student
	 * @param numberOfStudent : total number of students.
	 * @return percentage of student passed
	 */
	public double getPercentageOfPassStudent(double grades[], int numberOfStudent) throws IOException
	{		
		//grades and student validation
		if(numberOfStudent <= 0)
		{
			throw new IOException("Invalid Number Of Student!!!");
		}
		if(!gradesValidation(grades, numberOfStudent))
		{
			throw new IOException("Invalid Grades!!!");
		}
		
		double passStudentPrecentage = 0.0;
		double numberOfPassStudent = 0;
		for(int gradeIndex =0; gradeIndex < numberOfStudent; gradeIndex++)
		{
			if(grades[gradeIndex] >= minimumPassingGrade)
			{
				numberOfPassStudent++;
			}
		}
		passStudentPrecentage = 100 * numberOfPassStudent/numberOfStudent;
		return passStudentPrecentage;
	}
	
	/**
	 * Validate grades of all student
	 * @param grades : array containing grades of all student
	 * @param numberOfStudent : total number of students.
	 * @return true if grades is in between 0 to 100 inclusive
	 */
	private boolean gradesValidation(double grades[], int numberOfStudent)
	{
		for(int studentGradeIndex = 0; studentGradeIndex < numberOfStudent; studentGradeIndex++)
		{
			if(grades[studentGradeIndex] < 0 || grades[studentGradeIndex] > 100)
			{
				return false;
			}
		}
		return true;
	}
	
}
