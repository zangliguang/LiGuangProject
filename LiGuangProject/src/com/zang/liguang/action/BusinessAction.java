package com.zang.liguang.action;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.Attachment;
import com.zang.liguang.po.Bussiness;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.User;
import com.zang.liguang.service.BusinessService;
import com.zang.liguang.util.LiGuangUtils;

@Namespace("/liguang")
@Results({ @Result(name = "success", location = "loginSucess.jsp"),
		@Result(name = "ERROR", location = "error.vm"),
		@Result(name = "GETBUSINESSCLASS", location = "business/ShopList.jsp"),
		@Result(name = "businessinfo", location = "business/ShopDetailPage.jsp"),
		@Result(name = "savebusiness", location = "business/Businesspublicinfo.jsp"),
		@Result(name = "mybusinessshop", location = "business/MyBusinessShop.jsp"),
		@Result(name = "goToHomePage", location = "LiGuangHome.jsp"), })
//@Result(name = "GETBUSINESSCLASS", location = "first.jsp"), })
public class BusinessAction extends ActionSupport {

	
	@Autowired
	private BusinessService businessService;
	
	private List<Bussiness> businesslist;
	private List<Bussinessclass> businessclasslist;
	private List<Attachment> attachmentlist;
	private Bussinessclass businessclass;
	private Bussiness business;
	private String classid; 
	private String bid; 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}

	public String getBusinessInfo() throws IOException {
		business = businessService.getBusinessById(bid);
		attachmentlist=businessService.getBusinessPic(bid);
		InetAddress myIPaddress=InetAddress.getLocalHost();
        String mi = myIPaddress.getHostAddress();
        System.out.println(mi);
		//LiGuangUtils.listToJson(businesslist);
		return "businessinfo";
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
	public String goToHomePage() throws IOException {
		return "goToHomePage";
	}
	public String getAllBusinessByClassid() throws IOException {
		businesslist = businessService.listBusinessByClassid(classid);
		LiGuangUtils.listToJson(businesslist);
		return "";
	}

	
	public String saveOrupdateBusiness() throws IOException {
		businessService.saveOrupdateBusiness(business);
		return "savebusiness";
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
	public String getMyBusinessByMasterId() throws IOException {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(null!=user){
			businesslist=businessService.getMyBusinessByMasterId(user.getUid());
		}
		return "mybusinessshop";
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

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public List<Attachment> getAttachmentlist() {
		return attachmentlist;
	}

	public void setAttachmentlist(List<Attachment> attachmentlist) {
		this.attachmentlist = attachmentlist;
	}
}
