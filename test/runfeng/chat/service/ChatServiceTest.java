package runfeng.chat.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChatServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		int instance_test = ChatService.getInstance().getInstance_test();
		assertEquals(1, instance_test);
	}

	@Test
	public void testAddUser() throws Exception {
		//boolean a = ;
		assertTrue(ChatService.getInstance().addUser("gt", "123"));
	}

	@Test
	public void testValidLogin() {
		try {
			ChatService.getInstance().addUser("gongtao", "123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(ChatService.getInstance().validLogin("gongtao", "123"));
	}

	@Test
	public void testLoadUserlist() {
		
	}

	@Test
	public void testSaveUserlist() {
		
	}

}
