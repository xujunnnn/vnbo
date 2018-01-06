package com.ebupt.vnbo.configure;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by xujun on 2017/10/17.
 */
@Configuration
@ConfigurationProperties(prefix = "vnbo")
@PropertySource(value = "classpath:config/ODL.properties",ignoreResourceNotFound = false)
@Component
public class MyConfig {
    private String ODL;
    private String InfluxDB;
    private String username;
    private String password;


    public String getODL() {
        return ODL;
    }

    public void setODL(String ODL) {
        this.ODL = ODL;
    }

    public String getInfluxDB() {
        return InfluxDB;
    }

    public void setInfluxDB(String influxDB) {
        InfluxDB = influxDB;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyConfig{" +
                "ODL='" + ODL + '\'' +
                ", InfluxDB='" + InfluxDB + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
