package Classes;
import java.util.ArrayList;
import java.util.Collections;
import Filas.*;
import Pilhas.*;


public class Mesa {

    private FilaCartas cartasEmJogo = new FilaCartas();
    private FilaClientes ordemDeJogada = new FilaClientes();
    private PilhaClientes colocacao = new PilhaClientes();
    private int qtdJogadores;

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
                System.out.println(maoTemp.toString());
                System.out.println(maoTemp.tamanho);
            }

            cliente.receberMao(maoTemp);
        }
    }

    public void gerarCartas() {
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
}
