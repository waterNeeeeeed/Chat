package runfeng.chat.service;

import runfeng.chat.service.user.UserDAOImpl;

/**
 * Created by hasee-pc on 2017/2/3.
 */
public class DAOFactory {
    public static UserDAOImpl getUserDAO(){
        return new UserDAOImpl();
    }
}
