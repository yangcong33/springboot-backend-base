package com.jacob.backend.service;

import com.jacob.backend.domain.dto.EchoRequest;
import com.jacob.backend.domain.vo.EchoResponse;


public interface DemoService {
    public String ping();

    EchoResponse echo(EchoRequest request);
}
