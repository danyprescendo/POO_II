package exercicio_conta_bancaria;

import java.time.LocalDate;

public class ContaPoupanca extends ContaBancaria {
	
	private static final int limite_saques_mes = 5;
	private int saquesRealizadosMes;
    private int mesUltimoSaque;
    
	public ContaPoupanca() {
		
	}
	
	public ContaPoupanca(int numeroConta, double saldo) {
		super(numeroConta, saldo);
		saquesRealizadosMes = 0;
        mesUltimoSaque = LocalDate.now().getMonthValue(); 
	}
	
	public int getSaquesRealizadosMes() {
		return saquesRealizadosMes;
	}
	public void setSaquesRealizadosMes(int saquesRealizadosMes) {
		this.saquesRealizadosMes = saquesRealizadosMes;
	}
	public int getMesUltimoSaque() {
		return mesUltimoSaque;
	}
	public void setMesUltimoSaque(int mesUltimoSaque) {
		this.mesUltimoSaque = mesUltimoSaque;
	}
	public static int getLimiteSaquesMes() {
		return limite_saques_mes;
	}
	
	@Override
	public String toString() {
		return "Número da conta: " + getNumeroConta() + " (Saldo: R$" + getSaldo() + ") Saques Realizados no mês: " + saquesRealizadosMes + ", Mês do ultimo saque = " + mesUltimoSaque;
	}

	public boolean saque(double valor) {
        LocalDate hoje = LocalDate.now();
        if (hoje.getMonthValue() != mesUltimoSaque) {
            saquesRealizadosMes = 0; 
            mesUltimoSaque = hoje.getMonthValue(); 
        }
        if (saquesRealizadosMes < limite_saques_mes && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            saquesRealizadosMes++;
            return true;
        }
        return false;
    }
   
}
