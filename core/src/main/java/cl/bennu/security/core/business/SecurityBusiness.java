package cl.bennu.security.core.business;

import cl.bennu.common.security.domain.User;
import cl.bennu.common.security.exception.ExistingEMailException;
import cl.bennu.security.persistence.factory.AppFactory;
import cl.bennu.security.persistence.iface.IUserDao;

import java.util.List;

public class SecurityBusiness {

    private static SecurityBusiness ourInstance = new SecurityBusiness();

    public static SecurityBusiness getInstance() {
        return ourInstance;
    }

    private SecurityBusiness() {
    }

    public User login(User user) {
        IUserDao userDao = AppFactory.getUserDao();

        User userDB = userDao.getByEMail(user.getEmail());
        if (userDB != null && userDB.getPassword().equals(user.getPassword())) {
            return userDB;
        }
        return null;
    }

    public List<User> getUserAll() {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getAll();
    }

    public void saveUser(User user) {
        IUserDao userDao = AppFactory.getUserDao();
        userDao.save(user);
    }

    public void deleteUser(String id) {
        IUserDao userDao = AppFactory.getUserDao();
        userDao.delete(id);
    }

    public User getUserById(String id) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getById(id);
    }

    public User getUserByName(String name) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.getByName(name);
    }

    public List<User> findUser(User user) {
        IUserDao userDao = AppFactory.getUserDao();
        return userDao.find(user);
    }

    public void register(User user) throws ExistingEMailException {
        IUserDao userDao = AppFactory.getUserDao();

        User userDB = userDao.getByEMail(user.getEmail());
        if (userDB != null) throw new ExistingEMailException();

        userDao.save(user);
    }


}

