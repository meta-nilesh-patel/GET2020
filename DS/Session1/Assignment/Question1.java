class Question1 {

    static class Node {
        int value;
        Node next = null;

        public Node(int value) {
            this.value = value;
        }
    }

    static class LinkedList {
        Node head = null;
        Node tail = null;

        void insert(int data) {
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

    /**
     * 
     * This is a utility function which slice linked list.
     * 
     * @param linkedList
     * @param left
     * @param right
     * @return linkedList.head of sliced linked list.
     */
    static LinkedList sliceLinkedList(LinkedList linkedList, int left, int right) {
        Node tempNode = linkedList.head;
        int count = 1;
        while (count < left) {
            tempNode = tempNode.next;
            count++;
        }
        LinkedList slicedLinkedList = new LinkedList();
        slicedLinkedList.insert(tempNode.value);
        while (count < right) {
            tempNode = tempNode.next;
            if (tempNode != null) {
                slicedLinkedList.insert(tempNode.value);
                count++;
            } else {
                break;
            }
        }
        return slicedLinkedList;
    }

    /**
     * 
     * This function rotate a slice of linked list.
     * 
     * @param linkedList.head
     * @param left
     * @param right
     * @param rotation
     * @return linkedList.head of rotated linked list;
     */
    static LinkedList rotateSliceOfLinkedList(LinkedList linkedList, int left, int right, int rotation) {
        rotation = rotation % (right - left + 1);
        if (rotation == 0) {
            return linkedList;
        }
        LinkedList tempObj1 = sliceLinkedList(linkedList, left, left + rotation - 1);
        LinkedList tempObj2 = sliceLinkedList(linkedList, left + rotation, right);
        LinkedList rotatedLinkedList = new LinkedList();
        Node tempNode = linkedList.head;
        int count = 1;
        while (count < left) {
            rotatedLinkedList.insert(tempNode.value);
            tempNode = tempNode.next;
            count++;
        }

        tempNode = tempObj2.head;
        while (tempNode != null) {
            rotatedLinkedList.insert(tempNode.value);
            tempNode = tempNode.next;
        }

        tempNode = tempObj1.head;
        while (tempNode != null) {
            rotatedLinkedList.insert(tempNode.value);
            tempNode = tempNode.next;
        }

        tempNode = linkedList.head;
        count = 1;
        while (tempNode != null) {
            if (count > right) {
                rotatedLinkedList.insert(tempNode.value);
            }
            tempNode = tempNode.next;
            count++;
        }
        return rotatedLinkedList;
    }

    static void display(LinkedList linkedList) {
        while (linkedList.head != null) {
            System.out.println(linkedList.head.value);
            linkedList.head = linkedList.head.next;
        }
    }

    /*
     * public static void main(String[] args) { LinkedList l = new LinkedList();
     * l.insert(1); l.insert(2); l.insert(3); l.insert(4); l.insert(5); l.insert(6);
     * display(rotateSliceOfLinkedList(l, 1, 6, 2)); }
     */

}