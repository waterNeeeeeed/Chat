package runfeng.chat.action.user;

import runfeng.chat.model.user.User;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class ValidLoginAction {
    public boolean validLogin(String username, String password){
        UserDAO u = DAOFactory.getUserDAO();
        User user = u.getUser(username);
        if (null != user){
            if (user.validPassword(password)){
                return true;
            }
        }

        return false;
    }
}
