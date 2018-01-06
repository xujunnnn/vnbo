package com.ebupt.vnbo.entity.result;

import com.ebupt.vnbo.entity.enums.RespCode;

/**
 * Created by xujun on 2017/10/16.
 */
public class Result<T> {
    private RespCode Status;
    private String description;
    private T result;
    private long time;
	public RespCode getStatus() {
		return Status;
	}
	public void setStatus(RespCode status) {
		Status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
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
		Result other = (Result) obj;
		if (Status != other.Status)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Result [Status=" + Status + ", description=" + description + ", result=" + result + ", time=" + time
				+ "]";
	}

 
}
