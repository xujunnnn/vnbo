package com.ebupt.vnbo.ServiceImpl.sfc;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.sfc.VNF;
import com.ebupt.vnbo.entity.sfc.VNFRead;
import com.ebupt.vnbo.service.sfc.VNFService;
import com.ebupt.vnbo.service.topology.TopologyService;
@Service
public class VNFServiceImpl implements VNFService{
	@Autowired
	private TopologyService topologyService;
	@Override
	public Result<VNF> addVNF(String vtoponame,String name,VNF vnf) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VNF> result=new Result<>();
		vnf.setTopologyService(topologyService);
		vnf.send(null);
		result.setDescription("success create vnf "+vnf);
		result.setResult(vnf);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<VNF> delVNF(String vtoponame,String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VNF> result=new Result<>();
		VNF vnf=new VNF();
		vnf.setVtoponame(vtoponame);
		vnf.setName(name);
		vnf.remove(null); 
		result.setDescription("success del vnf "+vnf);
		result.setResult(vnf);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<Set<VNFRead>> querryVNF(String vtoponame) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Set<VNFRead>> result=new Result<>();
		VNFRead vnfRead=new VNFRead();
		vnfRead.setVtopoName(vtoponame);
		result.setResult(vnfRead.readAll());
		result.setDescription("success to read vnfs");
		result.setStatus(RespCode.success);
		return result;		
	}

	@Override
	public Result<VNFRead> querryVNF(String vtoponame, String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<VNFRead> result=new Result<>();
		VNFRead vnfRead=new VNFRead().setVtopoName(vtoponame).setName(name);
		result.setDescription("success to read vnf "+name);
		result.setResult(vnfRead.read(null));
		result.setStatus(RespCode.success);
		return result;
	}


}
