package cl.bennu.security.persistence.factory;

import cl.bennu.security.persistence.dao.RolDao;
import cl.bennu.security.persistence.dao.UserDao;
import cl.bennu.security.persistence.iface.IRolDao;
import cl.bennu.security.persistence.iface.IUserDao;

public class AppFactory {

    public static IUserDao getUserDao() {
        return new UserDao();
    }

    public static IRolDao getRolDao() {
        return new RolDao();
    }

}
