package com.mac.bean;

import java.util.TreeMap;

public class MsgMainBean {
	
	private String touser; //onGUHs_D7GCpopo253NTaM6vaicw
	private String template_id; //zl53iHb1VMNDay0yKyPrAK-fVqiJbH6Wa4fUEKtizB0
	private String url;
	private TreeMap<String, String> miniprogram;
	private String topcolor;
	private Datapro data;
	
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
	public TreeMap<String, String> getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(TreeMap<String, String> miniprogram) {
		this.miniprogram = miniprogram;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public Datapro getData() {
		return data;
	}
	public void setData(Datapro data) {
		this.data = data;
	}
	
	

}
