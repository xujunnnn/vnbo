package com.ebupt.vnbo.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Properties;


import com.ebupt.vnbo.configure.MyConfig;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
public class BaseUtil {
	//读取ODL控制器Ip地址
	private static Logger logger= LoggerFactory.getLogger(BaseUtil.class.getName());

	public static MyConfig config;
	@Autowired
	public MyConfig myConfig;
	@PostConstruct
	public void init(){
		BaseUtil.config=myConfig;
	}
	//	public static String ConfigUrl=BaseUtil.getODL_IP()+"/restconf/config";
	//public static String OperationalUrl=BaseUtil.getODL_IP()+"/restconf/operational";
	public static String getInfluxDB_IP(){
		return BaseUtil.config.getInfluxDB();
	}
	public static String getODL_IP(){
		return config.getODL();
	}
	public static String getConfigUrl(){
		return getODL_IP()+"/restconf/config";
	}
	public static String getVtnConfigUrl(){
		return getODL_IP()+"/restconf/operations";
	}
	public static String getOperationalUrl(){
		return getODL_IP()+"/restconf/operational";
	}
	public static String getVtnOperationUrl(){
		return getODL_IP()+"/restconf/operations";
	}
	//获取输入的json对象
	public static JSONObject GetJson(BufferedReader bufferedReader){
		StringBuffer sb=new StringBuffer();
		String s;
		try {
			while((s=bufferedReader.readLine())!=null){
				sb.append(s);		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jsonObject=JSONObject.parseObject(sb.toString());
		return jsonObject;
	}
	  /**
	   * 将byte[]转换为int
	   * @param bytes
	   * @return
	   */
		public static int BytesToInt(byte[] bytes){
			return ByteBuffer.wrap(bytes).getInt();
		}
		/**
		 * 将int 转化为Byte[]
		 * @param i
		 * @return
		 */
		public static byte[] IntToBytes(int i){
			byte[] bytes=new byte[4];
			 bytes[3]=(byte)(i & 0xff);
			 bytes[2]=(byte)((i>>8) & 0xff);
			 bytes[1]=(byte)((i>>16) & 0xff);
			 bytes[0]=(byte)((i>>24) & 0xff);
			 return bytes;
		}
		/**
		 * 获取指定范围的iP
		 *
		 * @param starts
		 * @param ends
		 * @return
		 * @throws UnknownHostException
		 */
		public static HashSet<String> getIpInRange(String starts,String ends) throws UnknownHostException{
				HashSet< String> ipList=new HashSet<String>();		
				InetAddress start=InetAddress.getByName(starts);
				InetAddress end=InetAddress.getByName(ends);
				int srcAdd=BytesToInt(start.getAddress());
				int destAdd=BytesToInt(end.getAddress());
				for(int i=srcAdd;i<destAdd;i++){
				InetAddress inetAddress=InetAddress.getByAddress(IntToBytes(i));
				ipList.add(inetAddress.getHostAddress());			
				}
				return ipList;
		}
}
