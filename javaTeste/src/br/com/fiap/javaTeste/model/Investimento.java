	package br.com.fiap.javaTeste.model;

	public class Investimento {

		private int id_investimento;
		private String investimentos;
		private double sld_investimento;

		public int getId_investimento() {
			return id_investimento;
		}

		public void setId_investimento(int id_investimento) {
			this.id_investimento = id_investimento;
		}

		public String getInvestimentos() {
			return investimentos;
		}

		public void setInvestimentos(String investimentos) {
			this.investimentos = investimentos;
		}

		public double getSld_investimento() {
			return sld_investimento;
		}

		public void setSld_investimento(double sld_investimento) {
			this.sld_investimento = sld_investimento;
		}

		@Override
		public String toString() {
			return "Id -> " + id_investimento + " Investimentos -> " + investimentos + " Saldo investimentos -> " + sld_investimento ;
		}

	}
