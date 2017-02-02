package runfeng.chat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import runfeng.chat.service.ChatDBUtils;

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
		if ("" != req.getParameter("age"))
			age = Integer.parseInt(req.getParameter("age"));
		
		if (null == username || "" ==  username.trim() 
				|| null == password || "" == password.trim()){
			req.setAttribute("tip", "�û��� ���벻��Ϊ�� ");
		}
		else{
			try {
				if (1 == ChatDBUtils.getInstance().insertUser(username, password, age)){
					req.setAttribute("tip", "�û���ӳɹ� ");
					
				}
				else{
					req.setAttribute("tip", "�û����ʧ��");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				req.setAttribute("tp", e.getMessage());
			}
		}
		req.getRequestDispatcher("/WEB-INF/regResult.jsp").forward(req, resp);
	}

}
