package Pilhas;
import Classes.Cliente;
import Nodes.NodeCliente;

public class PilhaClientes {

    public NodeCliente head;
    public int tamanho, quantidade = 0;

    public PilhaClientes() {
        this.head = null;
        this. tamanho = 10;
    }

    public PilhaClientes(int tamanho) {
        this.head = null;
        this.tamanho = tamanho;
    }

    public void push(Cliente data) {

        if(isFull()) {
            return;
        };

        NodeCliente newNode = new NodeCliente(data);
        newNode.setNext(head);
        head = newNode;
        this.quantidade += 1;
    }

   public void pop() {
        if (!isEmpty()) {
            NodeCliente temp = null;
            temp = head;
            head = head.getNext();
            System.out.println(temp.getData());
            this.quantidade -= 1;
        } else {
            System.out.println("Pilha vazia");
        }
   }

    public void peek() {
        if (head == null) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println(head.getData());
        }
    }

    public boolean isFull() {
        return quantidade >= tamanho;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        return "Pilha [head=" + head + ", tamanho=" + tamanho + ", quantidade=" + quantidade + "]";
    }

    public void imprimirPilha() {
        NodeCliente current = head;

        while (current != null) {
            System.out.println(current.getData().toString());

            current = current.getNext();
        }
    }    

    public void imprimirRanking() {
        System.out.println("------RANKING------");
        NodeCliente current = head;
        int i = 0;
        while (current != null) {
            i++;
            System.out.println(" " + i + "°: " + current.getData().getNome() + ", com " + current.getData().getPontuacao() + "\n");
            current = current.getNext();
        }
    }
}
