package com.scau.noteservice.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 笔记服务配置类
 *
 * @author showtime
 * @version V1.0
 * @date 2019-02-20 09:20
 */
@Component
@ConfigurationProperties(prefix = "spring.hsf")
public class NoteRpcConfig {
    private String version;

    private String timeout;

    private String serviceGroup;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }
}