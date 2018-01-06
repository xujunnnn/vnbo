package com.ebupt.vnbo.entity.vtn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
import com.ebupt.vnbo.util.HttpUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xujun on 2017/11/15.
 */
public class Static_edge_ports implements Config{
    @JSONField(name="static-edge-port")
    private Set<Port> static_edge_port=new HashSet<>();
    
    private static final String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	private static final String VtnConfigUrl=BaseUtil.getODL_IP()+"/restconf/operations";

    public Set<Port> getStatic_edge_port() {
        return static_edge_port;
    }

    public void setStatic_edge_port(Set<Port> static_edge_port) {
        this.static_edge_port = static_edge_port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Static_edge_ports)) return false;

        Static_edge_ports that = (Static_edge_ports) o;

        return getStatic_edge_port() != null ? getStatic_edge_port().equals(that.getStatic_edge_port()) : that.getStatic_edge_port() == null;
    }

    @Override
    public int hashCode() {
        return getStatic_edge_port() != null ? getStatic_edge_port().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Static_edge_ports{" +
                "static_edge_port=" + static_edge_port +
                '}';
    }

    public JSONObject toJson(){
        JSONObject object=new JSONObject();
        object.put("static-edge-ports", JSON.toJSON(this));
        return  object;
    }
    
    public Static_edge_ports addPorts(Port port) {
		// TODO Auto-generated constructor stub
    	this.static_edge_port.add(port);
    	return this;
	}

    /**
     * ��������send</br>
     * ������TODO������һ��������Ϣ��</br>
     * ������Ա��xujun</br>
     * ����ʱ�䣺2017��6��8��  </br>
     *
     * @param node
     * @throws ODL_IO_Exception
     * @throws
     */
    @Override
    public void send(String node) throws ODL_IO_Exception {
        String url="http://"+ConfigUrl+"/vtn-static-topology:vtn-static-topology/static-edge-ports";
        JSONObject object=toJson();
        String []result=HttpUtil.Put_request(url,object);
        String respcode=result[0];
        String respcontent=result[1];
        if("200".equals(respcode) && "201".equals(respcode)){
            throw new ODL_IO_Exception();
        }


    }

    /**
     * ��������remove</br>
     * ������TODO��ɾ��һ��������Ϣ��</br>
     * ������Ա��xujun</br>
     * ����ʱ�䣺2017��6��8��  </br>
     *
     * @param node
     * @throws ODL_IO_Exception
     * @throws
     */
    @Override
    public void remove(String node) throws ODL_IO_Exception {

    }
}
