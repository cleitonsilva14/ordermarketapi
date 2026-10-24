package io.dev.ordermarketapi.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ProblemDetail handleOrderNotFoundException(OrderNotFoundException exception, HttpServletRequest request) {

        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());

        problemDetail.setProperty("timestamp", Instant.now());

        return problemDetail;
    }

    // @ExceptionHandler(IllegalStateException.class)
    // public ProblemDetail handleIllegalStateException(IllegalStateException exception, HttpServletRequest request) {

    //     ProblemDetail problemDetail = ProblemDetail
    //             .forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());

    //     problemDetail.setProperty("timestamp", Instant.now());

    //     return problemDetail;
    // }

}
