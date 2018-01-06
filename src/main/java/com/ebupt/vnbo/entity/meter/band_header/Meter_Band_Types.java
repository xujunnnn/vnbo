package com.ebupt.vnbo.entity.meter.band_header;

/**
 * 
* ����: Meter_Band_Types.java <br/>
* ���� : com.ebupt.vnbo.classes.meter.band_header <br/>
* ��ϸ����: TODO(Meter_Band_Typesʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */

public class Meter_Band_Types{
	private String flags;

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flags == null) ? 0 : flags.hashCode());
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
		Meter_Band_Types other = (Meter_Band_Types) obj;
		if (flags == null) {
			if (other.flags != null)
				return false;
		} else if (!flags.equals(other.flags))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meter_Band_Types [flags=" + flags + "]";
	}
	
	
	
}
