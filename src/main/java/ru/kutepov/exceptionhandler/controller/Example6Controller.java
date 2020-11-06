package ru.kutepov.exceptionhandler.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.kutepov.exceptionhandler.annotation.CustomExceptionHandler;
import ru.kutepov.exceptionhandler.dto.Response;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CustomExceptionHandler
public class Example6Controller {

    @GetMapping(value = "/testResponseStatusException", produces = APPLICATION_JSON_VALUE)
    public Response testResponseStatusException(@RequestParam(required = false, defaultValue = "false") boolean exception) {
        if (exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "ResponseStatusException in testResponseStatusException");
        }
        return new Response("OK");
    }

}
