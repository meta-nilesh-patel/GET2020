package question1_c;

/**
 * @author Nilesh Patel
 * test class for EmployeeOperations class 
 *
 */
public class EmployeeTest {
	/**
	 * test duplicate Object on the basis of the Id
	 */
	public static void main(String[] args) {
		EmployeeOperations ep = new EmployeeOperations();
		ep.addEmployee(new Employee(1, "krishan", "jaipur"));
		ep.addEmployee(new Employee(1, "priya", "kanpur"));
		ep.addEmployee(new Employee(3, "murtza ali", "jhalawad"));
		ep.addEmployee(new Employee(4, "vinod sahu", "udaipur"));
		ep.addEmployee(new Employee(2, "jyoti", "Jaipur"));
		ep.printList();
	}
}
