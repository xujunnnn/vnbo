package com.ebupt.vnbo.entity.flow.match;


import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* ����: Tcp_Flag_Match.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.match <br/>
* ��ϸ����: TODO(Tcp_Flag_Match��ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Tcp_Flag_Match {
	@JSONField(name="tcp-flag")
	private String tcp_flag;
	public String getTcp_flag() {
		return tcp_flag;
	}
	public void setTcp_flag(String tcp_flag) {
		this.tcp_flag = tcp_flag;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tcp_flag == null) ? 0 : tcp_flag.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tcp_Flag_Match other = (Tcp_Flag_Match) obj;
		if (tcp_flag == null) {
			if (other.tcp_flag != null)
				return false;
		} else if (!tcp_flag.equals(other.tcp_flag))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tcp_Flag_Match [tcp_flag=" + tcp_flag + "]";
	}
	
}
