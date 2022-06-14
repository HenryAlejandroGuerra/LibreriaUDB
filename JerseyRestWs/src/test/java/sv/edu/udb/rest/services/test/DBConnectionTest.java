package sv.edu.udb.rest.services.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import sv.edu.udb.rest.connection.DbConnection;

public class DBConnectionTest extends DbConnection {

	@Test
	public void test() throws SQLException {
		connect();
		close();
	}

}
