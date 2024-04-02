package Filas;
import Nodes.NodeCliente;
import Classes.Cliente;

public class FilaClientes {

    public NodeCliente head;
    public NodeCliente tail;

    int tamanho = 0;

    public FilaClientes() {
        this.head = null;
        this.tail = null;
    }

    public void add(Cliente data) {

        NodeCliente newNode = new NodeCliente(data);
        if (!isEmpty()) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            tamanho++;
        } else {
            head = tail = newNode;
            tamanho++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void imprimirFila() {
        NodeCliente temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public Cliente acharJogador(int i) {
        NodeCliente temp = head;
        while (temp != null && ((i + 1)!= temp.getData().getId())) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public String remover() {
        NodeCliente temp = tail;
        if (isEmpty()) {
            return "-1";
        }
        if (head == tail) {
            head = tail = null;
            tamanho--;
            return temp.getData().toString();
        }
        tail = tail.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        tamanho--;
        return temp.getData().toString();
    }

    public int size() {
        return tamanho;
    }
}

