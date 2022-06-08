package br.com.fiap.store.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManagerSample {

	private static ConnectionManagerSample connectionManager;

	private ConnectionManagerSample() {
	}

	public static ConnectionManagerSample getInstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManagerSample();
		}
		return connectionManager;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "USUARIO",
					"SENHA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}