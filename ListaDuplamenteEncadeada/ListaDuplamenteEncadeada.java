package ListaDuplamenteEncadeada;

import Classes.Cliente;
import Nodes.*;

public class ListaDuplamenteEncadeada {
    public NodeCliente head; // Referência ao primeiro nó da linha
    public NodeCliente tail; // Referência ao ultimo nó da linha

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBegginning(Cliente data) {
        NodeCliente temp = new NodeCliente(data);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
    }

    public void insertAtEnd(Cliente data) {
        NodeCliente temp = new NodeCliente(data);

        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
        }
    }


    public void traverseForward() {
        //se quiser printar pela head, faca as modificacoes abaixo
        NodeCliente current = head;

        while (current != null) {
            System.out.println(current.getData() + "4");
            current = current.getNext();
        }
        System.out.println();
    }

    public void deleteAtBeggining() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        NodeCliente temp = head;
        head = head.getNext();
        head.setPrev(null);
        temp.setNext(null);
    }

    public void deleteByKey(int position) {

        if (head == null || tail == null) {
            return;
        }

        NodeCliente current = head;

        // Caso a posição seja a primeira
        if (position == 0) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            return;
        }

        // Avança até a posição desejada
        for (int i = 0; current != null && i < position; i++) {
            current = current.getNext();
        }

        // Se temp for null, a posição excede o tamanho da lista
        if (current == null) {
            return;
        }

        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        }
        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
    }

    public int tamanho(){
        int size = 0;
        NodeCliente current = head;

        while (current != null){
            size++;
            current = current.getNext();
        }
        return size;
    }
    public Cliente acharJogador(int i) {
        NodeCliente temp = head;
        while (temp != null && ((i)!= temp.getData().getId())) {
            temp = temp.getNext();
        }
        return temp.getData();
    }
}
