package br.com.fiap.executavel;

import java.sql.SQLException;

import br.fiap.com.dao.DoencaDAO;
import br.fiap.com.local.Municipio;

public class RegistroDoencaExecutavel extends Doenca {
	
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
		int cs_not = 1;
		int cs_conf = 1;
		
		/*
		 * Setando a data do registro para um valor estático
		 */
		String dt_registro = "08/08/2022";
		
		
		/*
		 * Criação de novo objeto DAO
		 */
		DoencaDAO doenca = new DoencaDAO();
		
		//doenca.registraDoenca(dt_registro, doen.getId_doenca(), muni.getId_municipio(), cs_not, cs_conf);
		
		/*
		 * Listagem completa de registros de doença com possibilidade de filtro por período
		 * @param 2 -> mês inicial
		 * @param 4 -> mês final
		 */
		//doenca.listaDoencaTotal(01, 12);
		
		/*
		 * Função para listagem de dados cadastrados por região e período mensal
		 * @Param 1 -> 4 (sudeste) ou 5 (sul) ou ID da região cadastrada no banco
		 * @param 2 -> mês inicial
		 * @param 4 -> mês final
		 */
		//doenca.listaDoencaPorDataRegiao(5, 01, 12);

	}
	
	
	

}
