package runfeng.chat.service;

import runfeng.chat.model.User;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;


public class ChatDBUtils {
    private static ChatDBUtils instance = new ChatDBUtils();
    private static QueryRunner run = new QueryRunner(ChatDBCP.getInstance());

    private ChatDBUtils(){

    }

    public static ChatDBUtils getInstance(){
        if (null == instance){
            instance = new ChatDBUtils();
        }
        return instance;
    }

    private<T> T executeQuery(String sql, ResultSetHandler<T> rsHandler, Object... args) throws SQLException{
        return run.query(sql, rsHandler, args);

    }

    private<T> int executeUpdate(String sql, Object... args) throws SQLException{
        return run.update(sql, args);
    }

    public int updateUser(int id, String column, Object value){
        String sql = "UPDATE user SET ?=? WHERE VALUES (?, ?)";
        try {
            return this.executeUpdate(sql, id, column, value);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public int insertUser(String username, String password, int age){
        if (validUserExisted(username)){
            return 0;
        }
        String sql = "INSERT INTO user (username, password, age) VALUES (?, ?, ?)";
        try {
            return this.executeUpdate(sql, username, password, age);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    public User getUser(String username){
        ResultSetHandler<User> u = new BeanHandler<User>(User.class);

        try {
            User user = (User) executeQuery("SELECT * FROM user WHERE username = ?", u, username);//run.query("SELECT * FROM user WHERE username = ?", u, username);
            return user;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public boolean validUserExisted(String username){
        User u = getUser(username);
        if (null != u){
            return true;
        }

        return false;
    }

    public boolean validLogin(String username, String password){
        User u = getUser(username);
        if (null != u){
            if (u.validPassword(password)){
                return true;
            }
        }

        return false;
    }
}
