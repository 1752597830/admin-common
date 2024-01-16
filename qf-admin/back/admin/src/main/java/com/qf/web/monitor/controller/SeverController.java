package com.qf.web.monitor.controller;

import com.qf.common.util.BaseResponse;
import com.qf.web.monitor.domain.sever.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sin
 * @date : 2024/1/16 22:18
 * @Description : 系统监控
 */
@Tag(name = "06.系统监控接口")
@RestController
@RequestMapping("/monitor")
@Slf4j
public class SeverController {

    @GetMapping("/sever")
    public BaseResponse cpu() throws Exception {
        Server server = new Server();
        server.copyTo();
        return BaseResponse.success(server);
    }
}