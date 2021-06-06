package com.leonardosabino.blog.exception;

import com.leonardosabino.blog.model.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalApiExceptionHandlerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiErrorDTO> handleApplicationException(final ApiException e) {
        HttpStatus httpStatus = getHttpStatus(e);

        ApiErrorDTO body = new ApiErrorDTO(httpStatus.value(), e.getMessage());
        return new ResponseEntity<>(body, httpStatus);
    }

    private HttpStatus getHttpStatus(ApiException e) {
        return (e.getClass().isAnnotationPresent(ErrorStatus.class))
                ? e.getClass().getAnnotation(ErrorStatus.class).value()
                : HttpStatus.BAD_REQUEST;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorDTO handle(MethodArgumentNotValidException ex) {
        return new ApiErrorDTO(HttpStatus.BAD_REQUEST.value(), getMethodArgumentErrors(ex.getBindingResult()));
    }

    private String getMethodArgumentErrors(BindingResult bindResults) {
        var res = new StringBuilder();
        for (ObjectError e : bindResults.getAllErrors()) {
            String field = ((FieldError) e).getField();
            res.append(field).append(": ").append(e.getDefaultMessage()).append("; ");
        }
        return res.toString();
    }
}