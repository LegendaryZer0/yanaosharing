package ru.itis.demo.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {
            IllegalStateException.class,
            NullPointerException.class,
            IllegalArgumentException.class
    })
    protected String handleException(HttpServletResponse response, Exception ex) {
        log.info(ex.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return "error-page";
    }

    @ExceptionHandler(value = {
            EntityExistsException.class
    })
    protected String handleEntityExistException(HttpServletResponse response, Exception ex) {
        log.info(ex.getMessage());
        return "registration.jsp";
    }
}
