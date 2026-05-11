package com.jacob.backend.common.response;

/**
 * 2026年5月11日14点00分
 * 统一响应结构实现  ApiResponse
 *
 * @param <T>
 */
public record ApiResponse<T>(int code, String message, T data) {

    /**
     * 成功返回格式
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(0, "success", data);
    }

    /**
     * 异常返回格式
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> fail(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}