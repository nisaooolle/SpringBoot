package com.data.tokoonline.exception;

import com.data.tokoonline.response.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHadler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException) {
        return ResponseHelper.error(notFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<?> emailException(EmailException emailException) {
        return ResponseHelper.error(emailException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
