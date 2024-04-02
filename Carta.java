public class Carta {

    private String naipe;
    private int valor;

    Pilha cartas = new Pilha(52);

    public Carta() {
    }

    public Carta(String naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public void gerarCartas() {
        String[] naipes = { "Paus", "Copas", "Ouros", "Espadas" };
        int[] valores = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        for (String n : naipes) {
            for (int v : valores) {
                cartas.push(new Carta(n, v));
            }
        }
        cartas.imprimirPilha();
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "naipe='" + naipe + '\'' +
                ", valor=" + valor +
                '}';
    }
}
