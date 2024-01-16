package com.qf.web.monitor.domain.sever;

import com.qf.web.monitor.domain.sever.util.Arith;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author : sin
 * @date : 2024/1/16 22:13
 * @Description : CPU信息
 */
@Schema(description = "CPU信息")
public class Cpu {
    @Schema(description = "CPU核心数")
    private int cpuNum;

    @Schema(description = "CPU总的使用率")
    private double total;

    @Schema(description = "CPU系统使用率")
    private double sys;

    @Schema(description = "CPU用户使用率")
    private double used;

    @Schema(description = "CPU当前等待率")
    private double wait;

    @Schema(description = "CPU当前空闲率")
    private double free;

    public int getCpuNum()
    {
        return cpuNum;
    }

    public void setCpuNum(int cpuNum)
    {
        this.cpuNum = cpuNum;
    }

    public double getTotal()
    {
        return Arith.round(Arith.mul(total, 100), 2);
    }

    public void setTotal(double total)
    {
        this.total = total;
    }

    public double getSys()
    {
        return Arith.round(Arith.mul(sys / total, 100), 2);
    }

    public void setSys(double sys)
    {
        this.sys = sys;
    }

    public double getUsed()
    {
        return Arith.round(Arith.mul(used / total, 100), 2);
    }

    public void setUsed(double used)
    {
        this.used = used;
    }

    public double getWait()
    {
        return Arith.round(Arith.mul(wait / total, 100), 2);
    }

    public void setWait(double wait)
    {
        this.wait = wait;
    }

    public double getFree()
    {
        return Arith.round(Arith.mul(free / total, 100), 2);
    }

    public void setFree(double free)
    {
        this.free = free;
    }
}