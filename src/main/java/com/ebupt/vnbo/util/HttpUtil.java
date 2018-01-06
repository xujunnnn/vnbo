package com.ebupt.vnbo.util;


import java.io.*;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.ebupt.vnbo.entity.exception.ODL_IO_Exception;

public class HttpUtil {
	private static String username="admin";
	private static String passwd="admin";
	/**
	 * send a get request
	 * @param url
	 * @return s[0]=responsedcode s[1]=responseinfor
	 * @throws ODL_IO_Exception 
	 */
	public static String[] Get_request(String url) throws ODL_IO_Exception{
		String [] s=new String[2];
		 String authStr = username + ":" + passwd;
		 String encoding= Base64.encodeBase64String(authStr.getBytes());
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpGet httpget=new HttpGet(url);
		 httpget.setHeader("Authorization", "Basic " +encoding);
		 httpget.setHeader("Accept","application/json");
		 try {
			HttpResponse response = httpClient.execute(httpget);
			//System.out.println("response code:"+response.getStatusLine().getStatusCode());
			s[0]=Integer.toString(response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);				
				}
			s[1]=result.toString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ODL_IO_Exception("fail to connect to odl");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ODL_IO_Exception("fail to connect to odl");
		
		}
		 finally{
			 
				httpget.releaseConnection();
	
		 }
		return s;
	}
	/**
	 * post a request with no entity
	 * @param url
	 * @return
	 * @throws ODL_IO_Exception 
	 */
	public static String [] Post_request(String url) throws ODL_IO_Exception{
		 String [] s=new String[2];
		 String authStr = username + ":" + passwd;
		 String encoding=Base64.encodeBase64String(authStr.getBytes());
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httppost=new HttpPost(url);
		 httppost.setHeader("Authorization", "Basic " +encoding);
		 httppost.addHeader("content-type", "application/json");
		 httppost.addHeader("Accept","application/json");
		 try {
			httppost.setEntity(new StringEntity(""));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				HttpResponse response = httpClient.execute(httppost);
				//System.out.println("response code:"+response.getStatusLine().getStatusCode());
				s[0]=Integer.toString(response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);				
					}
				 s[1]=result.toString();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			}
		 return s;
	}
	/**
	 * send a put request
	 * @param url
	 * @param jsondata
	 * @return
	 * @throws ODL_IO_Exception 
	 */
	public static String[] Put_request(String url,com.alibaba.fastjson.JSONObject jsondata) throws ODL_IO_Exception{
		 String [] resultStrings=new String[2];
		 String authStr = username + ":" + passwd;
		 String encoding=Base64.encodeBase64String(authStr.getBytes());
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPut httpPut=new HttpPut(url);
		 httpPut.setHeader("Authorization", "Basic " +encoding);
		 httpPut.addHeader("content-type", "application/json");
		 httpPut.addHeader("Accept","application/json");
		 try {
			httpPut.setEntity(new StringEntity(jsondata.toString()));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				HttpResponse response = httpClient.execute(httpPut);
				System.out.println("response code:"+response.getStatusLine().getStatusCode());
				resultStrings[0]=Integer.toString(response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);				
					}
				resultStrings[1]=result.toString();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			}
		 finally{
			 httpPut.releaseConnection();
		 	}
              return resultStrings;		 
		
	}
	//delete 请求
	/**
	 * send a delete
	 * @param url
	 * @return
	 * @throws ODL_IO_Exception 
	 */
	public static String[] Delete_request(String url) throws ODL_IO_Exception{
		 String[] s=new String[2];
		 String authStr = username + ":" + passwd;
		 String encoding=Base64.encodeBase64String(authStr.getBytes());
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpDelete httpDelete=new HttpDelete(url);
		 httpDelete.setHeader("Authorization", "Basic " +encoding);
		 httpDelete.addHeader("content-type", "application/json");
		 httpDelete.addHeader("Accept","application/json");
		 try {
			HttpResponse httpResponse=httpClient.execute(httpDelete);
			s[0]=Integer.toString(httpResponse.getStatusLine().getStatusCode());
			System.out.println(s[0]);
			BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);				
				}
			 s[1]=result.toString();
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			throw new ODL_IO_Exception("fail to connect to odl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ODL_IO_Exception("fail to connect to odl");
		}
		 finally{
			 httpDelete.releaseConnection();
		 }
		return s; 
		 
		
	}
 	//Post 请求
	/**
	 * send a post request with entity
	 * @param url
	 * @param jsondata
	 * @return
	 * @throws ODL_IO_Exception 
	 */
	public static String[] Post_request(String url,com.alibaba.fastjson.JSONObject jsondata) throws ODL_IO_Exception{
		String [] resultStrings=new String[2]; 
		String authStr = username + ":" + passwd;
		 String encoding=Base64.encodeBase64String(authStr.getBytes());
		 CloseableHttpClient httpClient = HttpClients.createDefault();
		 HttpPost httppost=new HttpPost(url);
		 httppost.setHeader("Authorization", "Basic " +encoding);
		 httppost.addHeader("content-type", "application/json");
		 httppost.addHeader("Accept","application/json");
		 try {
			httppost.setEntity(new StringEntity(jsondata.toString()));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
				HttpResponse response = httpClient.execute(httppost);
				System.out.println("response code:"+response.getStatusLine().getStatusCode());
				resultStrings[0]=Integer.toString(response.getStatusLine().getStatusCode());
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);				
					}
				 resultStrings[1]=result.toString();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ODL_IO_Exception("fail to connect to odl");
			}
		 finally {
			 httppost.releaseConnection();
			 
		 }
		 return resultStrings;
		
	}

}
