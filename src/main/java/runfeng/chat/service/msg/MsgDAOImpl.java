package runfeng.chat.service.msg;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import runfeng.chat.model.msg.Msg;
import runfeng.chat.service.BaseDAO;

import java.util.List;

/**
 * Created by 帝 on 2017/2/4.
 */
public class MsgDAOImpl extends BaseDAO implements MsgDAO {

    @Override
    public List<Msg> getAllMsg() {
        //List<Msg> msgList = new ArrayList<Msg>();
        ResultSetHandler<List<Msg>> msg = new BeanListHandler<Msg>(Msg.class);
        String sql = "SELECT * FROM msg";
        return executeQuery(sql, msg);
        /*StringBuilder sb = new StringBuilder();
        for (Iterator<Msg> m=msgList.iterator(); m.hasNext();){
        }*/
    }

    public StringBuffer getAllMsgString(){
        List<Msg> msgList = getAllMsg();
        StringBuffer sb = new StringBuffer();
        msgList.iterator().forEachRemaining(o->{
            Msg temp = (Msg)o;
            sb.append(temp.getId()).append(":");
            sb.append(temp.getUsername()).append(":");
            sb.append(temp.getMessage()).append("\n");
        });
        return sb;
    }
    @Override
    public int insertMsg(String username, String message) {
        String sql = "INSERT INTO msg (username, message) VALUES(?, ?)";

        return executeUpdate(sql, username, message);
    }
}
