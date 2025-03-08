package com.carro;

public class Carro {
    private boolean ligado;
    private int velocidade;
    private int marcha;
    private String direcao;

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0; // Ponto morto
        this.direcao = "Frente";
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligar() {
        if (ligado && marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("O carro só pode ser desligado em ponto morto e com velocidade 0.");
        }
    }

    public void acelerar() {
        if (ligado && marcha != 0) {
            if (velocidade < 120) {
                velocidade++;
                System.out.println("Velocidade aumentada para " + velocidade + " km/h.");
            } else {
                System.out.println("Velocidade máxima atingida (120 km/h).");
            }
        } else {
            System.out.println("O carro precisa estar ligado e em uma marcha para acelerar.");
        }
    }

    public void diminuirVelocidade() {
        if (ligado && velocidade > 0) {
            velocidade--;
            System.out.println("Velocidade diminuída para " + velocidade + " km/h.");
        } else {
            System.out.println("O carro já está parado.");
        }
    }

    public void virar(String novaDirecao) {
        if (ligado && velocidade >= 1 && velocidade <= 40) {
            if (novaDirecao.equals("esquerda") || novaDirecao.equals("direita")) {
                direcao = novaDirecao;
                System.out.println("Carro virou para " + direcao + ".");
            } else {
                System.out.println("Direção inválida. Use 'esquerda' ou 'direita'.");
            }
        } else {
            System.out.println("O carro só pode virar entre 1 km/h e 40 km/h.");
        }
    }

    public void trocarMarcha(int novaMarcha) {
        if (ligado) {
            if (novaMarcha >= 0 && novaMarcha <= 6) {
                if (Math.abs(novaMarcha - marcha) == 1 || (marcha == 0 && novaMarcha == 1)) {
                    if (validarMarchaVelocidade(novaMarcha)) {
                        marcha = novaMarcha;
                        System.out.println("Marcha alterada para " + marcha + ".");
                    } else {
                        System.out.println("Velocidade fora da faixa permitida para a marcha " + novaMarcha + ".");
                    }
                } else {
                    System.out.println("Não é permitido pular marchas.");
                }
            } else {
                System.out.println("Marcha inválida. Use valores entre 0 e 6.");
            }
        } else {
            System.out.println("O carro precisa estar ligado para trocar de marcha.");
        }
    }

    private boolean validarMarchaVelocidade(int novaMarcha) {
        switch (novaMarcha) {
            case 0:
                return velocidade == 0;
            case 1:
                return velocidade >= 0 && velocidade <= 20;
            case 2:
                return velocidade >= 21 && velocidade <= 40;
            case 3:
                return velocidade >= 41 && velocidade <= 60;
            case 4:
                return velocidade >= 61 && velocidade <= 80;
            case 5:
                return velocidade >= 81 && velocidade <= 100;
            case 6:
                return velocidade >= 101 && velocidade <= 120;
            default:
                return false;
        }
    }

    public boolean isLigado() {
        return ligado;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getMarcha() {
        return marcha;
    }

    public String getDirecao() {
        return direcao;
    }

}