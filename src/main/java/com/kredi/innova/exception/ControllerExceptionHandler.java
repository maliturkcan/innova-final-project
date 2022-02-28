package com.kredi.innova.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        log.error("Exception hatası alındı. Mesaj : "+ex.getMessage());
        return getApiResponse(request, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<ErrorResponse> handleException(BadRequestException ex, WebRequest request) {
        log.error("BadRequestException hatası alındı. Mesaj : "+ex.getMessage());
        return getApiResponse(request, ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException  ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        for (ConstraintViolation constraintViolation : ex.getConstraintViolations()) {
            errorResponse.addError(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
        }
        return ResponseEntity.badRequest().body(errorResponse) ;
    }

    @ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex, WebRequest request) {
        return getApiResponse(request, ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        return getApiResponse(request, ex.getMessage(), HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<ErrorResponse> getApiResponse(WebRequest request, String message,HttpStatus httpStatus) {
        List<String> messageList = new ArrayList<>();
        messageList.add(message);
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .messageList(messageList)
                .timestamp(new Date())
                .description(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorResponse error = ErrorResponse
                .builder()
                .messageList(new ArrayList<>())
                .timestamp(new Date())
                .description(request.getDescription(false))
                .build();

        ex.getBindingResult().getFieldErrors().forEach(exc -> error.addError(exc.getField() + " -> " + exc.getDefaultMessage()));
        ex.getBindingResult().getGlobalErrors().forEach(exc -> error.addError(exc.getObjectName() + " -> " + exc.getDefaultMessage()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
