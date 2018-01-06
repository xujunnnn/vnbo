package com.ebupt.vnbo.entity.flow_filter;
import com.alibaba.fastjson.annotation.JSONField;
/*
 "vtn-redirect-filter": {
                    "redirect-destination": {
                        "tenant-name": "vtn1",
                        "bridge-name": "vbr1",
                        "router-name": "0",
                        "terminal-name": "terminal1",
                        "interface-name": "if1"
                    },
                    "output": "true"
                }
 */
public class Vtn_Redirect_Filter {
	@JSONField(name="redirect-destination")
	private Redirect_Destination redirect_destination;
	private boolean output;
	public Redirect_Destination getRedirect_destination() {
		return redirect_destination;
	}
	public Vtn_Redirect_Filter setRedirect_destination(Redirect_Destination redirect_destination) {
		this.redirect_destination = redirect_destination;
		return this;
	}
	public boolean isOutput() {
		return output;
	}
	public Vtn_Redirect_Filter setOutput(boolean output) {
		this.output = output;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (output ? 1231 : 1237);
		result = prime * result + ((redirect_destination == null) ? 0 : redirect_destination.hashCode());
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
		Vtn_Redirect_Filter other = (Vtn_Redirect_Filter) obj;
		if (output != other.output)
			return false;
		if (redirect_destination == null) {
			if (other.redirect_destination != null)
				return false;
		} else if (!redirect_destination.equals(other.redirect_destination))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vtn_Redirect_Filter [redirect_destination=" + redirect_destination + ", output=" + output + "]";
	}


	
	
	
	
	
	
	
	
}


