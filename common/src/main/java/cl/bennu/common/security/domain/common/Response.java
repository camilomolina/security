package cl.bennu.common.security.domain.common;

import org.springframework.http.HttpStatus;

public class Response {

    private Object o;
    private String message;
    private HttpStatus httpStatus;

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
