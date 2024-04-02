package Nodes;
import Classes.Carta;

public class NodeCarta {
    private Carta data;
    private NodeCarta next; //No posterior
    private NodeCarta prev; //No anterior

    public NodeCarta(Carta data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Carta getData() {
        return data;
    }

    public void setData(Carta data) {
        this.data = data;
    }

    public NodeCarta getNext() {
        return next;
    }

    public void setNext(NodeCarta next) {
        this.next = next;
    }

    public NodeCarta getPrev() {
        return prev;
    }

    public void setPrev(NodeCarta prev) {
        this.prev = prev;
    }

    
}