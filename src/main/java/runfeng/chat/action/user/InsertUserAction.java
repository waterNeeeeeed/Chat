package runfeng.chat.action.user;

import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class InsertUserAction {
    public int insertUser(String username, String password, int age){
        UserDAO u = DAOFactory.getUserDAO();
        if (new ValidUserExistedAction().validUserExisted(username)){
            return 0;
        }
        return u.insertUser(username, password, age);
    }
}
