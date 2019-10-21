package com.mac.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import com.mac.bean.MsgMainBean;

import net.sf.json.JSONObject;

public class Util {
	
	
	
	
	public static String post(String url, String data) {
		try {
			URL urlObj = new URL(url);
			URLConnection connection = urlObj.openConnection();
			// 要发送数据出去，必须要设置为可发送数据状态
			connection.setDoOutput(true);
			// 获取输出流
			OutputStream os = connection.getOutputStream();
			// 写出数据
			os.write(data.getBytes());
			os.close();
			// 获取输入流
			InputStream is = connection.getInputStream();
			byte[] b = new byte[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = is.read(b)) != -1) {
				sb.append(new String(b, 0, len));
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String get(String url) {
		try {
			URL urlObj=new URL(url);
			
		URLConnection connection=urlObj.openConnection();
		InputStream is=connection.getInputStream();
		byte[] b=new byte[1024];
		int len;
		StringBuilder sb=new StringBuilder();
		while((len=is.read(b))!=-1) {
			sb.append(new String(b,0,len));
		}
		return sb.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return null;
	}
	
	
	public static void doHttpclient(String url,String data) {
		CloseableHttpClient httpClient=HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);
		RequestConfig requestConfig = RequestConfig.custom()  
                .setSocketTimeout(2000).setConnectTimeout(2000).build();  
        httpPost.setConfig(requestConfig);
        String result="";
        try {
        StringEntity s = new StringEntity(data,"utf-8");
        s.setContentEncoding((Header) new BasicHeader(HTTP.CONTENT_TYPE,
              "application/json"));
        httpPost.setEntity(s);
       
			HttpResponse httpResponse = httpClient.execute(httpPost);
			InputStream inStream = httpResponse.getEntity().getContent();
			 BufferedReader reader = new BufferedReader(new InputStreamReader(
					   inStream, "utf-8"));
			            StringBuilder strber = new StringBuilder();
			            String line = null;
			            while ((line = reader.readLine()) != null)
			                 strber.append(line + "\n");
			            inStream.close();
			 
			            result = strber.toString();
			            System.out.println(result);
			            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			            	                
			                               System.out.println("请求服务器成功，做相应处理");
			            	                
			                        } else {
			                          
			            	               System.out.println("请求服务端失败");
			                            
			            	           }
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
	}
	
	public void doUrlhttp(String httpUrl) {
		
	}
	
	
	
	
}
