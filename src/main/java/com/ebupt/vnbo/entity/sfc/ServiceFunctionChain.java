package com.ebupt.vnbo.entity.sfc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import com.ebupt.vnbo.entity.abstracts.Config;
import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.flow_condition.Flow_Condition;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Ether_Match;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Flow_Match;
import com.ebupt.vnbo.entity.flow_condition.Vtn_Inet_Match;
import com.ebupt.vnbo.entity.flow_filter.Flow_Filter;
import com.ebupt.vnbo.entity.flow_filter.Redirect_Destination;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Flow_Filter;
import com.ebupt.vnbo.entity.flow_filter.Vtn_Redirect_Filter;
import com.ebupt.vnbo.entity.vtn.VbridgeRead;
import com.ebupt.vnbo.entity.vtn.VinterfaceRead;
import com.ebupt.vnbo.entity.vtn.Vinterface_input_filter;
import com.ebupt.vnbo.entity.vtn.Vterminal;
import com.ebupt.vnbo.entity.vtn.VterminalRead;
import com.ebupt.vnbo.entity.vtn.VtnRead;
import com.ebupt.vnbo.util.SFCUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ServiceFunctionChain implements Config{
	private String VtopoName;
	private String name;
	private List<String> vnfs;
	private List<SFCCondition> sfcConditions;
	private VInterface inPort;
	private VInterface outPort;
	@JsonIgnore
	private String index;
	
	
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getVtopoName() {
		return VtopoName;
	}
	public ServiceFunctionChain setVtopoName(String vtopoName) {
		VtopoName = vtopoName;
		return this;
	}
	public String getName() {
		return name;
	}
	public ServiceFunctionChain setName(String name) {
		this.name = name;
		return this;
	}
	public List<String> getVnfs() {
		return vnfs;
	}
	public ServiceFunctionChain setVnfs(List<String> vnfs) {
		this.vnfs = vnfs;
		return this;
	}
	public List<SFCCondition> getSfcConditions() {
		return sfcConditions;
	}
	public ServiceFunctionChain setSfcConditions(List<SFCCondition> sfcConditions) {
		this.sfcConditions = sfcConditions;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "ServiceFunctionChain [VtopoName=" + VtopoName + ", name=" + name + ", vnfs=" + vnfs + ", sfcConditions="
				+ sfcConditions + ", inPort=" + inPort + ", outPort=" + outPort + ", index=" + index + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((VtopoName == null) ? 0 : VtopoName.hashCode());
		result = prime * result + ((inPort == null) ? 0 : inPort.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((outPort == null) ? 0 : outPort.hashCode());
		result = prime * result + ((sfcConditions == null) ? 0 : sfcConditions.hashCode());
		result = prime * result + ((vnfs == null) ? 0 : vnfs.hashCode());
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
		ServiceFunctionChain other = (ServiceFunctionChain) obj;
		if (VtopoName == null) {
			if (other.VtopoName != null)
				return false;
		} else if (!VtopoName.equals(other.VtopoName))
			return false;
		if (inPort == null) {
			if (other.inPort != null)
				return false;
		} else if (!inPort.equals(other.inPort))
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
		if (outPort == null) {
			if (other.outPort != null)
				return false;
		} else if (!outPort.equals(other.outPort))
			return false;
		if (sfcConditions == null) {
			if (other.sfcConditions != null)
				return false;
		} else if (!sfcConditions.equals(other.sfcConditions))
			return false;
		if (vnfs == null) {
			if (other.vnfs != null)
				return false;
		} else if (!vnfs.equals(other.vnfs))
			return false;
		return true;
	}
	public VInterface getInPort() {
		return inPort;
	}
	public void setInPort(VInterface inPort) {
		this.inPort = inPort;
	}
	public VInterface getOutPort() {
		return outPort;
	}
	public void setOutPort(VInterface outPort) {
		this.outPort = outPort;
	}
	@Override
	public void send(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Flow_Condition flow_Condition=new Flow_Condition();	
		if(sfcConditions==null || sfcConditions.size()==0){
			
		}
		else {
			List<Vtn_Flow_Match> vtn_Flow_Matchs=new ArrayList<>();
			int count=1;
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
			//设置flow_condition
			flow_Condition.setVtn_flow_match(vtn_Flow_Matchs);
			flow_Condition.setName(name+"_cond");
			flow_Condition.setOperation(OperationType.SET);
			flow_Condition.setPresent("false");
			flow_Condition.send(null);		
			
			String index=SFCUtil.nextIndex(this.name);
			setIndex(index);
			for(int i=0;i<vnfs.size();i++){
				if(i==0){
					VNFRead vnfRead=new VNFRead().setVtopoName(VtopoName).setName(vnfs.get(i));
					vnfRead=vnfRead.read(null);
					if(vnfRead==null){
						throw new ODL_IO_Exception("no vnf ");
					}
					Flow_Filter filter=new Flow_Filter();
					Vtn_Flow_Filter flow_Filter=new Vtn_Flow_Filter();
					Vtn_Redirect_Filter redirect_Filter=new Vtn_Redirect_Filter();
					Redirect_Destination destination=new Redirect_Destination();
					filter.setBridge_name(inPort.getVbridgeName());
					filter.setTenant_name(inPort.getVtopoName());
					filter.setInterface_name(inPort.getvInterface());
					flow_Filter.setIndex(index);
					destination.setTenant_name(VtopoName);
					destination.setTerminal_name(vnfRead.getPortAMap().getVterminalName());
					destination.setInterface_name(vnfRead.getPortAMap().getVinterface());
					redirect_Filter.setOutput(true).setRedirect_destination(destination);
					flow_Filter.setCondition(flow_Condition.getName());
					
					flow_Filter.setVtn_redirect_filter(redirect_Filter);
					List<Vtn_Flow_Filter> filters=new ArrayList<>();
					filters.add(flow_Filter);
					
					filter.setVtn_flow_filter(filters);
					filter.setOutput(false);
					filter.send(null);
				}
				
				if(i==vnfs.size()-1){
					VNFRead vnfRead=new VNFRead().setVtopoName(VtopoName).setName(vnfs.get(i));
					vnfRead=vnfRead.read(null);
					Flow_Filter filter=new Flow_Filter();
					Vtn_Flow_Filter flow_Filter=new Vtn_Flow_Filter();	
					Vtn_Redirect_Filter redirect_Filter=new Vtn_Redirect_Filter();
					Redirect_Destination destination=new Redirect_Destination();
					filter.setTerminal_name(vnfRead.getPortBMap().getVterminalName());
					filter.setTenant_name(vnfRead.getVtopoName());
					filter.setInterface_name(vnfRead.getPortBMap().getVinterface());
					flow_Filter.setIndex(index);
					destination.setBridge_name(outPort.getVbridgeName());
					destination.setTenant_name(VtopoName);
					destination.setInterface_name(outPort.getvInterface());
					redirect_Filter.setOutput(true).setRedirect_destination(destination);
					flow_Filter.setCondition(flow_Condition.getName());
					flow_Filter.setVtn_redirect_filter(redirect_Filter);
				
					
					List<Vtn_Flow_Filter> filters=new ArrayList<>();
					filters.add(flow_Filter);
					filter.setVtn_flow_filter(filters);
					
					filter.setOutput(false);
					filter.send(null);
					
				}
				if(i!=0){
					VNFRead toVnf=new VNFRead().setVtopoName(VtopoName).setName(vnfs.get(i));
					VNFRead fromVnf=new VNFRead().setVtopoName(VtopoName).setName(vnfs.get(i-1));
					
					Flow_Filter filter=new Flow_Filter();
					Vtn_Flow_Filter flow_Filter=new Vtn_Flow_Filter();	
					Vtn_Redirect_Filter redirect_Filter=new Vtn_Redirect_Filter();
					Redirect_Destination destination=new Redirect_Destination();
					filter.setTenant_name(VtopoName);
					filter.setTerminal_name(fromVnf.getPortBMap().getVterminalName());
					filter.setInterface_name(fromVnf.getPortBMap().getVinterface());
					flow_Filter.setIndex(index);
					destination.setTerminal_name(toVnf.getPortAMap().getVterminalName());
					destination.setInterface_name(toVnf.getPortAMap().getVinterface());
					redirect_Filter.setRedirect_destination(destination);
					redirect_Filter.setOutput(false);
					flow_Filter.setCondition(flow_Condition.getName());
					flow_Filter.setVtn_redirect_filter(redirect_Filter);
				
					List<Vtn_Flow_Filter> filters=new ArrayList<>();				
					filters.add(flow_Filter);
					
					filter.setOutput(false);
					filter.setVtn_flow_filter(filters);
					filter.send(null);					
				}
		
				
			}
		}		
	}
	@Override
	public void remove(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
/*
 * 		//删除创建的flow_filter
		VtnRead vtnRead=new VtnRead();
		vtnRead.setTenant_name(VtopoName);
		vtnRead=vtnRead.read(null);
		for(VbridgeRead vbr:vtnRead.getVbridgeReads()){
			if(vbr.getVinterface()!=null){
				for(VinterfaceRead vir:vbr.getVinterface()){
					if(vir.getName().equals(inPort.getvInterface()) || vir.getName().equals(outPort.getvInterface())){
						if(vir.getVinterface_input_filter()!=null){
							Flow_Filter flow_Filter=new Flow_Filter();
							flow_Filter.setBridge_name(vbr.getBridge_name());
							flow_Filter.setTenant_name(VtopoName);
							flow_Filter.setInterface_name(vir.getName());
							List<String> indexs=new ArrayList<>();
							if(vir.getVinterface_input_filter().getVtn_Flow_Filter()!=null){
								for(Vtn_Flow_Filter vff:vir.getVinterface_input_filter().getVtn_Flow_Filter()){
									if((name+"_cond").equals(vff.getCondition())){			
										indexs.add(vff.getIndex());
									
									}
								}
								flow_Filter.setIndices(indexs);
								flow_Filter.remove(null);
							}
							
						}
					}
				}
			}
		}
	if(vtnRead.getVterminalReads()!=null)
		for(VterminalRead vtr:vtnRead.getVterminalReads()){
			String vnfname=toVnfName(vtr.getName());
			if(vnfs.contains(vnfname))
				if(vtr.getVinterfaces()!=null){
					for(VinterfaceRead vir:vtr.getVinterfaces()){
						if(vir.getVinterface_input_filter()!=null){
							Flow_Filter filter=new Flow_Filter();
							filter.setTenant_name(VtopoName);
							filter.setTerminal_name(vtr.getName());
							filter.setInterface_name(vir.getName());
							List<String> indexs=new ArrayList<>();
							if(vir.getVinterface_input_filter().getVtn_Flow_Filter()!=null){
								for(Vtn_Flow_Filter vff:vir.getVinterface_input_filter().getVtn_Flow_Filter()){
									if((name+"_cond").equals(vff.getCondition())){
										indexs.add(vff.getIndex());
									}
							
								}
							filter.setIndices(indexs);
							filter.remove(null);
						}
					}
					
				}
			}
		}
 */
	Flow_Filter flow_Filter=new Flow_Filter();
	List<String> indexs=new ArrayList<>();
	indexs.add(this.index);
	flow_Filter.setTenant_name(name);
	flow_Filter.setBridge_name(inPort.getVbridgeName());
	flow_Filter.setInterface_name(inPort.getvInterface());
	flow_Filter.setIndices(indexs);
	flow_Filter.setOutput(false);
	flow_Filter.remove(null);
	flow_Filter.setTenant_name(name);
	flow_Filter.setBridge_name(outPort.getVbridgeName());
	flow_Filter.setInterface_name(outPort.getvInterface());
	flow_Filter.setIndices(indexs);
	flow_Filter.setOutput(true);
	flow_Filter.remove(null);
	for(int i=0;i<vnfs.size()-1;i++){
		VNFRead vnfRead=new VNFRead();
		vnfRead.setName(vnfs.get(i));
		vnfRead=vnfRead.read(null);
		Flow_Filter filter=new Flow_Filter();
		filter.setTenant_name(name);
		filter.setTerminal_name(vnfRead.getPortBMap().getVterminalName());
		filter.setOutput(true);
		filter.setInterface_name(vnfRead.getPortBMap().getVinterface());
		filter.remove(null);
		
	}
	}
	
	private String toVnfName(String name){
		for(int i=name.length()-1;i>=0;i--){
			if(name.charAt(i)=='_'){
				return name.substring(0,i);
			}
		}
		return null;
		
	}
	
	

}
