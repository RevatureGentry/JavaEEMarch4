package com.revature;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.util.ConnectionFactory;

public class ConnectionFactoryTest {

	@BeforeClass
	public static void setUpConnectionFactory() {
		ConnectionFactory.initializeDatabase();
	}

	@Test
	public void connectionFactory_ShouldCreateConnections() {
		assertTrue(ConnectionFactory.getConnection() instanceof Connection);
	}
}
