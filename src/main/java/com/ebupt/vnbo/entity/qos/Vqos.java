package com.ebupt.vnbo.entity.qos;

import java.util.ArrayList;
import java.util.List;

import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.abstracts.Operational;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.flow_condition.Flow_Condition;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Ether_Match;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Flow_Match;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Inet_Match;
import com.ebupt.vnbo.entity.flow_filter.Flow_Filter;
import com.ebupt.vnbo.entity.flow_filter.Vacant;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Flow_Action;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Flow_Filter;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Set_Queue_Action;
import com.ebupt.vnbo.entity.sfc.SFCCondition;
import com.ebupt.vnbo.util.SFCUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Vqos implements Config,Operational{
	private String name;
	private List<SFCCondition> sfcConditions;
	private String queueid;
	private String Vtopo;
	private String vBridge;
	private String Vinterface;
	@JsonIgnore
	private String index;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SFCCondition> getSfcConditions() {
		return sfcConditions;
	}
	public void setSfcConditions(List<SFCCondition> sfcConditions) {
		this.sfcConditions = sfcConditions;
	}
	public String getQueueid() {
		return queueid;
	}
	public void setQueueid(String queueid) {
		this.queueid = queueid;
	}
	public String getVtopo() {
		return Vtopo;
	}
	public void setVtopo(String vtopo) {
		Vtopo = vtopo;
	}
	public String getvBridge() {
		return vBridge;
	}
	public void setvBridge(String vBridge) {
		this.vBridge = vBridge;
	}
	public String getVinterface() {
		return Vinterface;
	}
	public void setVinterface(String vinterface) {
		Vinterface = vinterface;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "Vqos [name=" + name + ", sfcConditions=" + sfcConditions + ", queueid=" + queueid + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Vinterface == null) ? 0 : Vinterface.hashCode());
		result = prime * result + ((Vtopo == null) ? 0 : Vtopo.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((queueid == null) ? 0 : queueid.hashCode());
		result = prime * result + ((sfcConditions == null) ? 0 : sfcConditions.hashCode());
		result = prime * result + ((vBridge == null) ? 0 : vBridge.hashCode());
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
		Vqos other = (Vqos) obj;
		if (Vinterface == null) {
			if (other.Vinterface != null)
				return false;
		} else if (!Vinterface.equals(other.Vinterface))
			return false;
		if (Vtopo == null) {
			if (other.Vtopo != null)
				return false;
		} else if (!Vtopo.equals(other.Vtopo))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (queueid == null) {
			if (other.queueid != null)
				return false;
		} else if (!queueid.equals(other.queueid))
			return false;
		if (sfcConditions == null) {
			if (other.sfcConditions != null)
				return false;
		} else if (!sfcConditions.equals(other.sfcConditions))
			return false;
		if (vBridge == null) {
			if (other.vBridge != null)
				return false;
		} else if (!vBridge.equals(other.vBridge))
			return false;
		return true;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Flow_Condition flow_Condition=new Flow_Condition();
		List<Vtn_Flow_Match> vtn_Flow_Matchs=new ArrayList<>();
		int count=1;
		//根据SFCCondition 构造Flow_Condition
		if(sfcConditions!=null && sfcConditions.size()!=0){
			for(SFCCondition sfcCondition:sfcConditions){
				//设置二层匹配条件
				Vtn_Flow_Match match=new Vtn_Flow_Match();
				Vtn_Ether_Match vtn_Ether_Match;
				if(sfcCondition.getSrcMac()!=null || sfcCondition.getDestMac()!=null){
					vtn_Ether_Match=new Vtn_Ether_Match();
					if(sfcCondition.getSrcMac()!=null){
						vtn_Ether_Match.setSource_address(sfcCondition.getSrcMac());
					}
					if(sfcCondition.getDestMac()!=null){
						vtn_Ether_Match.setDestination_address(sfcCondition.getDestMac());
					}
					vtn_Ether_Match.setEther_type(sfcCondition.getEtherType().value());	
					match.setVtn_ether_match(vtn_Ether_Match);
				}
				//设置三层匹配条件
				Vtn_Inet_Match vtn_Inet_Match;
				if(sfcCondition.getSrcIp()!=null || sfcCondition.getDestIp()!=null){
					vtn_Inet_Match=new Vtn_Inet_Match();
					if(sfcCondition.getSrcIp()!=null){
						vtn_Inet_Match.setSource_network(sfcCondition.getSrcIp());
					}
					if(sfcCondition.getDestIp()!=null){
						vtn_Inet_Match.setDestination_network(sfcCondition.getDestIp());
					}
					if(sfcCondition.getProtocol()!=null){
						vtn_Inet_Match.setProtocol(String.valueOf(sfcCondition.getProtocol().value()));
					}
					match.setVtn_inet_match(vtn_Inet_Match);
				}
				//设置四层匹配条件
				if(sfcCondition.getUdp_source_range()!=null){
					match.setUdp_source_range(sfcCondition.getUdp_source_range());
				}
				if(sfcCondition.getUdp_destination_range()!=null){
					match.setUdp_destination_range(sfcCondition.getUdp_destination_range());
				}
				if(sfcCondition.getTcp_source_range()!=null){
					match.setTcp_source_range(sfcCondition.getTcp_source_range());
				}
				if(sfcCondition.getTcp_destination_range()!=null){
					match.setTcp_destination_range(sfcCondition.getTcp_destination_range());
				}
				vtn_Flow_Matchs.add(match);
				match.setIndex(String.valueOf(count));
				count++;
				
			}
		}
		flow_Condition.setVtn_flow_match(vtn_Flow_Matchs);
		flow_Condition.setName(name+"_cond");
		flow_Condition.setOperation(OperationType.SET);
		flow_Condition.setPresent("false");
		flow_Condition.send(null);
		//构造Flow_Filter
		Flow_Filter flow_Filter=new Flow_Filter();
		String index=SFCUtil.nextIndex(name);
		setIndex(index);
		flow_Filter.setTenant_name(Vtopo);
		flow_Filter.setBridge_name(vBridge);
		flow_Filter.setInterface_name(Vinterface);
		flow_Filter.setOutput(true);
		Vtn_Flow_Filter vtn_Flow_Filter=new Vtn_Flow_Filter();
		//生成index
		vtn_Flow_Filter.setIndex(index);
		//指定某条队列
		Vtn_Set_Queue_Action set_Queue_Action=new Vtn_Set_Queue_Action();
		set_Queue_Action.setQueue_id(queueid);
		
		Vtn_Flow_Action action=new Vtn_Flow_Action();
		action.setVtn_set_queue_action(set_Queue_Action);
		action.setOrder("0");		
		List<Vtn_Flow_Action> actions=new ArrayList<>();
		actions.add(action);
		vtn_Flow_Filter.setVtn_flow_action(actions);
		vtn_Flow_Filter.setVtn_pass_filter(new Vacant());
		vtn_Flow_Filter.setCondition(name+"_cond");
		List<Vtn_Flow_Filter> filters=new ArrayList<>();
		filters.add(vtn_Flow_Filter);
		flow_Filter.setVtn_flow_filter(filters);
		flow_Filter.send(null);
	
		
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Flow_Filter filter=new Flow_Filter();
		filter.setTenant_name(Vtopo);
		filter.setBridge_name(vBridge);
		filter.setInterface_name(Vinterface);
		filter.setOutput(true);
		List<String> indexs=new ArrayList<>();
		indexs.add(index);
		filter.setIndices(indexs);
		filter.remove(null);
		
		
	}
	@Override
	public Vqos read(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
