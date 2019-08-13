package com.github.lgsxiaosen.utils.utils.exception;

import com.github.lgsxiaosen.utils.utils.ResponseCode;
import com.github.lgsxiaosen.utils.utils.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import javax.validation.ValidationException;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiaosen
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    public ControllerExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult handlerException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseResult(ResponseCode.ERROR, ResponseCode.ERROR.msg() + "  " + e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseResult handlerMethodArgumentException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        String message = validMethod(bindingResult);
        return new ResponseResult(ResponseCode.ERROR, message);
    }

    private static String validMethod(BindingResult result) {
        String message = "";
        List<FieldError> fieldErrors = result.getFieldErrors();

        String defaultMessage;
        for(Iterator var3 = fieldErrors.iterator(); var3.hasNext(); message = message + defaultMessage) {
            FieldError fieldError = (FieldError)var3.next();
            defaultMessage = fieldError.getField() + fieldError.getDefaultMessage();
        }
        return message;
    }

    @ExceptionHandler({ServletException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult headerException(ServletException e) {
        return new ResponseResult(ResponseCode.ARGUMENTERROR, e.getMessage());
    }

    @ExceptionHandler({ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult headerException(ValidationException e) {
        return new ResponseResult(ResponseCode.ARGUMENTERROR, e.getMessage());
    }



}
