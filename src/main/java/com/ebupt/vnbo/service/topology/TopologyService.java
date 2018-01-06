package com.ebupt.vnbo.service.topology;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.topology.Host;
import com.ebupt.vnbo.entity.topology.Link;
import com.ebupt.vnbo.entity.topology.Node;
import com.ebupt.vnbo.entity.topology.Termination_point;
import com.ebupt.vnbo.entity.topology.Vtopology;

import java.util.HashSet;
import java.util.List;
import java.util.Set;




public interface TopologyService{
	/**
	 * 查询主机信息
	 * @return
	 */
	public Result<Set<Host>> querryHost() throws ODL_IO_Exception;
	/**
	 * 查询交换机信息
	 * @return
	 */
	public Result<Set<Node>> querrySwitch() throws ODL_IO_Exception;
	/**
	 * 查询可用主机信息
	 * @return
	 */
	public Result<Set<Host>> querryAbleHost() throws ODL_IO_Exception;
	/**
	 * 查询可用端口信息
	 * @return
	 */
	public Result<Set<String>> querryAblePort() throws ODL_IO_Exception;
	/**
	 * 
	* 方法名：querryAblePort</br>
	* 详述：TODO（查询指定交换机的可用端口）</br>
	* 开发人员：xujun</br>
	* 创建时间：2017年12月7日  </br>
	* @param prefix
	* @return
	* @throws ODL_IO_Exception
	* @throws
	 */
	public Result<Set<String>> querryAblePort(String prefix) throws ODL_IO_Exception;
	/**
	 * 
	* 方法名：querryAblePort</br>
	* 详述：TODO（查询指定交换机的不可用用端口）</br>
	* 开发人员：xujun</br>
	* 创建时间：2017年12月7日  </br>
	* @param prefix
	* @return
	* @throws ODL_IO_Exception
	* @throws
	 */
	public Result<Set<String>> querryBusyPort(String prefix) throws ODL_IO_Exception;

	/**
	 * 发现主机
	 * @return
	 */
	public Result discoverHost();
	/**
	 * 获取可用主机
	 * @return
	 */
	public HashSet<Host> getAbleHost() throws ODL_IO_Exception;
	/**
	 * 获取可用端口
	 * @return
	 */
	
	public Set<String> getAblePort(String prefix) throws ODL_IO_Exception;
	
	public HashSet<String> getAblePort() throws ODL_IO_Exception;
	/**
	 * 获取被占用的端口
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public HashSet<String> getBusyPorts() throws ODL_IO_Exception;
	
	/**
	 * 获取被占用的端口
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public HashSet<String> getBusyPorts(String prefixx) throws ODL_IO_Exception;
	/**
	 * 获取被占用的主机
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public HashSet<Host> getBusyHost() throws ODL_IO_Exception;
	/**
	 * 获取接入交换机
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public  HashSet<Node> get_access_node() throws ODL_IO_Exception;

	/**
	 * 获取内联链路
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public  HashSet<Link> get_inner_link() throws ODL_IO_Exception;

	/**
	 * 获取所有交换机
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public  HashSet<Node> get_switch() throws ODL_IO_Exception;

	/**
	 * 获取连接主机的端口
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public  HashSet<Termination_point> get_ports_to_host() throws ODL_IO_Exception;

	/**
	 * 获取某个交换机上的连接主机的端口
	 * @param thenode
	 * @return
	 * @throws ODL_IO_Exception
	 */
	public  HashSet<Termination_point> get_ports_to_host(Node thenode) throws ODL_IO_Exception;

	/**
	 * 获取所有主机
	 * @return
	 * @throws ODL_IO_Exception
	 */

	 public HashSet<Host> get_hosts() throws ODL_IO_Exception;

	/**
	 * 获取某个节点的所有主机
	 * @param thenode
	 * @return
	 * @throws ODL_IO_Exception
	 */
	 public HashSet<Host> get_hosts(Node thenode) throws ODL_IO_Exception;

	/**
	 * 根据主机名获取主机
	 * @param hostA
	 * @return
	 * @throws ODL_IO_Exception
	 */
	 public Host get_host_from_name(String hostA) throws ODL_IO_Exception;

	/**
	 * 根据ip获取主机名
	 * @param ip
	 * @return
	 * @throws ODL_IO_Exception
	 */
	 public Host get_host_from_ip(String ip) throws ODL_IO_Exception;

	/**
	 * 获取所有节点
	 * @return
	 * @throws ODL_IO_Exception
	 */
	 public HashSet<Node> getNodes() throws ODL_IO_Exception;

	/**
	 * 获取所有链路
	 * @return
	 * @throws ODL_IO_Exception
	 */
	 public HashSet<Link> getLinks() throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getLinkPorts</br>
	 * 详述：TODO获取交换机之间的互联端口</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年10月10日  </br>
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public HashSet<String> getLinkPorts() throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getOutPorts</br>
	 * 详述：TODO（获取外部端口）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年10月10日  </br>
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public HashSet<String> getOutPorts() throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getPortName</br>
	 * 详述：TODO（根据端口获取网卡名）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年10月10日  </br>
	 * @param port
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public String getPortName(String port) throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getAllPorts</br>
	 * 详述：TODO（获取所有网络端口）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年11月20日  </br>
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public HashSet<Termination_point> getAllPorts() throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getAllPorts</br>
	 * 详述：TODO（获取指定交换机的所有端口）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年11月20日  </br>
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public HashSet<Termination_point> getAllPorts(String node) throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getNodeFromePort</br>
	 * 详述：TODO（简单方法可一句话概述）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年11月20日  </br>
	 * @param termination_point
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public Node getNodeFromePort(Termination_point termination_point) throws ODL_IO_Exception;
	 /**
	 * @throws ODL_IO_Exception 
	  * 
	 * 方法名：getPortFromEth</br>
	 * 详述：TODO（从网卡名获取端口）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年11月20日  </br>
	 * @param eth
	 * @return
	 * @throws
	  */
	 public Termination_point getPortFromEth(String eth) throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getVtopology</br>
	 * 详述：TODO（获取物理拓扑）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年12月1日  </br>
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	 public Result<Vtopology> getVtopology(String id) throws ODL_IO_Exception;
	 /**
	  * 
	 * 方法名：getBusyPortsOfVGroup</br>
	 * 详述：TODO（查询指定的busy port）</br>
	 * 开发人员：xujun</br>
	 * 创建时间：2017年12月8日  </br>
	 * @param Group
	 * @param prefix
	 * @return
	 * @throws ODL_IO_Exception
	 * @throws
	  */
	HashSet<String> getBusyPortsOfVGroup(String Group, String prefix) throws ODL_IO_Exception;
	Result<Set<String>> querryBusyPorts(String Vgroup, String node) throws ODL_IO_Exception;
	HashSet<Termination_point> getOutPorts(String node) throws ODL_IO_Exception;
	
	 
}
