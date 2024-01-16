package com.qf.web.monitor.domain.sever;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author : sin
 * @date : 2024/1/16 23:39
 * @Description : 系统相关信息
 */
@Schema(description = "系统相关信息")
@Data
public class Sys {

    @Schema(description = "服务器名称")
    private String computerName;

    @Schema(description = "服务器Ip")
    private String computerIp;

    @Schema(description = "项目路径")
    private String userDir;

    @Schema(description = "操作系统名称")
    private String osName;

    @Schema(description = "系统架构")
    private String osArch;

    public String getComputerName()
    {
        return computerName;
    }

    public void setComputerName(String computerName)
    {
        this.computerName = computerName;
    }

    public String getComputerIp()
    {
        return computerIp;
    }

    public void setComputerIp(String computerIp)
    {
        this.computerIp = computerIp;
    }

    public String getUserDir()
    {
        return userDir;
    }

    public void setUserDir(String userDir)
    {
        this.userDir = userDir;
    }

    public String getOsName()
    {
        return osName;
    }

    public void setOsName(String osName)
    {
        this.osName = osName;
    }

    public String getOsArch()
    {
        return osArch;
    }

    public void setOsArch(String osArch)
    {
        this.osArch = osArch;
    }
}