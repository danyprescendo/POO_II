package exercicio_conta_bancaria.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.ContaBancaria;

class ContaBancariaTest {
	
	ContaBancaria c1;
	ContaBancaria c2;
	
	@BeforeEach
	public void inicializaContaBancaria() {
		c1 = new ContaBancaria();
		c2 = new ContaBancaria(1, 2000);
	}

	@Test
	public void construtorVazioTest() {
		assertEquals(999, c1.getNumeroConta());
		assertEquals(0, c1.getSaldo());
		assertEquals("Número da Conta: 999 - Saldo = R$0.0", c1.toString());
		
	}
	
	@Test
	public void construtorParamentrosTest() {
		assertEquals(1, c2.getNumeroConta());
		assertEquals(2000, c2.getSaldo());
		assertEquals("Número da Conta: 1 - Saldo = R$2000.0", c2.toString());
		
	}
	
	@Test
	void deposito() {
		c1.setSaldo(c1.getSaldo() + 200);
		assertEquals(200, c1.getSaldo());
		c2.setSaldo(c2.getSaldo() + 600);
		assertEquals(2600, c2.getSaldo());
	}
	
	@Test
	void saqueSaldoSuficienteTest() {
		ContaBancaria c3 = new ContaBancaria();
		c3.setSaldo(100.0);
		assertTrue(c3.saque(50.0));
		assertEquals(50.0, c3.getSaldo());
	}

}
