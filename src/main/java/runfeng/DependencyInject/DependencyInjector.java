package runfeng.DependencyInject;

import runfeng.chat.action.user.InsertUserAction;
import runfeng.chat.service.DAOFactory;
import runfeng.chat.service.user.UserDAO;

/**
 * Created by 帝 on 2017/2/7.
 */
public class DependencyInjector {
    public Object getObject(Class type){

        if (type == InsertUserAction.class){
            return createInsertUserAction();
        }

        return null;
    }

    public InsertUserAction createInsertUserAction(){
        InsertUserAction iua = new InsertUserAction();
        iua.setUserDAO(createUserDAO());
        return iua;
    }

    public UserDAO createUserDAO(){
        return DAOFactory.getUserDAO();
    }

}
