package com.carro;

import java.util.Scanner;

public class CarroApplication {

    public static void main(String[] args) {
        new CarroApplication().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();

        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar o carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Virar para esquerda/direita");
            System.out.println("6 - Verificar velocidade");
            System.out.println("7 - Trocar marcha");
            System.out.println("8 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.diminuirVelocidade();
                    break;
                case 5:
                    System.out.println("Digite a direção (esquerda/direita):");
                    String direcao = scanner.next();
                    carro.virar(direcao);
                    break;
                case 6:
                    System.out.println("Velocidade atual: " + carro.getVelocidade() + " km/h");
                    break;
                case 7:
                    System.out.println("Digite a nova marcha (0-6):");
                    int marcha = scanner.nextInt();
                    carro.trocarMarcha(marcha);
                    break;
                case 8:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

}