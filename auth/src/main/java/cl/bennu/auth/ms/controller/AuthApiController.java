package cl.bennu.auth.ms.controller;


import cl.bennu.common.security.builder.ResponseBuilder;
import cl.bennu.common.security.domain.User;
import cl.bennu.common.security.domain.common.Response;
import cl.bennu.common.security.exception.ExistingEMailException;
import cl.bennu.security.core.business.SecurityBusiness;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthApiController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody LoginResponse login(@RequestBody final User user) throws ServletException {
        User userDB = SecurityBusiness.getInstance().login(user);

        if (userDB == null) {
            throw new ServletException("Invalid login");
        }

        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setSubject(userDB.getId());
        jwtBuilder.claim("roles", "");
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setExpiration(new Date(new Date().getTime() * 30 * 60000));
        jwtBuilder.signWith(SignatureAlgorithm.HS256, "sport-result");
        String token = jwtBuilder.compact();

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.token = token;
        loginResponse.user = userDB;
        return loginResponse;
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public @ResponseBody Response register(@RequestBody final User user)
            throws ServletException {
        try {
            SecurityBusiness.getInstance().register(user);
            return ResponseBuilder.buildResponse(HttpStatus.OK);
        } catch (ExistingEMailException e) {
            // existe el wn
            return ResponseBuilder.buildResponse(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "contact", method = RequestMethod.POST)
    public @ResponseBody Response contact(@RequestBody final User user)
            throws ServletException {

        return ResponseBuilder.buildResponse(HttpStatus.OK);
    }

    private class LoginResponse {
        public String token;
        public User user;
    }


}
