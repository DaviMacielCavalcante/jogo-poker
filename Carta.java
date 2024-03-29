public class Carta {

    private String naipe;
    private int valor;
    private String face;

    public Carta() {
    }

    public Carta(String naipe, int valor, String face) {
        this.naipe = naipe;
        this.valor = valor;
        this.face = face;
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

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "naipe='" + naipe + '\'' +
                ", valor=" + valor +
                ", face='" + face + '\'' +
                '}';
    }
}
