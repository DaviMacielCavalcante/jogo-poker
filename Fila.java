public class Fila {

    Node head;
    Node tail;

    int tamanho = 0;

    public Fila() {
        this.head = null;
        this.tail = null;
    }

    public void add(Carta data) {

        Node newNode = new Node(data);
        if (!isEmpty()) {
            newNode.next = head;
            head.prev = newNode;
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
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public String remover() {
        Node temp = tail;
        if (isEmpty()) {
            return "-1";
        }
        if (head == tail) {
            head = tail = null;
            tamanho--;
            return temp.data.toString();
        }
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        tamanho--;
        return temp.data.toString();
    }

    public int size() {
        return tamanho;
    }
}

