package com.ebupt.vnbo.entity.exception;
/**
 * 
* ����: ConfigException.java <br/>
* ���� : com.ebupt.vnbo.classes.exception <br/>
* ��ϸ����: TODO(���ڱ�ʾ������Ϣ����ʧ�ܵ��쳣��) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class ConfigException extends ODL_IO_Exception{
	private static final long serialVersionUID = 1L;
	public ConfigException(){};
	public ConfigException(String info){
		super(info);
	}

}
