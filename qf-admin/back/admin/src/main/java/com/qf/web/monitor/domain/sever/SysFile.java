package com.qf.web.monitor.domain.sever;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author : sin
 * @date : 2024/1/16 23:41
 * @Description : 系统文件相关信息
 */
@Schema(description = "系统文件相关信息")
public class SysFile {

    @Schema(description = "盘符路径")
    private String dirName;

    @Schema(description = "盘符类型")
    private String sysTypeName;

    @Schema(description = "文件类型")
    private String typeName;

    @Schema(description = "总大小")
    private String total;

    @Schema(description = "剩余大小")
    private String free;

    @Schema(description = "已使用量")
    private String used;

    @Schema(description = "资源的使用率")
    private double usage;

    public String getDirName()
    {
        return dirName;
    }

    public void setDirName(String dirName)
    {
        this.dirName = dirName;
    }

    public String getSysTypeName()
    {
        return sysTypeName;
    }

    public void setSysTypeName(String sysTypeName)
    {
        this.sysTypeName = sysTypeName;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getTotal()
    {
        return total;
    }

    public void setTotal(String total)
    {
        this.total = total;
    }

    public String getFree()
    {
        return free;
    }

    public void setFree(String free)
    {
        this.free = free;
    }

    public String getUsed()
    {
        return used;
    }

    public void setUsed(String used)
    {
        this.used = used;
    }

    public double getUsage()
    {
        return usage;
    }

    public void setUsage(double usage)
    {
        this.usage = usage;
    }
}
