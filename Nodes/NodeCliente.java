package Nodes;
import Classes.Cliente;

public class NodeCliente {
    private Cliente data;
    private NodeCliente next; //No posterior
    private NodeCliente prev; //No anterior

    public NodeCliente(Cliente data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Cliente getData() {
        return data;
    }

    public void setData(Cliente data) {
        this.data = data;
    }

    public NodeCliente getNext() {
        return next;
    }

    public void setNext(NodeCliente next) {
        this.next = next;
    }

    public NodeCliente getPrev() {
        return prev;
    }

    public void setPrev(NodeCliente prev) {
        this.prev = prev;
    }

    
}