package presentation;

import sn.exo.controller.DB;
import sn.exo.controller.IUser;
import sn.exo.controller.UserImp;
import sn.exo.entities.User;

public class Main {
    public static void main(String[] args) throws Exception{
        DB db = new DB();
        db.open();
        IUser iuser = new UserImp();
        User user1 = new User();
        iuser.Add(user1);
        iuser.update(user1);
        iuser.Delete(1);
    }
}
