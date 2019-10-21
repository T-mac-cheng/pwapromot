package com.mac.service;

import com.mac.bean.AccessToken;
import com.mac.util.Util;

import net.sf.json.JSONObject;

public class Wxservice {
	private static final String TOKEN="mlrk";
	private static final String APPKEY="mlrk";
	private static final String GET_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String APPID="wx4ac24889e5fde635";
	private static final String APPSECRET="c187d121e4fc73161e0e15120ffdb670";
	
	public static AccessToken at;
	
	public static void getToken() {
		String url=GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		String tokenStr=Util.get(url);
		JSONObject  jsonObject=JSONObject.fromObject(tokenStr);
		String token =jsonObject.getString("access_token");
		String expiresIn =jsonObject.getString("expires_in");
		 at=new AccessToken(token, expiresIn);
	} 
	
		public static String getaccessToken() {
				if(at==null||at.isExpired()) {
					getToken();
				}
				return at.getAccessToken();
			}

}
