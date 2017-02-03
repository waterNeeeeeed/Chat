package runfeng.chat.action.user;

import runfeng.chat.action.Action;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class InsertUserAction implements Action{

    public String insertUser(String username, String password, int age){
        UserDAO u = DAOFactory.getUserDAO();
        if (new ValidUserExistedAction().validUserExisted(username)){
            return USER_EXISTED;
        }
        if (1 == u.insertUser(username, password, age)){
            return SUCCESS;
        }
        return ERROR;
    }
}
