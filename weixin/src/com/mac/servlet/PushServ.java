package com.mac.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mac.bean.Datapro;
import com.mac.bean.Dataprodetail;
import com.mac.bean.MsgMainBean;
import com.mac.service.Wxservice;
import com.mac.util.Util;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class PushServ
 */
@WebServlet("/PushServ")
public class PushServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PushServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		   doPost(request, response);
		    
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String patName=request.getParameter("name");
		String testNo=request.getParameter("testNo");
		String iteminfo=request.getParameter("iteminfo");
		
		System.out.println(patName+">>>"+iteminfo);
		
		
		String pagepath="pages/infos/infos?testNo="+testNo;
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
	
		first.setValue("您的检查报告结果已经出来了");
		keyword1.setValue(iteminfo);
		Date date=new Date();
		SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		keyword3.setValue(datef.format(date));
		keyword2.setValue(patName);
		remark.setValue("点击可查看具体信息!!!");
		
		data.setFirst(first);
		data.setKeyword1(keyword1);
		data.setKeyword2(keyword2);
		data.setKeyword3(keyword3);
		data.setRemark(remark);
		
		bean.setData(data);
		bean.setTemplate_id("gFych2HqxY8NrkTMam9D-Yy7BbHu41dDSbjZ_XxuZcA");
		bean.setTouser("onGUHs_D7GCpopo253NTaM6vaicw");
		TreeMap<String, String> miniprograms = new TreeMap<String, String>();
		miniprograms.put("appid","wx67fec5dd6ff7af69");
		miniprograms.put("page",pagepath);
		bean.setMiniprogram(miniprograms);
		bean.setUrl("http://mp.weixin.qq.com");
		String djson=new JSONObject().fromObject(bean).toString();
		System.out.println(djson);
	
		Util.doHttpclient(url, djson);
     	
		
		
	}

}
