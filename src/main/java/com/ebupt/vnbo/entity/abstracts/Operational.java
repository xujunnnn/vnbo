package com.ebupt.vnbo.entity.abstracts;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;
import com.ebupt.vnbo.util.BaseUtil;
/**
 * 
* ����: Operational.java <br/>
* ���� : com.ebupt.vnbo.classes.abstracts <br/>
* ��ϸ����: TODO(������Ϣ��ѯ�ӿ�) <br/>
* ������Ա�� xujun   <br/>
* �������ڣ�2017��6��12�� <br/>
* �����汾�� V1.0  <br/>
 */
public interface Operational {
	public abstract Operational read(String node) throws ODL_IO_Exception;

}
