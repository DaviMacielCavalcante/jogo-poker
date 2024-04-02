package Classes;
import java.util.ArrayList;
import java.util.Collections;
import Filas.*;
import Nodes.NodeCliente;
import Pilhas.*;


public class Mesa {

    private FilaCartas cartasEmJogo = new FilaCartas();
    private FilaClientes ordemDeJogada = new FilaClientes();
    private PilhaClientes colocacao = new PilhaClientes();
    private int qtdJogadores;
    private int dinheiro;

    PilhaCartas cartas = new PilhaCartas(52);

    ArrayList<Carta> cartasTemporaria = new ArrayList<>();

    public Mesa() {

        //Não há necessidade de iniciar este construtor com algum dado.
    }

    public FilaCartas getCartasEmJogo() {
        return cartasEmJogo;
    }

    public FilaClientes getOrdemDeJogada() {
        return ordemDeJogada;
    }

    public PilhaClientes getColocacao() {
        return colocacao;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String vencedor() {
        return "";
    }

    public void iniciarJogo(int qtdJogadores) {
        gerarCartas();
        for (int i = 0; i < qtdJogadores; i++) {

            Cliente cliente = new Cliente(i + 1);
            FilaCartas maoTemp = new FilaCartas();

            for (int j = 0; j < 2; j++) {

                Carta cartaTemp = cartas.head.getData();
                cartas.pop();
                maoTemp.add(cartaTemp);
            }
            cliente.receberMao(maoTemp);
            ordemDeJogada.add(cliente);
        }
    }

    private void gerarCartas() {
        String[] naipes = { "Paus", "Copas", "Ouros", "Espadas" };
        int[] valores = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

        for (String n : naipes) {
            for (int v : valores) {
                cartasTemporaria.add(new Carta(n, v));
            }
        }

        Collections.shuffle(cartasTemporaria);
        
        for (Carta carta : cartasTemporaria) {
            cartas.push(carta);
        }

        for (Carta carta : cartasTemporaria) {
            System.out.println(carta);
        }

        cartasTemporaria.clear();
    }

    public void removerJogador(int i) {
        NodeCliente temp = ordemDeJogada.head;
        FilaClientes aux = new FilaClientes();
        while (temp != null) {
            if (((i + 1)!= temp.getData().getId())) {
                aux.add(temp.getData());
            }
            temp = temp.getNext();
        }
        this.ordemDeJogada = aux;
    }

    public void acrescentarCarta() {
        cartasEmJogo.add(cartas.head.getData());
        cartas.pop();
    }
}
