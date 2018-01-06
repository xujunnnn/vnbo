package com.ebupt.vnbo.entity.enums;
/**
 * 
* ����: Protocol_Type.java <br/>
* ���� : com.ebupt.vnbo.classes.enums <br/>
* ��ϸ����: TODO(���ڱ�ʾ����Э���ö����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public enum Protocol_Type {
    TCP(6),ICMP(1),UDP(17),UNKNOW(0);
	private int value=-1;
    private Protocol_Type(int value) {
    	this.value=value;
    }
    public int value(){
    	return this.value;
    }
    public static Protocol_Type Valueof(int value){
    	switch (value) {
		case 1:
			return ICMP;
		case 6:
			return TCP;
		case 17:
			return UDP;
		default:
			return UNKNOW;
			
		}
    }
    
}
