class LinkedList {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void insertAtBeginning(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtMiddle(int prevData, int newData) {
        Node temp = head;
        while (temp != null && temp.data != prevData) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Not Found");
        }
        Node newNode = new Node(newData);
        newNode.next = temp.next;
        temp.next = newNode;

        if (head == null) head = newNode;
    }

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        // linkedlist is empty
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void deleteNode(int position) {
        // linkedlist is empty
        if (head == null) {
            return;
        }

        Node temp = head;
        // deletion from the beginning
        if (position == 0) {
            head = temp.next;
            return;
        }

        // deletion is from other positions apart from the beginning
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            return;
        }

        temp.next = temp.next.next;
    }

    public void reverseLL() {
        Node nextPtr = null;
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            nextPtr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPtr;
        }
        head = prev;
    }

    public void reverseRecur(Node curr, Node prev) {
        Node nextPtr;
        if (curr.next == null) {
            head = curr;
            curr.next = prev;
            return;
        }
        nextPtr = curr.next;
        curr.next = prev;
        reverseRecur(nextPtr, curr);
    }

    public void printNodes() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        System.out.println("After Insertion at End : ");
        llist.insertAtEnd(12);
        llist.insertAtEnd(14);
        llist.insertAtEnd(19);
        llist.printNodes();
        System.out.println("After insertion at beginning : ");
        llist.insertAtBeginning(96);
        llist.printNodes();
        System.out.println("Insertion at Middle : ");
        llist.insertAtMiddle(14, 11);
        llist.printNodes();
        System.out.println("Deleting the nodes : \n ");
        llist.deleteNode(2);
        llist.printNodes();
        llist.reverseLL();
        System.out.println("After Reversal iteratively : ");
        llist.printNodes();
        System.out.println("Reversing Recursively : ");
        llist.reverseRecur(head, null);
        llist.printNodes();
    }
}