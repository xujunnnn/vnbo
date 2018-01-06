package com.ebupt.vnbo.entity.exception;
/**
 * 
* ����: OperationalException.java <br/>
* ���� : com.ebupt.vnbo.classes.exception <br/>
* ��ϸ����: TODO(���ڱ�ʾ��ȡ������Ϣʧ�ܵ��쳣�� ) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class OperationalException extends ODL_IO_Exception{
	private static final long serialVersionUID = 1L;

	public OperationalException(){}
	public OperationalException(String info){
		super(info);
	}

}
