package runfeng.chat.controller;

import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.msg.MsgDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by 帝 on 2017/2/5.
 */
@WebServlet("/chat.do")
public class ChatServlet extends HttpServlet{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("utf-8");
            String msg = req.getParameter("chatMsg");
            String user;
            MsgDAO md = DAOFactory.getMsgDAO();
            if (null != msg && !msg.equals("")){

                user = (String)req.getSession(true).getAttribute("user");
                md.insertMsg(user, msg);
            }
            else{
                /*user = (String)req.getSession(true).getAttribute("user");
                md.insertMsg(user, "empty");*/
            }
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.print(md.getAllMsgString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
