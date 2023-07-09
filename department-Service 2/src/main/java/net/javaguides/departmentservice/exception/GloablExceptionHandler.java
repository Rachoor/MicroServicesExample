package net.javaguides.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GloablExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    protected ResponseEntity<Object> handleDepartmentException(  Exception exception,
                                                                 WebRequest request) {
        System.out.println("MyMESSAGE"+ exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DepartmentDuplicateException.class)
    protected ResponseEntity<Object> handleDepartmentDuplicateException(  Exception exception,
                                                                 WebRequest request) {
        System.out.println("MyMESSAGE"+ exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
