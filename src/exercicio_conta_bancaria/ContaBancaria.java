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
		return "Número da Conta: " + numeroConta + "- Saldo = R$" + saldo;
	}
	
	public boolean deposito(double valor) {
		saldo += valor;
		return true;
	}
	
	public boolean saque(double valor) {
		if(saldo >= valor) {
			saldo -= valor;
			return false;
		}
		return true;
	}
	
	public boolean transferencia(ContaBancaria destino, double valor) {
		if(saque(valor)) {
			if(destino.deposito(valor)) {
				return true;
			}else {
				deposito(valor);
				return false;
			}
		}
		return false;
	}
	
}
