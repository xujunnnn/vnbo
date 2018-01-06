package com.ebupt.vnbo.entity.vtn;

/**
 * Created by xujun on 2017/11/15.
 */
public class Port {
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Port)) return false;

        Port port1 = (Port) o;

        return port != null ? port.equals(port1.port) : port1.port == null;
    }

    @Override
    public int hashCode() {
        return port != null ? port.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Port{" +
                "port='" + port + '\'' +
                '}';
    }
}
