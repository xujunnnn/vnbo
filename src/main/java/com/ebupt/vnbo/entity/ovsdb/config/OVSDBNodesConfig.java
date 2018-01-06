package com.ebupt.vnbo.entity.ovsdb.config;

import java.util.ArrayList;
import java.util.List;

public class OVSDBNodesConfig {
	private List<OVSDBNodeConfig> nodes;

	public List<OVSDBNodeConfig> getNodes() {
		return nodes;
	}

	public void setNodes(List<OVSDBNodeConfig> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "OVSDBNodesConfig [nodes=" + nodes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
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
		OVSDBNodesConfig other = (OVSDBNodesConfig) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}
	
	
}
