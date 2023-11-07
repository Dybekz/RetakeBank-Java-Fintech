package br.com.fiap.javaTeste.model;

public class Recebimentos {

	private int id_recebimentos;
	private double salario;
	private double rcb_extra;

	public int getId_recebimentos() {
		return id_recebimentos;
	}

	public void setId_recebimentos(int id_recebimentos) {
		this.id_recebimentos = id_recebimentos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getRcb_extra() {
		return rcb_extra;
	}

	public void setRcb_extra(double rcb_extra) {
		this.rcb_extra = rcb_extra;
	}

	@Override
	public String toString() {
		return "Id -> " + id_recebimentos + " Salario -> " + salario + " Recebimentos Extra -> " + rcb_extra ;
	}

	public void setRcb_extra(String string) {
		
	}

	public void setSalario(String string) {
		
	}

}
