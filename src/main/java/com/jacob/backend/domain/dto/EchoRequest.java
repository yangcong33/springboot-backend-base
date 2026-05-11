package com.jacob.backend.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EchoRequest(
        @NotBlank(message = "message cannot be blank")
        @Size(max = 200, message = "message length must be <= 200")
        String message
) {
}
