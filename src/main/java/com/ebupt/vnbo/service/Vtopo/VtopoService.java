package com.ebupt.vnbo.service.Vtopo;

import java.util.List;
import java.util.Set;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;

import com.ebupt.vnbo.entity.vtopo.VGroup;
import com.ebupt.vnbo.entity.vtopo.VHost;
import com.ebupt.vnbo.entity.vtopo.VPort;
import com.ebupt.vnbo.entity.vtopo.VTopo;

public interface VtopoService {
	Result<VTopo> addVtopo(String name,VTopo vTopo) throws ODL_IO_Exception;
	Result<VTopo> deleteVtopo(String name) throws ODL_IO_Exception;
	Result<VTopo> querryVtopo(String name) throws ODL_IO_Exception;
	Result<Set<VTopo>> querryVtopos() throws ODL_IO_Exception;
	Result<VGroup> addVGroup(String Vtopo,String name,VGroup vGroup) throws ODL_IO_Exception;
	Result<VGroup> deleteVGroup(String Vtopo,String name) throws ODL_IO_Exception;
	Result<VGroup> querryVGroup(String Vtopo,String name) throws ODL_IO_Exception;
	Result<List<VGroup>> querryVGroups(String Vtopo) throws ODL_IO_Exception;
	Result<VPort> addVPort(String Vtopo,String vGroup,String name,VPort vPort) throws ODL_IO_Exception;
	Result<VPort> deleteVPort(String Vtopo,String vGroup,String name) throws ODL_IO_Exception;
	Result<VPort> querryVPort(String Vtopo,String vGroup,String name) throws ODL_IO_Exception;
	Result<List<VPort>> querryVPorts(String Vtopo, String vGroup) throws ODL_IO_Exception;
	Result<List<VPort>> addVPort(String Vtopo, String vGroup, String name, List<VPort> vPorts) throws ODL_IO_Exception;
	Result<List<String>> addHost(List<String> host) throws ODL_IO_Exception;
	Result<List<String>> delHost(List<String> host) throws ODL_IO_Exception;
	Result<List<String>> querryHost() throws ODL_IO_Exception;
	Result<VHost> addVHost(String Vtopo,String vGroup,String name,VHost vHost) throws ODL_IO_Exception;
	Result<VHost> deleteVHost(String Vtopo,String vGroup,String name) throws ODL_IO_Exception;
	Result<VHost> querryVHost(String Vtopo,String vGroup,String name) throws ODL_IO_Exception;
}
