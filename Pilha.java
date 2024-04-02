public class Pilha {

    Node head;
    int tamanho, quantidade = 0;

    public Pilha() {
        this.head = null;
        this. tamanho = 10;
    }

    public Pilha(int tamanho) {
        this.head = null;
        this.tamanho = tamanho;
    }

    public void push(Carta data) {

        if(isFull()) {
            return;
        };

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        this.quantidade += 1;
    }

   public void pop() {
        if (!isEmpty()) {
            Node temp = null;
            temp = head;
            head = head.next;
            System.out.println(temp.data);
            this.quantidade -= 1;
        } else {
            System.out.println("Pilha vazia");
        }
   }

    public void peek() {
        if (head == null) {
            System.out.println("Pilha vazia!");
        } else {
            System.out.println(head.data);
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
        Node current = head;

        while (current != null) {
            System.out.println(current.data.toString());

            current = current.next;
        }
    }    
}
