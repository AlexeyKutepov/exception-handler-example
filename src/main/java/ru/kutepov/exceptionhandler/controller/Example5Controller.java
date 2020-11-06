package ru.kutepov.exceptionhandler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kutepov.exceptionhandler.annotation.CustomExceptionHandler;
import ru.kutepov.exceptionhandler.dto.Response;
import ru.kutepov.exceptionhandler.exception.BusinessException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CustomExceptionHandler
public class Example5Controller {

    @GetMapping(value = "/testCustomControllerAdvice", produces = APPLICATION_JSON_VALUE)
    public Response testCustomControllerAdvice(@RequestParam(required = false, defaultValue = "false") boolean exception)
            throws BusinessException {
        if (exception) {
            throw new BusinessException("BusinessException in testCustomAdvice");
        }
        return new Response("OK");
    }

}
