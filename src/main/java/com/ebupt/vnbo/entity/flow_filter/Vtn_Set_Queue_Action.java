package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-set-queue-action": {
    "queue": "1",
    "queue-id": "2"
},
 */
public class Vtn_Set_Queue_Action {
	private String queue;
	@JSONField(name="queue-id")
	private String queue_id;
	
	public String getQueue_id() {return this.queue_id;}
	public void setQueue_id(String queue_id) {this.queue_id=queue_id;}
	public String getQueue() {return this.queue;}
	public void setQueue(String queue) {this.queue=queue;}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((queue == null) ? 0 : queue.hashCode());
		result = prime * result + ((queue_id == null) ? 0 : queue_id.hashCode());
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
		Vtn_Set_Queue_Action other = (Vtn_Set_Queue_Action) obj;
		if (queue == null) {
			if (other.queue != null)
				return false;
		} else if (!queue.equals(other.queue))
			return false;
		if (queue_id == null) {
			if (other.queue_id != null)
				return false;
		} else if (!queue_id.equals(other.queue_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Set_Queue_Action [queue=" + queue + ", queue_id=" + queue_id + "]";
	}
	
	
}
