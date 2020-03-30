package question1_b;

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
	 * add the employee in the list
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
	 * sorting of the employee on the basis of empName
	 */
	public void sortEmployeeByName() {
		Collections.sort(listOfEmployee, Employee.sortByNameComparator);
	}

	/**
	 * print the list of Employee
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