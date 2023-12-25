package com.example.springDemo.exception;

import com.example.springDemo.controller.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: IntelliJ IDEA
 * @description: validator校验异常 处理器
 * @author: CCYT
 * @create: 2023-12-25 21:46
 **/

@ControllerAdvice(assignableTypes = {ProductController.class})
public class GlobalExceptionHandler {
    /**
     * @Description: 捕获ProductController中的校验异常 并返回异常到前端
     * @Param: [ex]
     * @return： org.springframework.http.ResponseEntity<java.util.Map<java.lang.String,java.lang.String>>
     * @Author: CCYT
     * @Date: 2023/12/25
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
