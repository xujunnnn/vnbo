package com.ebupt.vnbo.entity.flow.action;

import java.util.Objects;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* ����: Set_Queue_Action.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.action <br/>
* ��ϸ����: TODO(���ڱ�ʾƥ�䵽���е�ʵ����) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Set_Queue_Action{
	@JSONField(name="queue-id")
	private String queue;
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public String getQueue_id() {
		return queue_id;
	}
	public void setQueue_id(String queue_id) {
		this.queue_id = queue_id;
	}
	private String queue_id;
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(queue,queue_id);
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
	    Set_Queue_Action other=(Set_Queue_Action) obj;
	    	return Objects.equals(this.queue_id, other.getQueue_id()) && Objects.equals(this.queue,other.getQueue());
	}
	
}