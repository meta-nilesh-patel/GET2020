class Question2 {
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static boolean findLoop(LinkedList head) {
        if (head.next == null || head.next.next == null) {
            return false;
        }
        LinkedList first = head.next;
        LinkedList second = head.next.next;
        while (first != second) {
            if (first.next == null || second.next == null || second.next.next == null) {
                return false;
            }
            first = first.next;
            second = second.next.next;
        }
        return true;
    }
}