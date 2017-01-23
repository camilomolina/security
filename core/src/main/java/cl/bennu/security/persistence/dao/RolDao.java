package cl.bennu.security.persistence.dao;

import cl.bennu.common.security.domain.Rol;
import cl.bennu.common.security.domain.User;
import cl.bennu.security.persistence.dao.base.BaseDao;
import cl.bennu.security.persistence.iface.IRolDao;
import cl.bennu.security.persistence.iface.IUserDao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.List;

public class RolDao extends BaseDao<Rol> implements IRolDao {

    @Override
    public List<User> findRolByUser(String id) {
        return null;
    }
}
