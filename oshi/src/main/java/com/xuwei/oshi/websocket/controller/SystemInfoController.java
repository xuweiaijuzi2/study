package com.xuwei.oshi.websocket.controller;

import com.xuwei.oshi.websocket.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    @GetMapping("/cpu")
    public String getCpuInfo() {
        return systemInfoService.getCpuInfo();
    }

    @GetMapping("/memory")
    public String getMemoryInfo() {
        return systemInfoService.getMemoryInfo();
    }

    @GetMapping("/disk")
    public String getDiskInfo() {
        return systemInfoService.getDiskInfo();
    }

    @GetMapping("/os")
    public String getOperatingSystemInfo() {
        return systemInfoService.getOperatingSystemInfo();
    }
}
