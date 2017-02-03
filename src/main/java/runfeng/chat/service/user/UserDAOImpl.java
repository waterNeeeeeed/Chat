package runfeng.chat.service.user;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import runfeng.chat.model.user.User;
import runfeng.chat.service.BaseDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class UserDAOImpl extends BaseDAO implements UserDAO {
    /*
    *column为要修改的列，根据id修改
     */
    public int updateUser(int id, String column, Object value){
        String sql = "UPDATE user SET " + column + "=? WHERE id=?";
        return executeUpdate(sql, value, id);
    }

    public int insertUser(String username, String password, int age){
        String sql = "INSERT INTO user (username, password, age) VALUES (?, ?, ?)";
        return executeUpdate(sql, username, password, age);
    }

    public User getUser(String username){
        ResultSetHandler<User> u = new BeanHandler<User>(User.class);
        String sql = "SELECT * FROM user WHERE username = ?";
        return (User) executeQuery(sql, u, username);
    }

    @Override
    public int deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        return executeUpdate(sql, id);
    }

}
