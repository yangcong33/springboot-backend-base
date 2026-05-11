package com.jacob.backend.controller;

import com.jacob.backend.common.response.ApiResponse;
import com.jacob.backend.domain.dto.EchoRequest;
import com.jacob.backend.domain.vo.EchoResponse;
import com.jacob.backend.service.DemoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    /**
     *
     * @return
     */
    @GetMapping("/ping")
    public ApiResponse<String> ping() {
        return ApiResponse.success(demoService.ping());
    }

    @PostMapping("/echo")
    public ApiResponse<EchoResponse> echo(@Valid @RequestBody EchoRequest request) {
        return ApiResponse.success(demoService.echo(request));
    }
}
