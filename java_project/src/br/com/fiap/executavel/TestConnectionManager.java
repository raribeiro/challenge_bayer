package br.com.fiap.executavel;

import java.sql.SQLException;

import br.com.fiap.connection.ConnectionManager;

public class TestConnectionManager {

	public static void main(String[] args) throws SQLException {
		ConnectionManager conexao = new ConnectionManager();

		conexao.connect();
		conexao.close();
	}

}
