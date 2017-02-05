package runfeng.chat.service.user.msg;

import runfeng.chat.model.msg.Msg;

import java.util.List;

/**
 * Created by 帝 on 2017/2/4.
 */
public interface MsgDAO {
    int insertMsg(String username, String message);
    List<Msg> getAllMsg();
    StringBuffer getAllMsgString();
}
