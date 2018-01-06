package com.ebupt.vnbo.ServiceImpl.qos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.qos.Vqos;
import com.ebupt.vnbo.entity.qos.VqosSave;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.mapper.VqosMapper;
import com.ebupt.vnbo.service.qos.VqosService;
@Service
public class VqosServiceImpl implements VqosService{
	@Autowired
	private VqosMapper mapper;
	@Override
	public Result<Vqos> addVqos(Vqos vqos) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Vqos> result=new Result<>();
		vqos.send(null);
		VqosSave vqosSave=new VqosSave(vqos);
		mapper.insertVqos(vqosSave);
		result.setDescription("success to creat Vqos "+vqos.getName());
		result.setResult(vqos);
		result.setStatus(RespCode.success);
		return result;
	}

	@Override
	public Result<Vqos> delVqos(String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Vqos> result=new Result<>();
		VqosSave vqosSave=mapper.querryVqosWithName(name);
		if(vqosSave!=null){
			Vqos vqos=vqosSave.toVqos();
			vqos.remove(null);
			mapper.deleteVqos(vqosSave.getName());
			result.setResult(vqos);
		}
		result.setDescription("success to delete vqos ");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<List<Vqos>> querryVqos() throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<List<Vqos>> result=new Result<>();
		List<VqosSave> qSaves=mapper.querryVqos();
		List<Vqos> vqos=new ArrayList<>();
		if(qSaves!=null){
			for(VqosSave save:qSaves){
				vqos.add(save.toVqos());
			}
			result.setResult(vqos);
		}
		result.setDescription("success to querry Vqos");
		result.setStatus(RespCode.success);
		return result;
		
	}

	@Override
	public Result<Vqos> querryQos(String name) throws ODL_IO_Exception {
		// TODO Auto-generated method stub
		Result<Vqos> result=new Result<>();
		Vqos vqos=mapper.querryVqosWithName(name).toVqos();
		if(vqos!=null)
			result.setResult(vqos);
		result.setDescription("success to querry vqos "+vqos.getName());
		result.setStatus(RespCode.success);
		return result;
		
	}

}
