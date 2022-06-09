package br.com.fiap.executavel;

public class Doenca {
	
	private int id_doenca;
	private String nm_doenca;
	
	/*
	 * Classe responsável por obter o ID da doença em memória
	 * */
	public int getId_doenca() {
		return id_doenca;
	}
	
	/*
	 * Classe responsável por setar o ID da doença em memória
	 * */
	public void setId_doenca(int id_doenca) {
		this.id_doenca = id_doenca;
	}
	
	/*
	 * Classe responsável por obter o nome da doença em memória
	 * */
	public String getNm_doenca() {
		return nm_doenca;
	}
	
	/*
	 * Classe responsável por setar o nome da doença em memória
	 * */
	public void setNm_doenca(String nm_doenca) {
		this.nm_doenca = nm_doenca;
	}
	
	
}
