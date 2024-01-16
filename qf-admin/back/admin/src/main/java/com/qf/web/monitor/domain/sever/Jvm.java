package com.qf.web.monitor.domain.sever;

import com.qf.web.monitor.domain.sever.util.Arith;
import com.qf.web.monitor.domain.sever.util.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.management.ManagementFactory;

/**
 * @author : sin
 * @date : 2024/1/16 23:33
 * @Description : JVM相关信息
 */
@Schema(description = "JVM相关信息")
public class Jvm {

    @Schema(description = "JVM占用的内存总数(M)")
    private double total;

    @Schema(description = "JVM最大可用内存总数(M)")
    private double max;

    @Schema(description = "JVM空闲内存(M)")
    private double free;

    @Schema(description = "JDK版本")
    private String version;

    @Schema(description = "JDK路径")
    private String home;

    public double getTotal() {
        return Arith.div(total, (1024 * 1024), 2);
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMax() {
        return Arith.div(max, (1024 * 1024), 2);
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getFree() {
        return Arith.div(free, (1024 * 1024), 2);
    }

    public void setFree(double free) {
        this.free = free;
    }

    public double getUsed() {
        return Arith.div(total - free, (1024 * 1024), 2);
    }

    public double getUsage() {
        return Arith.mul(Arith.div(total - free, total, 4), 100);
    }

    @Schema(description = "获取JDK名称")
    public String getName() {
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Schema(description = "JDK启动时间")
    public String getStartTime() {
        return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getServerStartDate());
    }

    @Schema(description = "JDK运行时间")
    public String getRunTime() {
        return DateUtils.timeDistance(DateUtils.getNowDate(), DateUtils.getServerStartDate());
    }

    @Schema(description = "运行参数")
    public String getInputArgs() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
    }
}
