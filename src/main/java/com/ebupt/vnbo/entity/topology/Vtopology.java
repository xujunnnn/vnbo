package com.ebupt.vnbo.entity.topology;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vtopology {
	private String id;
	private List<VNode> nodes;
	@JsonProperty("links")
	private List<VLink> vLinks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<VNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<VNode> nodes) {
		this.nodes = nodes;
	}
	public List<VLink> getvLinks() {
		return vLinks;
	}
	public void setvLinks(List<VLink> vLinks) {
		this.vLinks = vLinks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		result = prime * result + ((vLinks == null) ? 0 : vLinks.hashCode());
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
		Vtopology other = (Vtopology) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		if (vLinks == null) {
			if (other.vLinks != null)
				return false;
		} else if (!vLinks.equals(other.vLinks))
			return false;
		return true;
	}
	
	

}
