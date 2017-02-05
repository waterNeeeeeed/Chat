package runfeng.chat.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.Collections;
import javax.sql.DataSource;

public class ChatDBCP implements DataSource{
    private static List<Connection> connList = Collections.synchronizedList(new LinkedList<Connection>());
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    private static int CONNECTION_NUM = 100;
    private static ChatDBCP instance = new ChatDBCP();

    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://127.0.0.1:3306/chat";
        username = "root";
        password = "gt1987";

        try {
            Class.forName(driver);
            for (int i=0; i<CONNECTION_NUM; i++){
                connList.add(DriverManager.getConnection(url, username, password));
            }
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private ChatDBCP(){

    }

    public static ChatDBCP getInstance(){
        if (instance == null){
            instance = new ChatDBCP();
        }

        return instance;
    }

    public Connection getConnection() throws SQLException {
        synchronized(connList){

            if (connList.isEmpty()){
                throw new SQLException("no available connection");
            }
            return connList.remove(0);
        }

    }

    public void freeConnection(Connection e){
        connList.add(e);
    }

    public int closeConnList(){
        synchronized(connList){
            int i = 0;
            try {

                for (Iterator<Connection> conn = connList.iterator(); conn.hasNext(); ) {
                    conn.next().close();
                    i++;
                }
                return i;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }


    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLoginTimeout(int arg0) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isWrapperFor(Class<?> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> arg0) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection(String arg0, String arg1) throws SQLException {
        // TODO Auto-generated method stub
        if (connList.isEmpty()){
            try {
                throw new Exception("no available connection");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
        return connList.remove(0);
    }
}