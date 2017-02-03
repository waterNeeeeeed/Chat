package runfeng.chat.action.user;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class InsertUserActionTest {
    @Test
    public void insertUser() throws Exception {
        assertEquals("success", new InsertUserAction().insertUser("gtAction01", "1", 20));
    }

}