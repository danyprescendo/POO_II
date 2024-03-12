package exercicio_conta_bancaria.testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_conta_bancaria.Banco;
import exercicio_conta_bancaria.ContaBancaria;
import exercicio_conta_bancaria.ContaCorrente;
import exercicio_conta_bancaria.ContaEspecial;
import exercicio_conta_bancaria.ContaPoupanca;

class BancoTest {

	private Banco banco = new Banco();

	@BeforeEach
	void criaContas() {
		banco.adicionarConta(new ContaCorrente(1, 100));
		banco.adicionarConta(new ContaPoupanca(2, 100));
		banco.adicionarConta(new ContaEspecial(3, 100, 500));
	}

	@Test
	void depositoTest() {
		List<ContaBancaria> contas = banco.getContas();
		contas.get(0).deposito(100);
		contas.get(1).deposito(100);
		contas.get(2).deposito(100);
		assertEquals("Número da Conta: 1 - Saldo R$200.0" , contas.get(0).toString());
		assertEquals("Número da Conta: 2 - Saldo R$200.0" , contas.get(1).toString());
		assertEquals("Número da Conta: 3 - Saldo R$200.0" , contas.get(2).toString());
	}

	@Test
	void saqueContaCorrenteOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(0).saque(50));
		assertEquals("Número da Conta: 1 - Saldo R$50.0", contas.get(0).toString());
	}

	@Test
	void saqueContaCorrenteFailTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(0).saque(150));
		assertEquals("Número da Conta: 1 - Saldo R$100.0", contas.get(0).toString());
	}

	@Test
	void saqueContaEspecialOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(2).saque(50));
		assertEquals("Número da Conta: 3 - Saldo R$50.0", contas.get(2).toString());
	}

	@Test
	void saqueContaEspecialOkLimiteTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(2).saque(600));
		assertEquals("Número da Conta: 3 - Saldo R$-500.0", contas.get(2).toString());
	}

	@Test
	void saqueContaEspecialFailTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(2).saque(1500));
		assertEquals("Número da Conta: 3 - Saldo R$100.0", contas.get(2).toString());
	}

	@Test
	void saqueContaPoupancaOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(1).saque(50));
		assertEquals("Número da Conta: 2 - Saldo R$50.0", contas.get(1).toString());
	}

	@Test
	void saqueContaPoupancaFailSaldoTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(1).saque(150));
		assertEquals("Número da Conta: 2 - Saldo R$100.0", contas.get(1).toString());
	}

	@Test
	void saqueContaPoupancaFailLimiteTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(1).saque(5));
		assertTrue(contas.get(1).saque(5));
		assertTrue(contas.get(1).saque(5));
		assertTrue(contas.get(1).saque(5));
		assertTrue(contas.get(1).saque(5));
		assertFalse(contas.get(1).saque(5));
		assertEquals("Número da Conta: 2 - Saldo R$75.0", contas.get(1).toString());
	}

	@Test
	void transferenciaOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(0).transferencia(contas.get(1), 100));
		assertEquals("Número da Conta: 1 - Saldo R$0.0", contas.get(0).toString());
		assertEquals("Número da Conta: 2 - Saldo R$200.0", contas.get(1).toString());
	}

	@Test
	void transferenciaFailSaldoTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(0).transferencia(contas.get(1), 150));
		assertEquals("Número da Conta: 1 - Saldo R$100.0", contas.get(0).toString());
		assertEquals("Número da Conta: 2 - Saldo R$100.0", contas.get(1).toString());
	}

	@Test
	void transferenciaFailDestinoTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(0).transferencia(null, 150));
		assertEquals("Número da Conta: 1 - Saldo R$100.0", contas.get(0).toString());
	}

}
