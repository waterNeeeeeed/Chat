package runfeng.chat.service;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class ChatDBCPTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConnection() throws Exception {
		ChatDBCP instance = ChatDBCP.getInstance();
		Connection conn = instance.getConnection();
		assertNotNull(conn);
		//instance.releaseConnection(conn);
		assertEquals(011, instance.closeConnList());
		instance.getConnection();
		assertEquals(8, instance.closeConnList());
	}



}
