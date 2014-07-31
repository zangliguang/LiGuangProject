package com.zang.liguang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.service.BusinessService;
import com.zang.liguang.util.LiGuangUtils;

@Namespace("/liguang")
@Results({ @Result(name = "success", location = "loginSucess.jsp"),
		@Result(name = "ERROR", location = "error.vm"),
		@Result(name = "GETBUSINESSCLASS", location = "first.jsp"), })
public class BusinessAction extends ActionSupport {

	
	@Autowired
	private BusinessService businessService;
	
	private List<Bussiness> businesslist;
	private List<Bussinessclass> businessclasslist;
	private Bussinessclass businessclass;
	private Bussiness business;
	private String classid; 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String getAllBusiness() throws IOException {
		businesslist = businessService.listAllBusiness();
		LiGuangUtils.listToJson(businesslist);
		return null;
	}
	public String getAllBusinessClass() throws IOException {
		businessclasslist = businessService.listAllBusinessClass();
		LiGuangUtils.listToJson(businessclasslist);
		return null;
	}
	public String getAllBusinessClassToWeb() throws IOException {
		businessclasslist = businessService.listAllBusinessClass();
		businesslist = businessService.listAllBusiness();
		return "GETBUSINESSCLASS";
	}
	public String getAllBusinessByClassid() throws IOException {
		businesslist = businessService.listBusinessByClassid(classid);
		LiGuangUtils.listToJson(businesslist);
		return "";
	}

	
	public String saveOrupdateBusiness() throws IOException {
		businessService.saveOrupdateBusiness(business);
		return "";
	}
	public String saveOrupdateBusinessClass() throws IOException {
		businessService.saveOrupdateBusinessClass(businessclass);
		return "";
	}
	public String deletebusinessClass() throws IOException {
		businessService.deletebusinessClass(businessclass);
		return "";
	}
	public String deletebusiness() throws IOException {
		businessService.deletebusiness(business);
		return "";
	}

	
	
	public List<Bussiness> getList() {
		return businesslist;
	}

	public void setList(List<Bussiness> list) {
		this.businesslist = list;
	}

	public List<Bussiness> getBusinesslist() {
		return businesslist;
	}

	public void setBusinesslist(List<Bussiness> businesslist) {
		this.businesslist = businesslist;
	}

	public List<Bussinessclass> getBusinessclasslist() {
		return businessclasslist;
	}

	public void setBusinessclasslist(List<Bussinessclass> businessclasslist) {
		this.businessclasslist = businessclasslist;
	}

	public Bussinessclass getBusinessclass() {
		return businessclass;
	}

	public void setBusinessclass(Bussinessclass businessclass) {
		this.businessclass = businessclass;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public Bussiness getBusiness() {
		return business;
	}

	public void setBusiness(Bussiness business) {
		this.business = business;
	}

}
