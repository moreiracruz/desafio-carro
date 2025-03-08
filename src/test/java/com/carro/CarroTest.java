package com.carro;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    @Test
    void testLigarDesligar() {
        Carro carro = new Carro();
        carro.ligar();
        assertTrue(carro.isLigado());
        carro.desligar();
        assertFalse(carro.isLigado());
    }

    @Test
    void testAcelerarDiminuirVelocidade() {
        Carro carro = new Carro();
        carro.ligar();
        carro.trocarMarcha(1);
        carro.acelerar();
        assertEquals(1, carro.getVelocidade());
        carro.diminuirVelocidade();
        assertEquals(0, carro.getVelocidade());
    }

    @Test
    void testVirar() {
        Carro carro = new Carro();
        carro.ligar();
        carro.trocarMarcha(1);
        carro.acelerar();
        carro.virar("esquerda");
        assertEquals("esquerda", carro.getDirecao());
    }

    @Test
    void testTrocarMarcha() {
        Carro carro = new Carro();
        carro.ligar();
        carro.trocarMarcha(1);
        assertEquals(1, carro.getMarcha());
    }

}