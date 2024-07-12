public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node linkedList = createLinkedList(10);
        printLinkedList(linkedList);

        System.out.println();
        System.out.println(count(linkedList));

        insertNode(linkedList, 5, 5);

        deleteNode(linkedList, 2);
        printLinkedListRec(linkedList);
        System.out.println();

        deleteAll(linkedList, 3);
        printLinkedListRec(linkedList);

        System.out.println();
        printLinkedList(unique(linkedList, -1));

        System.out.println();
        printLinkedList(findMid(linkedList, false));

    }

    // O(N)
    static Node createLinkedList(int n) {
        Node head = new Node(0, null);
        Node ptr = head;
        for (int i = 1; i < n; i++) {
            Node temp = new Node(i, null);
            ptr.next = temp;
            ptr = temp;
        }
        return head;
    }

    // O(N)
    static Node createLinkedListRec(int n) {
        if (n == 0)
            return null;
        Node temp = new Node(n, null);
        temp.next = createLinkedListRec(n - 1);
        return temp;
    }

    // O(N)
    static void printLinkedList(Node head) {

        Node ptr = head;

        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }

    }

    // O(N)
    static void printLinkedListRec(Node head) {
        if (head == null)
            return;
        System.out.print(head.data + " ");
        printLinkedListRec(head.next);
    }

    // O(N)
    static int count(Node head) {
        int count = 0;

        Node ptr = head;

        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }

        return count;
    }

    // O(N)
    static int countRec(Node head) {
        if (head == null)
            return 0;
        return 1 + countRec(head.next);
    }

    // O(N)
    static void printLinkedListRev(Node head) {

        if (head.next == null) {
            System.out.print(head.data + " ");
            return;
        }

        printLinkedListRev(head.next);
        System.out.print(head.data + " ");
    }

    // O(N)
    static Node insertNode(Node head, int pos, int data) {

        Node ptr = head;

        for (int i = 0; i < pos - 1; i++) {
            ptr = ptr.next;
        }

        Node newNode = new Node(data, null);

        Node temp = ptr.next;

        ptr.next = newNode;

        newNode.next = temp;

        return head;
    }

    // O(N)
    static Node insertNodeRec(Node head, int pos, int data) {

        if (pos == 1) {
            Node newNode = new Node(data, null);
            Node temp = head.next;
            head.next = newNode;
            newNode.next = temp;
            return head;
        }

        head.next = insertNode(head.next, pos - 1, data);
        return head;
    }

    // O(N)
    static Node deleteNode(Node head, int pos) {

        Node ptr = head;

        for (int i = 0; i < pos - 1; i++) {
            ptr = ptr.next;
        }

        Node temp = ptr.next;

        ptr.next = ptr.next.next;

        temp.next = null;

        return head;

    }

    // O(N)
    static Node deleteNodeRec(Node head, int pos) {

        if (pos == 1) {
            Node temp = head.next;
            head.next = head.next.next;
            temp.next = null;
            return head;
        }

        head.next = deleteNodeRec(head.next, pos - 1);
        return head;
    }

    // O(N)
    static Node deleteAll(Node head, int value) {

        Node curPtr = head;
        Node prevPtr = null;

        while (curPtr != null) {
            if (curPtr.data == value) {
                prevPtr.next = curPtr.next;
            } else {
                prevPtr = curPtr;
            }
            curPtr = curPtr.next;
        }
        return head;
    }

    // O(N)
    static Node deleteAllRec(Node head, int value) {

        if (head.data == value)
            return deleteAllRec(head.next, value);
        head.next = deleteAllRec(head.next, value);
        return head;

    }

    // O(N)
    static Node insertSorted(Node head, int value) {

        if (head.data >= value) {
            Node newNode = new Node(value, null);
            newNode.next = head;
            return newNode;
        }

        head.next = insertSorted(head.next, value);
        return head;
    }

    // O(N)
    static Node unique(Node head, int prev) {
        if (head == null)
            return null;

        if (head.data == prev) {
            return unique(head.next, prev);
        }

        head.next = unique(head.next, head.data);
        return head;
    }

    // O(log N)
    static Node findMid(Node head, boolean lower) {

        Node fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null)
            return slow;

        if (lower)
            return slow;

        return slow.next;

    }

}