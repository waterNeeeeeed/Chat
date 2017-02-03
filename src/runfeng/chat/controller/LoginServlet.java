package runfeng.chat.controller;

import runfeng.chat.service.ChatDBUtils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatServiceServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (true == ChatDBUtils.getInstance().validLogin(username, password)) {
            req.setAttribute("tip", "登录成功");
        } else {
            req.setAttribute("tip", "登录失败");
        }

        req.getRequestDispatcher("/loginR").forward(req, resp);

    }

}