package com.xuwei.oshi.websocket.service;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.HWDiskStore;
import oshi.software.os.OperatingSystem;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SystemInfoService {

    private final SystemInfo systemInfo;

    public SystemInfoService() {
        this.systemInfo = new SystemInfo();
    }

    public String getCpuInfo() {
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        CentralProcessor processor = hal.getProcessor();
        return "CPU Cores: " + processor.getPhysicalProcessorCount() + 
               ", CPU Load: " + Arrays.toString(processor.getSystemLoadAverage(3));
    }

    public String getMemoryInfo() {
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        GlobalMemory memory = hal.getMemory();
        return "Total Memory: " + memory.getTotal() + ", Available Memory: " + memory.getAvailable();
    }

    public String getDiskInfo() {
        HardwareAbstractionLayer hal = systemInfo.getHardware();
        StringBuilder diskInfo = new StringBuilder();
        for (HWDiskStore disk : hal.getDiskStores()) {
            diskInfo.append("Disk Name: ").append(disk.getModel()).append(", Disk Size: ").append(disk.getSize()).append("\n");
        }
        return diskInfo.toString();
    }

    public String getOperatingSystemInfo() {
        OperatingSystem os = systemInfo.getOperatingSystem();
        return "Operating System: " + os;
    }
}
