package cl.bennu.security.persistence.iface;

import cl.bennu.common.security.domain.User;
import cl.bennu.security.persistence.iface.base.IBaseDao;

public interface IUserDao extends IBaseDao<User> {

    User getByEMail(String email);

}
