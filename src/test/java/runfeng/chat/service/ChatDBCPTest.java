package runfeng.chat.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 帝 on 2017/2/4.
 */
public class ChatDBCPTest {
    @Test
    public void getConnection() throws Exception {
        assertNotNull(ChatDBCP.getInstance().getConnection());
    }

}