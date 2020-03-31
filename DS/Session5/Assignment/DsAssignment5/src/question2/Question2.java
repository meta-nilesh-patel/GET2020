package question2;

/**
 * 
 * @author Nilesh Patel
 * LinkedList Sorting
 */
class Question2 {

	static class Node {
		Employee data;
		Node next = null;

		public Node(Employee emp) {
			this.data = emp;
		}
	}

	static class LinkedList {
		Node head = null;
		Node tail = null;

		void insert(Employee data) {
			Node newNode = new Node(data);
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {
				this.tail.next = newNode;
				this.tail = newNode;
			}
		}
	}

	static LinkedList insertionSort(LinkedList list) {
		Node i = list.head;
		System.out.println(i == null);
		while(i != null) {
			Node maxSalary = i;
			Node j = i;
			while(j != null) {
				if((j.data.getSalary() > maxSalary.data.getSalary()) 
						|| ((j.data.getSalary() == maxSalary.data.getSalary()) 
								&& (j.data.getAge() > maxSalary.data.getAge()))) {
					maxSalary = j;
				}
				j = j.next;
			}
			Employee tempNode = maxSalary.data;
			maxSalary.data = i.data;
			i.data = tempNode;
			i = i.next;
		}
		return list;
	}

	static void display(LinkedList linkedList) {
		Node i = linkedList.head;
		while (i != null) {
			System.out.println(i.data);
			i = i.next;
		}
	}

	/*public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.insert(new Employee("rama", 15000, 23)); 
		l.insert(new Employee("nilesh", 2500, 27)); 
		l.insert(new Employee("yash", 2500, 28)); 
		l.insert(new Employee("dighvijay", 3500, 20)); 
		l.insert(new Employee("lovendra", 500, 20)); 
		System.out.println("Linked List before Sorting.."); 
		Question2.display(l);

		l = Question2.insertionSort(l); 

		System.out.println("\nLinkedList After sorting"); 
		Question2.display(l);
	}*/
}