package cl.bennu.security.persistence.iface;

import cl.bennu.common.security.domain.Rol;
import cl.bennu.common.security.domain.User;
import cl.bennu.security.persistence.iface.base.IBaseDao;

import java.util.List;

public interface IRolDao extends IBaseDao<Rol> {

    List<User> findRolByUser(String id);

}
