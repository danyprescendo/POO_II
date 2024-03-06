package exercicio_conta_bancaria.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.ContaBancaria;
import exercicio_conta_bancaria.ContaCorrente;

class ContaCorrenteTest {
	
	ContaCorrente c1;
	ContaCorrente c2;
	
	@BeforeEach
	public void inicializaContaBancaria() {
		c1 = new ContaCorrente();
		c2 = new ContaCorrente(55, 3000);
	}
	
	@Test
    public void testConstrutorVazio() {
        assertEquals(999, c1.getNumeroConta());
        assertEquals(0.0, c1.getSaldo());
        assertEquals("Número da Conta: 999 - Saldo = R$0.0", c1.toString());
    }
	
	@Test
	public void testConstrutorParametros() {
		assertEquals(55, c2.getNumeroConta());
		assertEquals(3000.0, c2.getSaldo());
		assertEquals("Número da Conta: 55 - Saldo = R$3000.0", c2.toString());
	}
	
	
	@Test
     void depositoTest() {
		c1.deposito(3000.0);
        assertEquals(3000.0, c1.getSaldo());
    }
	
	@Test
	 void saqueSaldoSuficienteTest() {
		ContaBancaria c3 = new ContaBancaria();
		c3.setSaldo(20.0);
		assertTrue(c3.saque(10.0));
		assertEquals(10.0, c3.getSaldo());
	}
	
	@Test
	 void saqueSaldoInsuficienteTest() {
		ContaBancaria c4 = new ContaBancaria();
		c4.setSaldo(100.0);
		assertFalse(c4.saque(200.0));
		assertEquals(100.0, c4.getSaldo());
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
