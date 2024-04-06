package Filas;
import Classes.Carta;
import Nodes.NodeCarta;

public class FilaCartas {

    public NodeCarta head;
    public NodeCarta tail;

    public int tamanho = 0;

    public  FilaCartas() {
        this.head = null;
        this.tail = null;
    }

    public void add(Carta data) {

        NodeCarta newNode = new NodeCarta(data);
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
        NodeCarta temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public String remover() {
        NodeCarta temp = tail;
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

    public int melhorCarta() {
        NodeCarta temp = tail;
        NodeCarta maior = temp;
        while (temp != null) {
            if (temp.getData().getValor() < temp.getPrev().getData().getValor()) {
                maior = temp.getPrev();
            } 
            temp = tail.getPrev();
        }
        return maior.getData().getValor();
    }
}

