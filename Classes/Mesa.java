package Classes;
import java.util.ArrayList;
import java.util.Collections;
import Filas.*;
import ListaDuplamenteEncadeada.*;
import Nodes.NodeCliente;
import Pilhas.*;
import java.util.Scanner;


public class Mesa {

    private FilaCartas cartasEmJogo = new FilaCartas();
    private PilhaClientes colocacao;
    private ListaDuplamenteEncadeada ordemDeJogada = new ListaDuplamenteEncadeada();
    private int dinheiro = 0;
    Scanner sc = new Scanner(System.in);

    PilhaCartas cartas = new PilhaCartas(52);

    ArrayList<Carta> cartasTemporaria = new ArrayList<>();

    public Mesa() {

        //Não há necessidade de iniciar este construtor com algum dado.
    }

    public FilaCartas getCartasEmJogo() {
        return cartasEmJogo;
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
    
    public ListaDuplamenteEncadeada getOrdemDeJogada() {
        return ordemDeJogada;
    }

    public void iniciarJogo(int qtdJogadores) {
        colocacao = new PilhaClientes(qtdJogadores);
        String nome;
        gerarCartas();
        for (int i = 0; i < qtdJogadores; i++) {
            System.out.println("\nInsira o nome do jogador " + i + ":\n");
            nome = sc.nextLine();
            Cliente cliente = new Cliente(i, nome);
            FilaCartas maoTemp = new FilaCartas();

            for (int j = 0; j < 2; j++) {
                Carta cartaTemp = cartas.head.getData();
                cartas.pop();
                maoTemp.add(cartaTemp);
            }
            cliente.receberMao(maoTemp);
            ordemDeJogada.insertAtEnd(cliente);
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

        cartasTemporaria.clear();
    }

    public void removerJogador(int i) {
        NodeCliente temp = ordemDeJogada.head;
        ListaDuplamenteEncadeada aux = new ListaDuplamenteEncadeada();
        while (temp != null) {
            if (((i)!= temp.getData().getId())) {
                aux.insertAtEnd(temp.getData());
            }
            temp = temp.getNext();
        }
        this.ordemDeJogada = aux;
    }

    public void acrescentarCarta() {
        cartasEmJogo.add(cartas.head.getData());
        cartas.pop();
    }

    public void mostrarTabela() {
        // Inicializando a variável menorPontuacao com o primeiro jogador da pilha que contém os jogadores
        Cliente menorPontuacao;
        
        // Enquanto a pilha não estiver vazia
        while (ordemDeJogada.tamanho() != 0) {
            //Reiniciando a variável de comparação
            menorPontuacao = ordemDeJogada.head.getData();

            // Percorrendo a pilha para encontrar o jogador com a maior pontuação
            NodeCliente current = ordemDeJogada.head;
            while (current != null) {
                if (current.getData().getPontuacao() < menorPontuacao.getPontuacao()) {
                    menorPontuacao = current.getData();
                }
                current = current.getNext();
            }
            
            // Adicionando o jogador com a maior pontuação na pilha de colocação
            colocacao.push(menorPontuacao);
            
            // Excluindo o jogador com a maior pontuação da pilha original
            ordemDeJogada.deleteByKey(menorPontuacao.getId());

            //Resetando os IDs para ficarem de acordo com suas posições na lista
            current = ordemDeJogada.head;
            int contador = 0;
            while (current != null) {
                current.getData().setId(contador);
                current = current.getNext();
                contador++;
            }
        }
        // Exiba a pilha de colocação
        colocacao.imprimirRanking();
    }
}