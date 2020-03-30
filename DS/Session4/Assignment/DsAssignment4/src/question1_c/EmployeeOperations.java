package question1_c;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nilesh Patel
 * EmployeeOperations class is for operations with Employee class
 */
public class EmployeeOperations {
	Map<Integer, Employee> listOfEmployee = new HashMap<Integer, Employee>();

	/**
	 * add employee without duplicate id the duplicate Id is Encountered it is
	 * avoided
	 * 
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		try {
			if (emp == null) {
				throw new Exception("Employee cant be null");
			}
			if (listOfEmployee.get(emp.getEmpId()) == null)
				listOfEmployee.put(emp.getEmpId(), emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * print the list of the employee
	 */
	public void printList() {
		try {

			for (Employee emp : listOfEmployee.values())
				System.out.println(emp.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
