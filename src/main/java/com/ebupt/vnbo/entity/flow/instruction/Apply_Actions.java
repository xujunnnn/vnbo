package com.ebupt.vnbo.entity.flow.instruction;

import java.util.ArrayList;
import java.util.Objects;

import com.alibaba.fastjson.annotation.JSONField;
import com.ebupt.vnbo.entity.flow.action.Action;

/**
 * 
* ����: Apply_Actions.java <br/>
* ���� : com.ebupt.vnbo.classes.flow.instruction <br/>
* ��ϸ����: TODO(���ڱ�ʾ�����е�Apply_Actions) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public class Apply_Actions{
	@JSONField(name="action")
	private ArrayList<Action> actions=new ArrayList<Action>();
	public ArrayList<Action> getActions() {
		return actions;
	}
    public Apply_Actions(){}
	public void setAction(ArrayList<Action> action) {
		this.actions = action;
	}
	public Apply_Actions addAction(Action action){
		this.actions.add(action);
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actions == null) ? 0 : actions.hashCode());
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
		Apply_Actions other = (Apply_Actions) obj;
		if (actions == null) {
			if (other.actions != null)
				return false;
		} else if (!actions.equals(other.actions))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Apply_Actions [actions=" + actions + "]";
	}

	


	
}