package exercicio_conta_bancaria;

public class ContaBancaria {
	
	protected int numeroConta;
	protected double saldo;
	
	public ContaBancaria() {
		setNumeroConta(999);
		setSaldo(0);
	}
	
	public ContaBancaria(int numeroConta, double saldo) {
		super();
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Número da Conta: " + numeroConta + " - Saldo = R$" + saldo;
	}
	
	public void deposito(double valor) {
		setSaldo(getSaldo() + valor);
	}
	
	public boolean saque(double valor) {
		if(getSaldo() >= valor) {
			setSaldo(getSaldo()- valor);
			return true;
		}
		return false;
	}
	
	public boolean transferencia(ContaBancaria contaDestino, double valor) {
		if(getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			contaDestino.deposito(valor);
			return true;
		}
		return false;
	}
	
}
