package com.tanay.bookingapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tanay.bookingapp.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(EmailAlreadyExistsException.class)
public ResponseEntity<ErrorResponse> handleEmailExists(EmailAlreadyExistsException ex) {

ErrorResponse error = new ErrorResponse(
HttpStatus.CONFLICT.value(),
ex.getMessage(),
LocalDateTime.now()
);

return new ResponseEntity<>(error, HttpStatus.CONFLICT);
}

@ExceptionHandler(InvalidCredentialsException.class)
public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {

ErrorResponse error = new ErrorResponse(
HttpStatus.UNAUTHORIZED.value(),
ex.getMessage(),
LocalDateTime.now()
);

return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
}
}
