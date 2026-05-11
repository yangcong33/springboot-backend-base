package com.jacob.backend.common.exceptions;

import com.jacob.backend.common.response.ApiResponse;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 1. 用 @RestControllerAdvice 声明全局异常处理类
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理参数校验异常
     * 2. 用 @ExceptionHandler(具体异常.class) 捕获某类异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> handleValidationException(MethodArgumentNotValidException exception) {
        // 3. 从异常对象里提取错误信息

        // getBindingResult() : 拿到参数绑定和校验结果
        String message = exception.getBindingResult()
                // 拿到字段错误列表 如：message -> message cannot be blank；（DTO中的record字段校验：@NotBlank(message = "message cannot be blank")
                //        @Size(max = 200, message = "message length must be <= 200")）
                .getFieldErrors()
                // 把错误列表变成流，方便处理。
                .stream()
                // 简单处理，只取第一个错误
                .findFirst()
                // 从字段错误里取出你在注解里写的 message：
                // @NotBlank(message = "message cannot be blank")
                .map(FieldError::getDefaultMessage)
                // 如果没有取到错误信息，就用默认文案。
                .orElse("invalid request");

        // 4. 返回统一 ApiResponse

        // 最后返回 code为400，message为 上述所校验提取的不满信息
        return ApiResponse.fail(400, message);
    }

    /**
     * 5. 最后用 Exception.class 做兜底
     * 兜底处理- 如果出现了其他没有专门处理的异常，比如空指针、数组越界、业务代码报错，就统一返回 500。
     * 没有兜底的话，Spring Boot 返回默认错误。
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ApiResponse<Void> handleException(Exception exception) {
        return ApiResponse.fail(500, "internal server error");
    }
}
