package runfeng.chat.service.user;

import runfeng.chat.model.user.User;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public interface UserDAO {
    int updateUser(int id, String column, Object value);
    int insertUser(String username, String password, int age);
    User getUser(String username);
    int deleteUser(int id);
    boolean validUserExisted(String username);
    boolean validLogin(String username, String password);
}
