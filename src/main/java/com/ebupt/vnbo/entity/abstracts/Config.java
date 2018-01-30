package com.ebupt.vnbo.entity.abstracts;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.exception.ConfigException;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.HttpUtil;
/**
 * 
* ����: Config.java <br/>
* ���� : com.ebupt.vnbo.classes.abstracts <br/>
* ��ϸ����: TODO(������Ϣ�ӿ�) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��8�� <br/>
* �����汾�� V1.0  <br/>
 */
public interface  Config {
	public String CUSTOMIZETABLE="1";
	public String QOSFLOWTABLE="0";
	public String VTNFLOWTABLE="5";
	public String MONFLOWTABLE="3";
	public String LOWPRIORITY="200";
	public String MIDPRIORITY="210";
	public String HIGHPRIORITY="220";
	public String IDLE_TIME_OUT="0";
	public String HARD_TIME_OUT="0";
	public String VTN_FLOW_IDLE="3600";
	public String VTN_FLOW_HARD="0";
	
	
	default JSONObject toJson(){
		return null;
	}
	
	default JSONObject toDelJson(){
		return null;
		
	}
	@JSONField(deserialize=true)
	default String toUrl(){
		return null;
	}
	@JSONField(deserialize=true)
	default String toDelUrl(){
		return null;
	}
	
	
	
	/**
	 * 
	* ��������send</br>
	* ������TODO������һ��������Ϣ��</br>
	* ������Ա��xujun</br>
	* ����ʱ�䣺2017��6��8��  </br>
	* @param node
	* @throws ODL_IO_Exception
	* @throws
	 */
	default void send(String node) throws ODL_IO_Exception{

		String responsecode=HttpUtil.Post_request(toUrl(),toJson())[0];
		    if(!"201".equals(responsecode) && !"200".equals(responsecode) && !"409".equals(responsecode))
		    	throw new ConfigException("created failed");
		
	}
	/**
	 * 
	* ��������remove</br>
	* ������TODO��ɾ��һ��������Ϣ��</br>
	* ������Ա��xujun</br>
	* ����ʱ�䣺2017��6��8��  </br>
	* @param node
	* @throws ODL_IO_Exception
	* @throws
	 */
	default void remove(String node) throws ODL_IO_Exception{
		String url=toDelUrl();
		String[] response=HttpUtil.Post_request(url,toDelJson());
		String responsecode=response[0];
		String responsebody=response[1];
		if(!"200".equals(responsecode) && !"201".equals(responsecode) && !"404".equals(responsecode))
				throw new ConfigException("faied to delete");
		
	}
}
