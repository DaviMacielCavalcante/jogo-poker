package Classes;

import Nodes.NodeCliente;

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

            NodeCliente temp;
            Carta temp1;
            Carta temp2;


            mesa.acrescentarCarta();
            temp1 = mesa.getCartasEmJogo().head.getData();
            mesa.acrescentarCarta();
            temp2 = mesa.getCartasEmJogo().head.getData();

            for (int i = 0; i < 4; i++) {
                temp = mesa.getOrdemDeJogada2().head;
                if (i == 0) {
                    while (temp!= null){
                        temp.getData().receberCarta(temp1);
                        temp.getData().receberCarta(temp2);
                        temp = temp.getNext();
                    }
                }
                while (temp!= null){
                    temp.getData().receberCarta(temp1);
                    temp = temp.getNext();
                }

                mesa.acrescentarCarta();
                temp1 = mesa.getCartasEmJogo().head.getData();
                NodeCliente tmp = mesa.getOrdemDeJogada2().head;

                while (tmp != null){

                    System.out.println("Jogador-Id: " + tmp.getData().getId());


                    System.out.println();
                    System.out.println("Sua mão: ");
                    tmp.getData().visualizarMao();
                    System.out.println("Seu saldo: R$"+tmp.getData().getPontuacao());
                    System.out.println("-------------------");
                    System.out.println("Escolha uma ação: ");
                    System.out.println("[1] - Passar");
                    System.out.println("[2] - Apostar");
                    System.out.println("[3] - Sair");

                    int opcao = sc.nextInt();

                    switch (opcao) {
                        case 1:
                            tmp = tmp.getNext();
                            break;
                        case 2:
                            System.out.println("Digite o valor: ");

                            int valor = sc.nextInt();

                            tmp.getData().apostarOuPagar(valor);
                            mesa.setDinheiro(mesa.getDinheiro() + valor);
                            tmp = tmp.getNext();
                            break;
                        case 3:
                            mesa.removerJogador(tmp.getData().getId());
                            tmp = tmp.getNext();
                            break;
                    }
                }

            }
        } while (true);

        //sc.close();
    }
}
