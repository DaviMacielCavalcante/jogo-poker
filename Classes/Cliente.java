package Classes;
import Filas.FilaCartas;
import exceptions.*;

public class Cliente {

    private int id;
    private FilaCartas mao;
    private boolean jogar;
    private boolean continuar;
    private int pontuacao;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
        this.pontuacao = 1000;
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void receberMao(FilaCartas mao) {
        this.mao = mao;
    }

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public void visualizarMao() {
        mao.imprimirFila();
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
        try{
            if(valor>this.pontuacao){
                throw new SaldoInsuficiente("Saldo insuficiente para aposta");
            }
            this.pontuacao -= valor;
        }catch (SaldoInsuficiente e){
            System.out.println(e.getMessage());
        }
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
