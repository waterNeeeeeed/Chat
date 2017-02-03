package runfeng.chat.service;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;


public class BaseDAO implements DAO{
    private static QueryRunner run = new QueryRunner(ChatDBCP.getInstance());


    public<T> T executeQuery(String sql, ResultSetHandler<T> rsHandler, Object... args){
        try{
            return run.query(sql, rsHandler, args);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    public<T> int executeUpdate(String sql, Object... args){
        try{
            return run.update(sql, args);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }


}
