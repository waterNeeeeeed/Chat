package runfeng.chat.controller;

import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        int age = 0;

        UserDAO userDAO = DAOFactory.getUserDAO();

        if ("" != req.getParameter("age"))
            age = Integer.parseInt(req.getParameter("age"));

        if (null == username || "" ==  username.trim()
                || null == password || "" == password.trim()){
            req.setAttribute("tip", "用户名 密码不能为空 ");
        }
        else{
            try {
                if (1 == userDAO.insertUser(username, password, age)){
                    req.setAttribute("tip", "用户添加成功 ");

                }
                else{
                    req.setAttribute("tip", "用户添加失败");
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                req.setAttribute("tp", e.getMessage());
            }
        }
        req.getRequestDispatcher("/WEB-INF/regResult.jsp").forward(req, resp);
    }

}