package runfeng.chat.action.user;

import runfeng.chat.model.user.User;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class ValidUserExistedAction {
    public boolean validUserExisted(String username){
        UserDAO u = DAOFactory.getUserDAO();
        if (null != u.getUser(username)){
            return true;
        }
        return false;
    }
}
