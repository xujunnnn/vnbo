package com.ebupt.vnbo.service.macacl;

import com.ebupt.vnbo.entity.enums.OperationType;
import com.ebupt.vnbo.entity.enums.RespCode;
import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.entity.result.Result;
import com.ebupt.vnbo.entity.vtopo.MacAclList;

public interface MacAclService{
	Result<MacAclList> addMacList(MacAclList macAclList) throws ODL_IO_Exception;
	Result<MacAclList> removeMacList(MacAclList macAclList) throws ODL_IO_Exception;
	Result<MacAclList> querryMacList() throws ODL_IO_Exception;
	Result<MacAclList> querryAbleMacList() throws ODL_IO_Exception;

}
