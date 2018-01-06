package com.ebupt.vnbo.entity.flow.match;
/**
 * 
* ����: Ethernet_type.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.match <br/>
* ��ϸ����: TODO(Ethernet_type��ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Ethernet_type {
	
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Ethernet_type other = (Ethernet_type) obj;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Ethernet_type [type=" + type + "]";
		}

	
	
}
