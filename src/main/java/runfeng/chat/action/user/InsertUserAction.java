package runfeng.chat.action.user;

import runfeng.chat.action.Action;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class InsertUserAction implements Action{

    public String insertUser(String username, String password, String age){
        UserDAO u = DAOFactory.getUserDAO();

        if (age.equals(""))
            return ERROR;
        if (null == username || "" ==  username.trim()
                || null == password || "" == password.trim()){
            return ERROR;//req.setAttribute("tip", "用户名 密码不能为空 ");
        }

        if (new ValidUserExistedAction().validUserExisted(username)){
            return USER_EXISTED;
        }
        if (1 == u.insertUser(username, password, Integer.parseInt(age))){
            return SUCCESS;
        }
        return ERROR;
    }
}
