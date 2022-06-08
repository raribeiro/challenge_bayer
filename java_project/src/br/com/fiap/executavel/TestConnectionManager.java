package br.com.fiap.executavel;

import br.com.fiap.connection.ConnectionManager;

public class TestConnectionManager {

	public static void main(String[] args) {
		ConnectionManager conexao = new ConnectionManager();

		conexao.connect();
	}

}
