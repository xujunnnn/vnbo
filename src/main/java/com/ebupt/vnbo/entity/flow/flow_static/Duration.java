package com.ebupt.vnbo.entity.flow.flow_static;
/**
 * 
* ����: Duration.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.flow_static <br/>
* ��ϸ����: TODO(���ڱ�ʾ�����е�ʱ����Ϣ��ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Duration {
	private long nanosecond;
	private long second;
	public long getNanosecond() {
		return nanosecond;
	}
	public void setNanosecond(long nanosecond) {
		this.nanosecond = nanosecond;
	}
	public long getSecond() {
		return second;
	}
	public void setSecond(long second) {
		this.second = second;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (nanosecond ^ (nanosecond >>> 32));
		result = prime * result + (int) (second ^ (second >>> 32));
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
		Duration other = (Duration) obj;
		if (nanosecond != other.nanosecond)
			return false;
		if (second != other.second)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Duration [nanosecond=" + nanosecond + ", second=" + second + "]";
	}

}
