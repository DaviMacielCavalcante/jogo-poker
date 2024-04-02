package Pilhas;
import Classes.Carta;
import Nodes.NodeCarta;

public class PilhaCartas {

    public NodeCarta head;
    public int tamanho, quantidade = 0;

    public PilhaCartas() {
        this.head = null;
        this. tamanho = 10;
    }

    public PilhaCartas(int tamanho) {
        this.head = null;
        this.tamanho = tamanho;
    }

    public void push(Carta data) {

        if(isFull()) {
            return;
        };

        NodeCarta newNode = new NodeCarta(data);
        newNode.setNext(head);
        head = newNode;
        this.quantidade += 1;
    }

   public void pop() {
        if (!isEmpty()) {
            NodeCarta temp = null;
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
        NodeCarta current = head;

        while (current != null) {
            System.out.println(current.getData().toString());

            current = current.getNext();
        }
    }    
}
