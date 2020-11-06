package ru.kutepov.exceptionhandler.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kutepov.exceptionhandler.annotation.CustomExceptionHandler;
import ru.kutepov.exceptionhandler.dto.Response;
import ru.kutepov.exceptionhandler.exception.BusinessException;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = CustomExceptionHandler.class)
public class CustomAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Response> handleException(BusinessException e) {
        String message = String.format("%s %s", LocalDateTime.now(), e.getMessage());
        Response response = new Response(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
