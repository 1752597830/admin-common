package com.qf.web.monitor.domain.sever;

import com.qf.web.monitor.domain.sever.util.Arith;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.ToString;

/**
 * @author : sin
 * @date : 2024/1/16 23:36
 * @Description : 內存相关信息
 */
@ToString
public class Mem {

    @Schema(description = "内存总量")
    private double total;

    @Schema(description = "已用内存")
    private double used;

    @Schema(description = "剩余内存")
    private double free;

    public double getTotal() {
        return Arith.div(total, (1024 * 1024 * 1024), 2);
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public double getUsed() {
        return Arith.div(used, (1024 * 1024 * 1024), 2);
    }

    public void setUsed(long used) {
        this.used = used;
    }

    public double getFree() {
        return Arith.div(free, (1024 * 1024 * 1024), 2);
    }

    public void setFree(long free) {
        this.free = free;
    }

    public double getUsage() {
        return Arith.mul(Arith.div(used, total, 4), 100);
    }
}
