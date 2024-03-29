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
     void depositoTest() {
		c1.setSaldo(100);
		c1.deposito(50);
        assertEquals(150.0, c1.getSaldo());
    }
	
	@Test
	 void saqueSaldoSuficienteTest() {
		ContaBancaria c3 = new ContaBancaria();
		c3.setSaldo(100.0);
		assertTrue(c3.saque(50.0));
		assertEquals(50.0, c3.getSaldo());
	}
	
	@Test
	 void saqueSaldoInsuficienteTest() {
		ContaBancaria c4 = new ContaBancaria();
		c4.setSaldo(300.0);
		assertFalse(c4.saque(500.0));
		assertEquals(300.0, c4.getSaldo());
	}
	
	@Test
	 void transferenciaTestSaldoSuficiente() {
		ContaBancaria contaOrigem = new ContaBancaria();
		ContaBancaria contaDestino = new ContaBancaria();
		contaOrigem.setSaldo(100.0);
		contaDestino.setSaldo(50.0);
		assertTrue(contaOrigem.transferencia(contaDestino, 30.0));
		assertEquals(70.0, contaOrigem.getSaldo());
		assertEquals(80.0, contaDestino.getSaldo());
	}
	
	@Test
	 void transferenciaTestSaldoInsuficiente() {
		ContaBancaria contaOrigem = new ContaBancaria();
		ContaBancaria contaDestino = new ContaBancaria();
		contaOrigem.setSaldo(30.0);
		contaDestino.setSaldo(50.0);
		assertFalse(contaOrigem.transferencia(contaDestino, 50));
		assertEquals(30.0, contaOrigem.getSaldo()); 
        assertEquals(50.0, contaDestino.getSaldo());
	}

}
