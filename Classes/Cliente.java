package Classes;
import Filas.FilaCartas;

public class Cliente {

    private int id;
    private FilaCartas mao;
    private boolean jogar;

    private boolean continuar;

    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FilaCartas getMao() {
        return mao;
    }

    public void setMao(FilaCartas mao) {
        this.mao = mao;
    }

    public boolean isJogar() {
        return jogar;
    }

    public void setJogar(boolean jogar) {
        this.jogar = jogar;
    }

    public boolean isContinuar() {
        return continuar;
    }

    public void setContinuar(boolean continuar) {
        this.continuar = continuar;
    }

    public void receberMao(FilaCartas mao) {
        this.mao = mao;
    }

    public void escolherCarta(Carta carta) {
        mao.add(carta);
    }

    public void passar(String resp) {
        resp = resp.toLowerCase();
        if (resp.equals("s")) {
            jogar = true;
        } else if (resp.equals("n")) {
            jogar = false;
        }
    }

    public int apostarOuPagar(int valor) {
        return valor;
    }

    public void sair() {
        setContinuar(false);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", mao=" + mao +
                '}';
    }
}