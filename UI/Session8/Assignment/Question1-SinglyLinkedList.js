function node() {
    this.value = null;
    this.next = null;
}

function singlyLinkedList() {
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
                currentNode.next = newNode;
                return "Added Sucessfully";
            }
        }
    }
    this.deleteHead = function () {
        if (this.head != null) {
            this.head = this.head.next;
            return "Deleted Sucessfully";
        }
    }

    this.deleteTail = function () {
        tempNode = this.head;
        if (tempNode == null) {
            return "Deleted Sucessfully";
        }
        else if (tempNode.next == null) {
            this.deleteHead();
        }
        else {
            while (tempNode.next.next != null) {
                tempNode = tempNode.next;
            }
        }
        tempNode.next = null;
        return "Deleted Sucessfully";
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
                tempNode = this.head;
                while (tempNode != null) {
                    if (tempNode.next.value == value) {
                        return tempNode;
                    }
                    else {
                        tempNode = tempNode.next;
                    }
                    tempNode.next = tempNode.next.next;
                    return "Deleted Sucessfully";
                }
            }
        }
    }

    this.deleteAtIndex = function (index) {
        if (index == 0) {
            return this.deleteHead();
        }
        counter = 1;
        currentNode = this.head;
        while (counter < index - 1 && currentNode.next != null) {
            currentNode = currentNode.next;
            counter++;
        }
        if (counter < index - 1) {
            return "Index Not Found";
        }
        else {
            currentNode.next = currentNode.next.next;
            return "Deleted Sucessfully";
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