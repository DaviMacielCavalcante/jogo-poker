package Classes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Mesa mesa = new Mesa();

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("***** JOGO DO ISAAC ****");
            System.out.println("Informe o número de jogadores: ");
            int qtdJogadores = sc.nextInt();
            mesa.iniciarJogo(qtdJogadores);
            Cliente jogador;
            Carta temp1 = new Carta();
            Carta temp2 = new Carta();
            for (int i = 1; i <= 5; i++) {
                if (i == 1) {
                    mesa.acrescentarCarta();
                    temp1 = mesa.getCartasEmJogo().head.getData();
                    mesa.acrescentarCarta();
                    temp2 = mesa.getCartasEmJogo().head.getData();
                    i++;
                    for (int j = 0; j < mesa.getOrdemDeJogada().size(); j++) {
                        jogador = mesa.getOrdemDeJogada().acharJogador(j);
                        jogador.receberCarta(temp1);
                        jogador.receberCarta(temp2);
                    }
                    continue;
                }
                mesa.acrescentarCarta();
                temp1 = mesa.getCartasEmJogo().head.getData();
                for (int j = 0; j < mesa.getOrdemDeJogada().size(); j++) {
                    System.out.println("Jogador-Id: " + (j+1));
                    jogador = mesa.getOrdemDeJogada().acharJogador(j);
                    jogador.receberCarta(temp1);
                    System.out.println("Escolha uma ação: ");
                    System.out.println("[1] - Passar");
                    System.out.println("[2] - Apostar");
                    System.out.println("[3] - Viualizar Mão");
                    System.out.println("[4] - Sair");
                    int opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            break;
                        case 2:
                            System.out.println("Digite o valor: ");
                            int valor = sc.nextInt();
                            jogador.apostarOuPagar(valor);
                            mesa.setDinheiro(mesa.getDinheiro() + valor);
                            break;
                        case 3:
                            jogador.visualizarMao();
                            break;
                        case 4:
                            mesa.removerJogador(j);
                            break;
                    }
                }

            }
        } while (true);

        //sc.close();
    }
}
