package runfeng.chat.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChatDBUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testValidPassword() {
		User u = ChatDBUtils.getInstance().getUser("gt");
		assertTrue(u.validPassword("111"));
	}

	@Test
	public void testInsertUser(){
		User u = new User();
		u.setUsername("gongtao");
		u.setPassword("1123");
		u.setAge(20);
		
		int n = ChatDBUtils.getInstance().insertUser(u.getUsername(), "1123", u.getAge());
		assertEquals(1, n);
		
	}
}
