package question2;

/**
 * 
 * @author Nilesh Patel
 * Class for Employee
 */
public class Employee 
{
	private String name;
	private double salary;
	private int age;

	public Employee(String name, double salary, int age)
	{
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name + " , " + this.salary + " , " + this.age;
	}
}
