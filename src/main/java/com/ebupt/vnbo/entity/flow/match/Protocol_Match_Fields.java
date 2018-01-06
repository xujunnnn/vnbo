package com.ebupt.vnbo.entity.flow.match;
import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* ����: Protocol_Match_Fields.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.match <br/>
* ��ϸ����: TODO( Protocol_Match_Fields��ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Protocol_Match_Fields {
	@JSONField(name="mpls-label")
	private String mpls_label;
	@JSONField(name="mpls-tc")
	private String mpls_tc;
	@JSONField(name="mpls-bos")
	private String mpls_bos;
	public String getMpls_label() {
		return mpls_label;
	}
	public void setMpls_label(String mpls_label) {
		this.mpls_label = mpls_label;
	}
	public String getMpls_tc() {
		return mpls_tc;
	}
	public void setMpls_tc(String mpls_tc) {
		this.mpls_tc = mpls_tc;
	}
	public String getMpls_bos() {
		return mpls_bos;
	}
	public void setMpls_bos(String mpls_bos) {
		this.mpls_bos = mpls_bos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mpls_bos == null) ? 0 : mpls_bos.hashCode());
		result = prime * result + ((mpls_label == null) ? 0 : mpls_label.hashCode());
		result = prime * result + ((mpls_tc == null) ? 0 : mpls_tc.hashCode());
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
		Protocol_Match_Fields other = (Protocol_Match_Fields) obj;
		if (mpls_bos == null) {
			if (other.mpls_bos != null)
				return false;
		} else if (!mpls_bos.equals(other.mpls_bos))
			return false;
		if (mpls_label == null) {
			if (other.mpls_label != null)
				return false;
		} else if (!mpls_label.equals(other.mpls_label))
			return false;
		if (mpls_tc == null) {
			if (other.mpls_tc != null)
				return false;
		} else if (!mpls_tc.equals(other.mpls_tc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Protocol_Match_Fields [mpls_label=" + mpls_label + ", mpls_tc=" + mpls_tc + ", mpls_bos=" + mpls_bos
				+ "]";
	}


}
