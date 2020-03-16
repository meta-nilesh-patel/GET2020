function node() {
    this.prev = null;
    this.value = null;
    this.next = null;
}

function doublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.addAtLast = function (value) {
        newNode = new node();
        newNode.value = value;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return "Added Sucessfully";
        }
        else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
            return "Added Sucessfully";
        }
    }

    this.addAtBegin = function (value) {
        newNode = new node();
        newNode.value = value;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return "Added Sucessfully";
        }
        else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            return "Added Sucessfully";
        }
    }

    this.addAtIndex = function (index, value) {
        if (index == 0) {
            return this.addAtBegin(value);
        }
        counter = 1;
        currentNode = this.head;
        while (counter < index && currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        if (counter < index) {
            return "Index Not Found"
        }
        else if (counter == index) {
            if (this.tail == currentNode) {
                return this.addAtLast(value);
            }
            else {
                newNode = new node();
                newNode.value = value;
                newNode.next = currentNode.next;
                currentNode.next.prev = newNode;
                currentNode.next = newNode;
                newNode.prev = currentNode;
                return "Added Sucessfully";
            }
        }
    }
    this.deleteHead = function () {
        if (this.head != null) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.prev = null;
                return "Deleted Sucessfully";
            }
            else {
                this.tail = null;
                return "Deleted Sucessfully";
            }
        }
    }

    this.deleteTail = function () {
        if (this.tail != null) {
            this.tail = this.tail.prev;
            if (this.tail != null) {
                this.tail.next = null;
                return "Deleted Sucessfully";
            }
            else {
                this.head = null;
                return "Deleted Sucessfully";
            }
        }
    }
    this.deleteValue = function (value) {
        tempNode = this.searchValue(value);
        if (tempNode != null) {
            if (this.head == tempNode) {
                this.deleteHead();
            }
            else if (this.tail == tempNode) {
                this.deleteTail();
            }
            else {
                tempNode.prev.next = tempNode.next;
                tempNode.next.prev = tempNode.prev;
                return "Deleted Sucessfully";
            }
        }
    }

    this.deleteAtIndex = function (index) {
        if (index == 0) {
            return this.deleteHead();
        }
        counter = 1;
        currentNode = this.head;
        while (counter < (index + 1) && currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        if (counter <= index) {
            return "Index Not Found";
        }
        else if (counter == index + 1) {
            if (this.tail == currentNode) {
                return this.deleteTail();
            }
            else {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                return "Deleted Sucessfully";
            }
        }
    }
    this.searchValue = function (value) {
        tempNode = this.head;
        while (tempNode != null) {
            if (tempNode.value == value) {
                return tempNode;
            }
            else {
                tempNode = tempNode.next;
            }
            return tempNode;
        }
    }
}