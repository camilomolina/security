package cl.bennu.common.security.builder;

import cl.bennu.common.security.domain.common.Response;
import org.springframework.http.HttpStatus;

public class ResponseBuilder {

    public static Response buildResponse(HttpStatus httpStatus) {
        Response response = new Response();
        response.setHttpStatus(httpStatus);
        return response;
    }

    public static Response buildResponse(HttpStatus httpStatus, String message) {
        Response response = new Response();
        response.setHttpStatus(httpStatus);
        response.setMessage(message);
        return response;
    }

    public static Response buildResponse(Object o, HttpStatus httpStatus) {
        Response response = new Response();
        response.setO(o);
        response.setHttpStatus(httpStatus);
        return response;
    }

}
