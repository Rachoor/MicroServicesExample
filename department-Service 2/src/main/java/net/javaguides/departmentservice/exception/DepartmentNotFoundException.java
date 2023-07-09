package net.javaguides.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException{
    private String msg;

    public DepartmentNotFoundException(String id) {
        super("Resource not Found with the ID: "+ id);
        this.msg = msg;
    }
}
