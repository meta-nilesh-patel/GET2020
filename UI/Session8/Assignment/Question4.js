function stack(size) {
    this.currentSize = 0;
    this.collection = [];
    this.push = function (value) {
        if (this.currentSize == size) {
            return "Overflow Occured"
        }
        this.collection.push(value);
        this.currentSize++;
        return "Sucessfully Inserted";
    }
    this.pop = function () {
        if (this.currentSize == 0) {
            return "Underflow Occured";
        }
        this.collection.pop();
        this.currentSize--;
        return "Sucessfully Deleted";
    }
}