package cl.bennu.user.security.api;

import cl.bennu.common.security.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserApi {

    String BASE_URI = "/api/security/users";

    @ResponseBody
    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    List<User> getAll();

    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    void delete(@PathVariable("id") String id);

    @ResponseBody
    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    User getById(@PathVariable("id") String id);

    @ResponseBody
    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    User update(@RequestBody User user);

    @ResponseBody
    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    User save(@RequestBody User user);

}