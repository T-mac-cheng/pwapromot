package com.mac.test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import com.mac.bean.Datapro;
import com.mac.bean.Dataprodetail;
import com.mac.bean.MsgMainBean;
import com.mac.service.Wxservice;
import com.mac.util.Util;

import net.sf.json.JSONObject;

public class Test {
	
	@org.junit.Test
	public void sendTempMsg() {
		String at=Wxservice.getaccessToken();
		String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+at;
		MsgMainBean bean=new MsgMainBean();
		Datapro data=new Datapro();
		Dataprodetail first =new Dataprodetail();
		Dataprodetail keyword1 =new Dataprodetail();
		Dataprodetail keyword2 =new Dataprodetail();
		Dataprodetail keyword3 =new Dataprodetail();
		Dataprodetail keyword4 =new Dataprodetail();
		Dataprodetail remark =new Dataprodetail();
	
		first.setValue("药学审方");
		keyword1.setValue("第一医院");
		keyword2.setValue("盛宏");
		Date date=new Date();
		SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		keyword3.setValue(datef.format(date));
		keyword4.setValue("1111");
		remark.setValue("test rtpc status");
		
		data.setFirst(first);
		data.setKeyword1(keyword1);
		data.setKeyword2(keyword2);
		data.setKeyword3(keyword3);
		data.setKeyword4(keyword4);
		data.setRemark(remark);
		
		bean.setData(data);
		bean.setTemplate_id("zl53iHb1VMNDay0yKyPrAK-fVqiJbH6Wa4fUEKtizB0");
		bean.setTouser("onGUHs_D7GCpopo253NTaM6vaicw");
		TreeMap<String, String> miniprograms = new TreeMap<String, String>();
		miniprograms.put("appid","wx4bc5d13e7cb4b672");
		miniprograms.put("page","pages/consult/consult");
		bean.setMiniprogram(miniprograms);
		bean.setUrl("http://mp.weixin.qq.com");
		String djson=new JSONObject().fromObject(bean).toString();
		Util.doHttpclient(url, djson);
     //	String res=Util.post(url, djson);
     	
	}
		
}
