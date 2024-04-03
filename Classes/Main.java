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

            for (int i = 1; i <= 5; i++) {

                if (i == 1) {

                    mesa.acrescentarCarta();
                    temp1 = mesa.getCartasEmJogo().head.getData();
                    mesa.acrescentarCarta();
                    i++;

                    for (int j = 0; j < mesa.getOrdemDeJogada2().tamanho(); j++) {

                        jogador = mesa.getOrdemDeJogada2().acharJogador(j);
                        jogador.receberCarta(temp1);

                    }
                    continue;
                }
                mesa.acrescentarCarta();
                temp1 = mesa.getCartasEmJogo().head.getData();

                for (int j = 0; j < mesa.getOrdemDeJogada2().tamanho(); j++) {

                    System.out.println("Jogador-Id: " + (j));
                    jogador = mesa.getOrdemDeJogada2().acharJogador(j);

                    if (jogador != null) {
                        jogador.receberCarta(temp1);
                    } else {
                        continue;
                    }


                    System.out.println();
                    System.out.println("Sua mão: ");
                    jogador.visualizarMao();
                    System.out.println("-------------------");
                    System.out.println("Escolha uma ação: ");
                    System.out.println("[1] - Passar");
                    System.out.println("[2] - Apostar");
                    System.out.println("[3] - Sair");

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
                            mesa.removerJogador(j);
                            break;
                    }
                }

            }
        } while (true);

        //sc.close();
    }
}
