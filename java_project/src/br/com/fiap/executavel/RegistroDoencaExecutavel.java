package br.com.fiap.executavel;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.fiap.com.dao.DoencaDAO;
import br.fiap.com.local.Municipio;

public class RegistroDoencaExecutavel extends Doenca {

	private static int cs_not;
	private static int cs_conf;
	private static String dt_registro;
	
	public static void main(String[] args) throws SQLException {
		
		/*
		 * Setando ID doença de forma estática
		 */
		Doenca doen = new Doenca();
		doen.setId_doenca(2);
		
		/*
		 * Setando ID município estático
		 */
		
		Municipio muni = new Municipio();
		muni.setId_municipio(4);
		
		/*
		 * Setando status do registro para notificação ou confirmação de caso 
		 */
		cs_not = 1;
		cs_conf = 1;
		
		/*
		 * Setando a data do registro para um valor estático
		 */
		dt_registro = "08/08/1991";
		
		
		/*
		 * Criação de novo objeto DAO
		 */
		DoencaDAO doenca = new DoencaDAO();
		
		//doenca.registraDoenca(dt_registro, doen.getId_doenca(), muni.getId_municipi(), cs_not, cs_not);
		
		/*
		 * Função para listagem de dados cadastrados por região e período mensal
		 */
		doenca.listaDoencaPorDataRegiao(5, 01, 12);

	}
	
	public int getCs_not() {
		return cs_not;
	}

	public void setCs_not(int cs_not) {
		this.cs_not = cs_not;
	}

	public int getCs_conf() {
		return cs_conf;
	}

	public void setCs_conf(int cs_conf) {
		this.cs_conf = cs_conf;
	}

	public  String getDt_registro() {
		return dt_registro;
	}

	public void setDt_registro(String dt_registro) {
		this.dt_registro = dt_registro;
	}
	
	

}
