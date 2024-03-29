public class Node {
    int data;
    Node next; //No posterior
    Node prev; //No anterior

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}