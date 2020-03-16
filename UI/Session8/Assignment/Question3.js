function queue(size) {
    this.size = 0;
    this.collection = [];
    this.enqueue = function (value) {
        if (this.size == size) {
            return "Overflow Occured"
        }
        this.collection.push(value);
        this.size++;
        return "Sucessfully Inserted";
    }
    this.dequeue = function () {
        if (this.size == 0) {
            return "Underflow Occured";
        }
        this.collection.splice(0, 1);
        this.size--;
        return "Sucessfully Deleted";
    }
}