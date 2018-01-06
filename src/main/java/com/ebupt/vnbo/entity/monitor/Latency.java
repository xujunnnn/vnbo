package com.ebupt.vnbo.entity.monitor;
/**
 * 
* ����: Latency.java <br/>
* ���� : com.ebupt.vnbo.classes.monitor <br/>
* ��ϸ����: TODO(Latencyʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Latency {
	private String srcnode;
	private String destnode;
	private long latency;
	
	public String getSrcnode() {
		return srcnode;
	}
	public void setSrcnode(String srcnode) {
		this.srcnode = srcnode;
	}
	public String getDestnode() {
		return destnode;
	}
	public void setDestnode(String destnode) {
		this.destnode = destnode;
	}
	public long getLatency() {
		return latency;
	}
	public void setLatency(long latency) {
		this.latency = latency;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destnode == null) ? 0 : destnode.hashCode());
		result = prime * result + (int) (latency ^ (latency >>> 32));
		result = prime * result + ((srcnode == null) ? 0 : srcnode.hashCode());
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
		Latency other = (Latency) obj;
		if (destnode == null) {
			if (other.destnode != null)
				return false;
		} else if (!destnode.equals(other.destnode))
			return false;
		if (latency != other.latency)
			return false;
		if (srcnode == null) {
			if (other.srcnode != null)
				return false;
		} else if (!srcnode.equals(other.srcnode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Latency [srcnode=" + srcnode + ", destnode=" + destnode + ", latency=" + latency + "]";
	}
	
	


}
