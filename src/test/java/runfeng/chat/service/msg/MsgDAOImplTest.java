package runfeng.chat.service.msg;

import org.junit.Test;
import runfeng.chat.model.msg.Msg;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 帝 on 2017/2/4.
 */
public class MsgDAOImplTest {
    @Test
    public void getAllMsg() throws Exception {
        List<Msg> m = new MsgDAOImpl().getAllMsg();
        StringBuilder sb = new StringBuilder();
        m.iterator().forEachRemaining(o->{
                sb.append(((Msg)o).getId()).append(":");
                sb.append(((Msg)o).getUsername()).append(":");
                sb.append(((Msg)o).getMessage());
                sb.append("\n");
        });
        /*
        for (Iterator<Msg> n=m.iterator(); n.hasNext();){
            Msg temp = n.next();
            sb.append(temp.getId());
            sb.append(":");
            sb.append(temp.getUsername());
            sb.append(":");
            sb.append(temp.getMessage());
            sb.append("\r\n");*/

            //1:gongtao:enen

            /*sb.append(n.next().getId());
            sb.append(":");
            sb.append(n.next().getUsername());
            sb.append(":");
            sb.append(n.next().getMessage());
            sb.append("\r\n");
        }*/
        System.out.println(sb);
    }

    @Test
    public void insertMsg() throws Exception {
        assertEquals(1, new MsgDAOImpl().insertMsg("gongtao", "enen"));
    }

}