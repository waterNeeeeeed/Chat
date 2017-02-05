package runfeng.chat.service.user;

import org.junit.Test;
import runfeng.chat.model.user.User;
import runfeng.chat.service.BaseDAO;
import runfeng.chat.service.DAOFactory;

import static org.junit.Assert.*;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class UserDAOImplTest {
    @Test
    public void updateUser() throws Exception {
        UserDAO u = DAOFactory.getUserDAO();
        assertEquals(1, u.updateUser(1, "age", "30"));
    }

    @Test
    public void insertUser() throws Exception {
        User u = new User();
        u.setUsername("巩涛");
        u.setPassword("1123");
        u.setAge(20);
        UserDAO userDAO = DAOFactory.getUserDAO();
        int n = userDAO.insertUser(u.getUsername(), "1123", u.getAge());
        assertEquals(1, n);
    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {
        UserDAO userDAO = DAOFactory.getUserDAO();
        int n = userDAO.deleteUser(4);
        assertEquals(1, n);
    }

}