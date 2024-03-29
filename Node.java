public class Node {
    Carta data;
    Node next; //No posterior
    Node prev; //No anterior

    public Node(Carta data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}