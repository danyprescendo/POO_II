package exercicio_conta_bancaria.testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.ContaEspecial;

class ContaEspecialTest {
	
	ContaEspecial c1;
	ContaEspecial c2;

	@BeforeEach
	public void inicializaContaEspecial() {
		c1 = new ContaEspecial();
		c2 = new ContaEspecial(21, 2400.0, 1500.0);
	}
	
	@Test
	void saqueTestLimite() {
		c1.setSaldo(3000.0);
		c1.setLimite(2000.0);
		assertTrue(c1.saque(1200.0));
		assertEquals(c1.getSaldo(), 1800.0);
		assertEquals("Número da conta: 999 (Saldo: R$1800.0) - Limite = R$2000.0", c1.toString());
	}
	
	@Test
	void saqueTestSemLimite() {
		assertFalse(c2.saque(4000.0));
		assertEquals(c2.getSaldo(), 2400.0);
		assertEquals("Número da conta: 21 (Saldo: R$2400.0) - Limite = R$1500.0", c2.toString());
	}
	
	

}
