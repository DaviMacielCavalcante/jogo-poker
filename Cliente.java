public class Cliente {

    private int id;
    private Fila mao;
    private boolean continuar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fila getMao() {
        return mao;
    }

    public void setMao(Fila mao) {
        this.mao = mao;
    }

    public boolean isContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    public Cliente() {
    }

    private void receberMao(Carta carta) {
        mao.add(carta);
    }

    private void pedirCarta() {

    }

    private void jogarCarta() {

    }

    private void continuarOuNao(String resp) {
        resp = resp.toLowerCase();
        if (resp.equals("s")) {
            continuar = true;
        } else if (resp.equals("n")) {
            continuar = false;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", mao=" + mao +
                ", continuar=" + continuar +
                '}';
    }
}
