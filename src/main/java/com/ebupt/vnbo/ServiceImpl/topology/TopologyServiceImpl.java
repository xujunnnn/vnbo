package com.ebupt.vnbo.ServiceImpl.topology;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.node_static.Node_connector;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.topology.Host;
import com.ebupt.vnbo.entity.topology.Link;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.entity.topology.Termination_point;
import com.ebupt.vnbo.entity.topology.Topology;
import com.ebupt.vnbo.entity.topology.VLink;
import com.ebupt.vnbo.entity.topology.VNode;
import com.ebupt.vnbo.entity.topology.Vtopology;
import com.ebupt.vnbo.entity.vtopo.VGroup;
import com.ebupt.vnbo.entity.vtopo.VHost;
import com.ebupt.vnbo.entity.vtopo.VPort;
import com.ebupt.vnbo.entity.vtopo.VTopo;
import com.ebupt.vnbo.service.topology.TopologyService;

/**
 * Created by xujun on 2017/10/17.
 */
@Service
public class TopologyServiceImpl implements TopologyService {
	private static final String FLOWID="flow:1";
    @Autowired
    private Topology topology;
    public TopologyServiceImpl(){

    }
    
    
    
    
    /**
     * 查询主机信息
     *
     * @return
     */
    @Override
    public Result<Set<Host>> querryHost() throws ODL_IO_Exception {
        Result<Set<Host>> result=new Result<>();
        HashSet<Host> hosts=get_hosts();
        result.setStatus(RespCode.success);
        result.setDescription("querry success");
        result.setResult(hosts);
        return  result;
    }
    
    /**
     * 
     */
    @Override
    public Result<Set<String>> querryBusyPorts(String Vgroup,String node) throws ODL_IO_Exception{
    	Result<Set<String>> result=new Result<>();
    	Set<String> ports=getBusyPortsOfVGroup(Vgroup, node);
    	result.setResult(ports);
    	result.setDescription("success to querry busy ports");
    	result.setStatus(RespCode.success);
    	return result;
    	
    }

    /**
     * 查询交换机信息
     *
     * @return
     */
    @Override
    public Result<Set<Node>> querrySwitch() throws ODL_IO_Exception{
        Result<Set<Node>> result=new Result<>();
        HashSet<Node> nodes=get_switch();
        result.setStatus(RespCode.success);
        result.setDescription("querry success");
        result.setResult(nodes);
        return result;
    }

    /**
     * 查询可用主机信息
     *
     * @return
     */
    @Override
    public Result<Set<Host>> querryAbleHost() throws ODL_IO_Exception {
            Result<Set<Host>> result=new Result<>();
            Set<Host> hosts=getAbleHost();
            result.setStatus(RespCode.success);
            result.setDescription("querry sucess");
            result.setResult(hosts);
            return result;
    }

    /**
     * 查询可用端口信息
     *
     * @return
     */
    
    @Override
    public Result<Set<String>> querryAblePort() throws ODL_IO_Exception {
        Result<Set<String>> result=new Result<>();
        Set<String> ports=getAblePort();
        result.setStatus(RespCode.success);
        result.setDescription("querry sucess");
        result.setResult(ports);
        return result;

    }

    /**
     * 发现主机
     *
     * @return
     */
    @Override
    public Result discoverHost() {
        return null;
    }

    /**
     * 获取可用主机
     *
     * @return
     */
    @Override
    public HashSet<Host> getAbleHost() throws ODL_IO_Exception {
        HashSet<Host> busyHosts=getBusyHost();
        HashSet<Host> hosts=get_hosts();
        Iterator<Host> iterator=hosts.iterator();
        while(iterator.hasNext()){
            if(busyHosts.contains(iterator.next()))
                iterator.remove();
        }
        return hosts;
    }

    /**
     * 获取可用端口
     *
     * @return
     */
    @Override
    public HashSet<String> getAblePort() throws ODL_IO_Exception {
        HashSet<String> busyPorts=getBusyPorts();
        HashSet<String> ports=getOutPorts();
        Iterator<String> iterator=ports.iterator();
        while(iterator.hasNext()){
            if(busyPorts.contains(iterator.next()))
                iterator.remove();
        }
        return ports;
    }

    /**
     * 获取被占用的端口
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<String> getBusyPorts() throws ODL_IO_Exception {
        HashSet<String> ports=new HashSet<>();
        VTopo vTopo=new VTopo();
        HashSet<VTopo> vTopos=vTopo.readAll();
        for(VTopo vtopo:vTopos){
            for(VGroup vGroup:vtopo.getvGroups()){
               if(vGroup.getvPorts()!=null){
            	   for(VPort vPort:vGroup.getvPorts()){
            		   ports.add(vPort.getVport());
            	   }
               }
            }
        }
        return ports;
    }
    
    /**
     * 获取被占用的端口
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<String> getBusyPortsOfVGroup(String Group,String prefix) throws ODL_IO_Exception {
        HashSet<String> ports=new HashSet<>();
        VTopo vTopo=new VTopo();
        HashSet<VTopo> vTopos=vTopo.readAll();
        for(VTopo vtopo:vTopos){
            for(VGroup vGroup:vtopo.getvGroups()){
               if(Group.equals(vGroup.getGroup_id())){
            	   if(vGroup.getvPorts()!=null){
                	   for(VPort vPort:vGroup.getvPorts()){
                		  if(vPort!=null && vPort.getVport().startsWith(prefix))
                			  ports.add(vPort.getVport());
                	   }
                   }
               }
            }
        }
        return ports;
    }

    /**
     * 获取被占用的主机
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Host> getBusyHost() throws ODL_IO_Exception {
        HashSet<Host> busyHosts=new HashSet<>();
        VTopo vTopo=new VTopo();
        HashSet<VTopo> vTopos=vTopo.readAll();
        for(VTopo vtopo:vTopos){
            for(VGroup vGroup:vtopo.getvGroups()){
                for(VHost vHost:vGroup.getvHosts()){
                    Host host=get_host_from_name(vHost.getHostName());
                    busyHosts.add(host);
                }
            }
        }
        return busyHosts;
    }

    /**
     * 获取接入交换机
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Node> get_access_node() throws ODL_IO_Exception {
        HashSet<Node> Accessnodes=new HashSet<Node>();
        HashSet<String> AccessStringnodes=new HashSet<String>();
        HashSet<Node> nodes=this.getNodes();
        for(Node node:nodes){
            if(node.getNode_id().startsWith("host")){
                String node_connector=node.getHost_tracker_service_attachment_points().get(0).getTp_id();
                String []nodeinfo=node_connector.split(":");
                String nodeid=nodeinfo[0]+":"+nodeinfo[1];


                if(!AccessStringnodes.contains(nodeid)){

                    AccessStringnodes.add(nodeid);

                }
            }

        }
        for(String nodeid:AccessStringnodes){
            Node node2=new Node();
            node2.setNode_id(nodeid);
            Accessnodes.add(node2);

        }
        return Accessnodes;
    }

    /**
     * 获取内联链路
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Link> get_inner_link() throws ODL_IO_Exception {
        HashSet<Link> inner_links=new HashSet<Link>();
        for(Link link:this.getLinks()){
            if((link.getSource().getSource_node().startsWith("openflow")) && (link.getDestination().getDest_node().startsWith("openflow"))){
                inner_links.add(link);
            }
        }
        return inner_links;
    }

    /**
     * 获取所有交换机
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Node> get_switch() throws ODL_IO_Exception {
        HashSet<Node> switches=new HashSet<Node>();
        for(Node node:this.getNodes()){
            if(node.getNode_id().startsWith("openflow")){
                switches.add(node);
            }
        }
        return switches;
    }

    /**
     * 获取连接主机的端口
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Termination_point> get_ports_to_host() throws ODL_IO_Exception {
        HashSet<Termination_point>  ports_to_host=new HashSet<Termination_point>();
        HashSet<Host> hosts=this.get_hosts();
        for(Host host:hosts){
            Termination_point termination_point=new Termination_point();
            termination_point.setTp_id(host.getAccess_port());
            ports_to_host.add(termination_point);
        }
        return ports_to_host;
    }

    /**
     * 获取某个交换机上的连接主机的端口
     *
     * @param thenode
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Termination_point> get_ports_to_host(Node thenode) throws ODL_IO_Exception {
        HashSet<Termination_point>  ports_to_host=new HashSet<Termination_point>();
        HashSet<Host> hosts=this.get_hosts(thenode);
        for(Host host:hosts){
            Termination_point termination_point=new Termination_point();
            termination_point.setTp_id(host.getAccess_port());
            ports_to_host.add(termination_point);
        }
        return ports_to_host;
    }

    /**
     * 获取所有主机
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Host> get_hosts() throws ODL_IO_Exception {
        HashSet<Host> hosts=new HashSet<Host>();
        for(Node node:this.getNodes()){
            if(node.getNode_id().startsWith("host")){
                Host host=new Host();
                String port=node.getHost_tracker_service_attachment_points().get(0).getTp_id();
                String []portinfo=port.split(":");
                String nodename=portinfo[0]+":"+portinfo[1];
                host.setMac(node.getHost_tracker_service_addresses().get(0).getMac())
                        .setIp(node.getHost_tracker_service_addresses().get(0).getIp())
                        .setAccess_node(nodename)
                        .setAccess_port(port)
                        .setHost_name(node.getNode_id());
                hosts.add(host);
            }
        }
        return hosts;
    }

    /**
     * 获取某个节点的所有主机
     *
     * @param thenode
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Host> get_hosts(Node thenode) throws ODL_IO_Exception {
        HashSet<Host> hosts=new HashSet<Host>();
        for(Node node:this.getNodes()){
            if(node.getNode_id().startsWith("host")){
                Host host=new Host();
                String port=node.getHost_tracker_service_attachment_points().get(0).getTp_id();
                String []portinfo=port.split(":");
                String nodename=portinfo[0]+":"+portinfo[1];
                host.setMac(node.getHost_tracker_service_addresses().get(0).getMac())
                        .setIp(node.getHost_tracker_service_addresses().get(0).getIp())
                        .setAccess_node(nodename)
                        .setAccess_port(port)
                        .setHost_name(node.getNode_id());
                if(thenode.getNode_id().equals(nodename))
                    hosts.add(host);
            }
        }
        return hosts;
    }

    /**
     * 根据主机名获取主机
     *
     * @param hostA
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public Host get_host_from_name(String hostA) throws ODL_IO_Exception {
        Host host=new Host();
        for(Host h:this.get_hosts()){
            if(h.getHost_name().equals(hostA)){
                host=h;
                break;
            }
        }
        return host;
    }

    /**
     * 根据ip获取主机名
     *
     * @param ip
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public Host get_host_from_ip(String ip) throws ODL_IO_Exception {
        Host host=new Host();
        for(Host h:this.get_hosts()){
            if(h.getIp().equals(ip)){
                host=h;
                break;
            }
        }
        return host;
    }

    /**
     * 获取所有节点
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Node> getNodes() throws ODL_IO_Exception {
    	topology.setTopology_id(FLOWID);
        topology=topology.read(null);
        return topology.getNodes();
    }

    /**
     * 获取所有链路
     *
     * @return
     * @throws ODL_IO_Exception
     */
    @Override
    public HashSet<Link> getLinks() throws ODL_IO_Exception {
    	topology.setTopology_id(FLOWID);
        topology=topology.read(null);
        return topology.getLinks();
    }

    /**
     * 方法名：getLinkPorts</br>
     * 详述：TODO获取交换机之间的互联端口</br>
     * 开发人员：xujun</br>
     * 创建时间：2017年10月10日  </br>
     *
     * @return
     * @throws ODL_IO_Exception
     * @throws
     */
    @Override
    public HashSet<String> getLinkPorts() throws ODL_IO_Exception {
        HashSet<String> ports=new HashSet<>();
        for(Link link:this.getLinks()){
            String src=link.getSource().getSource_tp();
            String dest=link.getDestination().getDest_tp();

            if((src.startsWith("openflow")) && (dest.startsWith("openflow"))){
                ports.add(src);
                ports.add(dest);
            }
        }
        return ports;
    }

    /**
     * 方法名：getOutPorts</br>
     * 详述：TODO（获取外部端口）</br>
     * 开发人员：xujun</br>
     * 创建时间：2017年10月10日  </br>
     *
     * @return
     * @throws ODL_IO_Exception
     * @throws
     */
    @Override
    public HashSet<String> getOutPorts() throws ODL_IO_Exception {
        HashSet<String> linkPorts=getLinkPorts();
        HashSet<String> outPorts=new HashSet<>();
        for(Node n:get_switch()){
            for(Termination_point t:n.getTermination_points()){
                if(!linkPorts.contains(t.getTp_id()) && !t.getTp_id().contains("LOCAL")){
                    outPorts.add(t.getTp_id());
                }
            }
        }
        return outPorts;
    }
    @Override
    public HashSet<Termination_point> getOutPorts(String node) throws ODL_IO_Exception {
        HashSet<String> linkPorts=getLinkPorts();
        HashSet<Termination_point> outPorts=new HashSet<>();
        for(Node n:get_switch()){
            for(Termination_point t:n.getTermination_points()){
                if(!linkPorts.contains(t.getTp_id()) && !t.getTp_id().contains("LOCAL")){
                	if(t.getTp_id().startsWith(node))
                		outPorts.add(t);
                }
            }
        }
        return outPorts;
    }

    /**
     * 方法名：getPortName</br>
     * 详述：TODO（根据端口获取网卡名）</br>
     * 开发人员：xujun</br>
     * 创建时间：2017年10月10日  </br>
     *
     * @param port
     * @return
     * @throws ODL_IO_Exception
     * @throws
     */
    @Override
    public String getPortName(String port) throws ODL_IO_Exception {
        Node_connector node_connector=new Node_connector(port);
        return node_connector.read(port).getFlow_node_inventory_name();
    }
	@Override
	public HashSet<Termination_point> getAllPorts() throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		HashSet<Termination_point> ports=new HashSet<>();
		for(Node node:getNodes()){
			ports.addAll(node.getTermination_points());
		}
		return ports;
	}
	@Override
	public HashSet<Termination_point> getAllPorts(String node) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Node getNodeFromePort(Termination_point termination_point) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		for(Node node:getNodes()){
			for(Termination_point tp:node.getTermination_points()){
				if(termination_point.getTp_id().equals(tp.getTp_id())){
					return node;
				}
			}
		}
		return null;
		
		
	}
	@Override
	public Termination_point getPortFromEth(String eth) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		if(eth==null || eth.equals(" "))
			throw new ODL_IO_Exception("eth can not be null");
		for(Termination_point tp:getAllPorts()){
			Node_connector nd=new Node_connector();
			nd.setId(tp.getTp_id());
			nd=nd.read(null);
			if(eth.equals(nd.getFlow_node_inventory_name())){
				return tp;
			}
		}
		return null;
	}




	@Override
	public Result<Vtopology> getVtopology(String id) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Vtopology> result=new Result<>();
		Vtopology vtopology=new Vtopology();
		Set<Node> nodes=getNodes();
		List<VNode> vNodes=new ArrayList<>();
		if(nodes!=null){
			for(Node node:nodes){
				VNode vNode=new VNode();
				vNode.setName(node.getNode_id());
				vNodes.add(vNode);
			}	
		}
		vtopology.setNodes(vNodes);
		Set<Link> links=getLinks();
		List<VLink> vLinks=new ArrayList<>();
		if(links!=null){
			for(Link link:links){
				VLink vLink=new VLink();
				vLink.setId(link.getLink_id());
				vLink.setSource(link.getSource().getSource_node());
				vLink.setDestination(link.getDestination().getDest_node());
				vLinks.add(vLink);
			}
		}
		vtopology.setvLinks(vLinks);
		vtopology.setId(id);
		result.setDescription("success to querry topology");
		result.setResult(vtopology);
		result.setStatus(RespCode.success);
		return result;
	}




	@Override
	public HashSet<String> getAblePort(String prefix) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		HashSet<String> ports=new HashSet<>();
		
		for(String s:getAblePort()){
			if(s.startsWith(prefix)){
				ports.add(s);
			}
		}
		return ports;
	}




	@Override
	public Result<Set<String>> querryAblePort(String prefix) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Set<String>> result=new Result<>();
		HashSet<String> ports=getAblePort(prefix);
		result.setDescription("success to querry able ports of "+prefix);
		result.setResult(ports);
		result.setStatus(RespCode.success);
		return result;
	}




	@Override
	public Result<Set<String>> querryBusyPort(String prefix) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Set<String>> result=new Result<>();
		HashSet<String> ports=getBusyPorts(prefix);
		result.setDescription("success to querry busy ports of "+prefix);
		result.setResult(ports);
		result.setStatus(RespCode.success);
		return result;
	}




	@Override
	public HashSet<String> getBusyPorts(String prefix) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		HashSet<String> ports=new HashSet<>();
		
		for(String s:getBusyPorts()){
			if(s.startsWith(prefix)){
				ports.add(s);
			}
		}
		return ports;
	}
}
