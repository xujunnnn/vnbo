package com.ebupt.vnbo.entity.flow.instruction;

import java.util.Objects;
/**
 * 
* ����: Go_To_Table.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.instruction <br/>
* ��ϸ����: TODO(���ڱ�ʾ�����еķ��͵���һ��tableʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Go_To_Table{
	private String table_id;

	public String getTable_id() {
		return table_id;
	}

	public Go_To_Table setTable_id(String table_id) {
		this.table_id = table_id;
		return this;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(table_id);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
			return true;
		if(obj==null)
			return false;
	    if(this.getClass()!=obj.getClass())
	    	return false;
	    Go_To_Table other=(Go_To_Table) obj;
	    	return Objects.equals(this.table_id, other.getTable_id());
	}
	
	
}