class MyCircularDeque {

    class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    int maxSize = 0, currQueueSize = 0;

    Node front = null;
    Node rear = null;
    Node newNode;

    public MyCircularDeque(int k) {
        this.maxSize = k;
    }

    public boolean createNode(int data) {
        if (currQueueSize >= maxSize) {
            return false;
        }

        newNode = new Node(data);
        currQueueSize++;

        if(rear == null) {
            front = newNode;
            rear = newNode;
        }

        return true;
    }

    public boolean insertFront(int value) {

        if(currQueueSize < maxSize) {
            if(createNode(value)) {
                newNode.next = front;
                newNode.prev = null;
                front.prev = newNode;
                front = newNode;
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean insertLast(int value) {
        if(currQueueSize < maxSize) {
            if(createNode(value)) {
                newNode.prev = rear;
                rear.next = newNode;
                rear = newNode;
            }

            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteFront() {
        if(!isEmpty()) {
            if(currQueueSize == 1) {
                front = null;
                rear = null;
            }
            else {
                front = front.next;
            }
            currQueueSize--;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteLast() {
        if(!isEmpty()) {
            if(currQueueSize == 1) {
                front = null;
                rear = null;
            }
            else {
                rear = rear.prev;
            }
            currQueueSize--;
            return true;
        }
        else {
            return false;
        }
    }

    public int getFront() {
        if(!isEmpty()) {
            return front.data;
        }
        else {
            return -1;
        }
    }

    public int getRear() {
        if(!isEmpty()) {
            return rear.data;
        }
        else {
            return -1;
        }
    }

    public boolean isEmpty() {
        if(front == null && rear == null) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        // System.out.println(currQueueSize);
        if(currQueueSize >= maxSize) {
            return true;
        }
        else {
            return false;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */