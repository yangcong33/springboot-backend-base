package com.jacob.backend.service.impl;

import com.jacob.backend.domain.dto.EchoRequest;
import com.jacob.backend.domain.vo.EchoResponse;
import com.jacob.backend.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String ping() {
        return "ping";
    }

    @Override
    public EchoResponse echo(EchoRequest request) {
        String message = request.message();
        int x=1/0;
        return new EchoResponse(message, message.length());
    }
}
