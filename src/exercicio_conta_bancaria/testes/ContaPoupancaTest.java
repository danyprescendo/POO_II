package exercicio_conta_bancaria.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.ContaPoupanca;

class ContaPoupancaTest {
	
	ContaPoupanca c1;
	ContaPoupanca c2;
	
	@BeforeEach
	public void inicializaContaEspecial() {
		c1 = new ContaPoupanca();
		c2 = new ContaPoupanca(11, 700.0);
	}

	@Test
	void construtorVazioTest() {
		assertEquals(999, c1.getNumeroConta());
		assertEquals(0, c1.getSaldo());
		assertEquals("Número da conta: 999 (Saldo: R$0.0) Saques Realizados no mês: 0, Mês do ultimo saque = 0" , c1.toString());
	}
	
	@Test
    void construtorParametrosTest() {
		assertEquals(11, c2.getNumeroConta());
		assertEquals(700, c2.getSaldo());
		assertEquals("Número da conta: 11 (Saldo: R$700.0) Saques Realizados no mês: 0, Mês do ultimo saque = 3" , c2.toString());
	}
	
	@Test
    public void testSaqueAtingiuLimiteDeSaques() {
        c2.setSaquesRealizadosMes(5); 
        assertFalse(c2.saque(50.0));
        assertEquals(700.0, c2.getSaldo()); 
        assertEquals(5, c2.getSaquesRealizadosMes());
     
	}

}
