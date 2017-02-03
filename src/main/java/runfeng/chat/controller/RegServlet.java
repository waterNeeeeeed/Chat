package runfeng.chat.controller;

import runfeng.chat.action.user.InsertUserAction;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static runfeng.chat.action.Action.SUCCESS;
import static runfeng.chat.action.Action.USER_EXISTED;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/register")
public class RegServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String age = req.getParameter("age");

        String result = new InsertUserAction().insertUser(username, password, age);
        if (SUCCESS.equals(result)){
            req.setAttribute("tip", "用户添加成功 ");
        }
        else if (USER_EXISTED.equals(result)) {
            req.setAttribute("tip", "用户已存在");
        }
        else{
            req.setAttribute("tip", "用户添加失败");
        }

        req.getRequestDispatcher("/WEB-INF/regResult.jsp").forward(req, resp);
    }

}