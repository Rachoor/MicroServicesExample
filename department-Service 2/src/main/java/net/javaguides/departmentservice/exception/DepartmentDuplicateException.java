package net.javaguides.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentDuplicateException extends RuntimeException{
    public DepartmentDuplicateException(String code) {
        super("Department with the code is already present : "+ code);
    }
}
