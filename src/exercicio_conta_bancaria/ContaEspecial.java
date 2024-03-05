package exercicio_conta_bancaria;

public class ContaEspecial extends ContaBancaria {
	
	private double limite;

	public ContaEspecial() {
		super();
		setLimite(0);
	}

	public ContaEspecial(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		setLimite(limite);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "Limite = R$" + getLimite();
	}
	
	@Override
	public boolean saque(double valor) {
		if(getLimite() + getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}
	
}
