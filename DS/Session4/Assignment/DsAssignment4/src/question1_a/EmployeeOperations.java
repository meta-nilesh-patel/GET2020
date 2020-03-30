package question1_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Nilesh Patel 
 * EmployeeOperations class is for operations with Employee class
 */
public class EmployeeOperations {
	List<Employee> listOfEmployee = new ArrayList<Employee>();

	/**
	 * add employee object to list using the collection
	 * 
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		try {
			if (emp == null) {
				throw new Exception("Employee cant be null");
			}
			listOfEmployee.add(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * sort the employee object using the comparable by EmpId
	 */
	public void sortedList() {
		Collections.sort(listOfEmployee);
	}

	/**
	 * print the list of employee object
	 */
	public void printList() {
		try {
			for (int i = 0; i < listOfEmployee.size(); i++) {
				System.out.println(listOfEmployee.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
