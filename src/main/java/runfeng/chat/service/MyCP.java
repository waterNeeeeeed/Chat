package runfeng.chat.service;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.activation.DataSource;
import java.util.Properties;

/**
 * Created by 帝 on 2017/2/5.
 */
public class MyCP {
    private static MyCP instance = new MyCP();
    private static Properties pp = new Properties();
    private static BasicDataSource bs;
    static {
        try{
            pp.put("driverClassName", "com.mysql.jdbc.Driver");
            pp.put("url", "jdbc:mysql://127.0.0.1:3306/chat");
            pp.put("username", "root");
            pp.put("password", "gt1987");
            bs = BasicDataSourceFactory.createDataSource(pp);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private MyCP(){

    }
    public static MyCP getInstance(){
        return instance;
    }

    public BasicDataSource getDS(){
        return instance.bs;
    }
}
