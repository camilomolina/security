package cl.bennu.user.security.controller;

import cl.bennu.common.security.domain.User;
import cl.bennu.security.core.business.SecurityBusiness;
import cl.bennu.user.security.api.UserApi;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserApiController implements UserApi {

    @Override
    public List<User> getAll() {
        return SecurityBusiness.getInstance().getUserAll();
    }

    @Override
    public void delete(@PathVariable("id") String id) {
        SecurityBusiness.getInstance().deleteUser(id);
    }

    @Override
    public User getById(@PathVariable("id") String id) {
        return SecurityBusiness.getInstance().getUserById(id);
    }

    @Override
    public User update(@RequestBody User user) {
        SecurityBusiness.getInstance().saveUser(user);
        return user;
    }

    @Override
    public User save(@RequestBody User user) {
        SecurityBusiness.getInstance().saveUser(user);
        return user;
    }


}
