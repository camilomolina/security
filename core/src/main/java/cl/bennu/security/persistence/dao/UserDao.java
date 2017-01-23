package cl.bennu.security.persistence.dao;

import cl.bennu.common.security.domain.User;
import cl.bennu.security.persistence.dao.base.BaseDao;
import cl.bennu.security.persistence.iface.IUserDao;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class UserDao extends BaseDao<User> implements IUserDao {

    @Override
    public User getByEMail(String email) {
        FindIterable<Document> iterable = getCollection().find(Filters.eq("email", email));
        if (iterable.iterator().hasNext()) {
            return buildT(iterable.iterator().next());
        }

        return null;
    }

    public void save(User user) {
        if (user.getId() != null) {
            User userDB = getById(user.getId());
            user.setEmail(userDB.getEmail());
        }
        //collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));
        super.save(user);
    }

}
