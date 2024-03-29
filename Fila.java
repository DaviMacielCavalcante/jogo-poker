public class Fila {

    Node head;
    Node tail;

    int tamanho = 0;

    public Fila() {
        this.head = null;
        this.tail = null;
    }

    public void add(int data) {

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

    public int remover() {
        Node temp = tail;
        if (isEmpty()) {
            return -1;
        }
        if (head == tail) {
            head = tail = null;
            tamanho--;
            return temp.data;
        }
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        tamanho--;
        return temp.data;
    }

    public int size() {
        return tamanho;
    }

    public int somar(Fila fila1) {
        int soma = 0;
        Node temp = fila1.head;
        while (temp != null) {
            soma += temp.data;
            temp = temp.next;
        }
        return soma;
    }

    public Fila filaMenor(Fila fila1, Fila fila2) {

        int soma1 = somar(fila1);
        int soma2 = somar(fila2);

        if (soma1 < soma2) {
            return fila1;
        }

        return fila2;
    }

//    public void ordenarPorAnoDePublicacao() {
//        if (head == null || head == tail) {
//            return;
//        }
//
//        boolean trocado;
//        do {
//            trocado = false;
//            Pilha.Node current = head;
//            while (current.next != null) {
//                if (current.data.getAnoPublicacao() > current.next.data.getAnoPublicacao()) {
//                    Livro temp = current.data;
//                    current.data = current.next.data;
//                    current.next.data = temp;
//                    trocado = true;
//                }
//                current = current.next;
//            }
//        } while (trocado);
//    }
//
//    public void imprimirTitulosOrdenados() {
//        Pilha.Node current = head;
//        while (current != null) {
//            System.out.println(current.data.toString());
//            current = current.next;
//        }
//        System.out.println();
//    }
}

