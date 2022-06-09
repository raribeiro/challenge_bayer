package br.fiap.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.connection.ConnectionManager;

public class DoencaDAO {
	
	private Connection conexao;
	private ResultSet rs;
	
	public void listaDoencaPorDataRegiao(int cd_regiao, int mes_inicial, int mes_final) throws SQLException {
		rs = null;
		ConnectionManager connect = new ConnectionManager();
		PreparedStatement stmt = null;
		
		try {
			conexao = connect.connect();
			
			String sql = "SELECT d.nm_doenca, r.dt_ocorrencia, r.cs_not, r.cs_conf, m.nm_municipio, e.nm_estado, reg.nm_regiao FROM t_reg_doenca r JOIN t_nm_muni m ON m.id_municipio = r.t_nm_muni_id_municipio JOIN t_tipo_doenca d ON r.t_tipo_doenca_id_doenca = d.id_doenca JOIN t_nm_estado e ON e.id_estado = m.t_nm_estado_id_estado AND e.t_nm_regiao_id_regiao = "+ cd_regiao  +" JOIN t_nm_regiao reg ON reg.id_regiao = "+ cd_regiao  +" WHERE r.dt_ocorrencia BETWEEN TO_DATE('"+ mes_inicial +"', 'MM') AND TO_DATE('"+ mes_final +"', 'MM')";

			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			int casos = 0;
			System.out.println("Nome da Doença | Data da ocorrência | Notificação | Confirmação | Cidade | Estado | Região");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("NM_DOENCA") + "	|" + rs.getString("DT_OCORRENCIA") + "	|" + rs.getString("CS_NOT") + "	|"
						+ rs.getString("CS_CONF") + "	|" + rs.getString("NM_MUNICIPIO") + "	|	" + rs.getString("NM_ESTADO") + "	| "+ rs.getString("NM_REGIAO"));
				casos++;
			}
			
			System.out.println("\nTOTAL DE CASOS ENCONTRADOS>>>>> " + casos);
		}finally {
			connect.close();
		}
		
	}
	
	public void registraDoenca(String dt_registro, int id_doenca, int id_municipio, int cs_not, int nc_conf) throws SQLException {
		rs = null;
		ConnectionManager connect = new ConnectionManager();
		PreparedStatement stmt = null;
		
		try {
			conexao = connect.connect();
			
			String sql = "select * from t_nm_muni";
			stmt = conexao.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			
			/*while(rs.next()) {
				System.out.println(rs.getString("NM_DOENCA"));
			}*/
		}finally {
			connect.close();
		}
		
	}

}
