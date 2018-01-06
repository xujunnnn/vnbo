package com.ebupt.vnbo.entity.flow_filter;

import com.alibaba.fastjson.annotation.JSONField;

/*
 "vtn-set-inet-dst-action": {
    "ipv4-address": "10.0.0.1"
}
  "vtn-set-inet-src-action": {
    "ipv6-address": "fe80::b410:aaff:fe8a:a001/64"
}
 */
public class Vtn_Set_Inet_Addr_Action {
	@JSONField(name="ipv4-address")
	private String ipv4_address;
	@JSONField(name="ipv6-address")
	private String ipv6_address;
	
	public String getIpv6_address() {return this.ipv6_address;}
	public void setIpv6_address(String ipv6_address) {this.ipv6_address=ipv6_address;}
	public String getIpv4_address() {return this.ipv4_address;}
	public void setIpv4_address(String ipv4_address) {this.ipv4_address=ipv4_address;}
}
