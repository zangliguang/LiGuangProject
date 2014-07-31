package com.zang.liguang.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.Information;
import com.zang.liguang.po.User;
import com.zang.liguang.service.AttachmentService;
import com.zang.liguang.service.InformationService;
import com.zang.liguang.util.LiGuangUtils;

@Namespace("/liguang")
@Results({ @Result(name = "getInformationlistBybid", location = "informationlist.jsp"),
		@Result(name = "ERROR", location = "error.vm"),
		@Result(name = "GETBUSINESSCLASS", location = "first.jsp"), })
public class InformationAction extends ActionSupport {

	
	@Autowired
	private InformationService informationService;
	@Autowired
	private AttachmentService attachmentService;
	
	private List<Information> informationlist;
	private Information information;
	private File file;
	private String bid;
	private String bname;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
	
	public void saveOrupdate() throws IOException {
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(null!=user){
			information.setOwnerid(user.getUid());
		}
		informationService.saveOrupdate(information);
		if(null!=user){
			attachmentService.updateAttachmentBelongid(information.getInforid(),information.getOwnerid());
		}
		LiGuangUtils.printText("success");
	}
	
	public String getInformationlistBybid() {
		informationlist=informationService.getInformationlistBybid(bid);
		return "getInformationlistBybid";
	}
	
	
	
	public List<Information> getInformationlist() {
		return informationlist;
	}
	public void setInformationlist(List<Information> informationlist) {
		this.informationlist = informationlist;
	}
	public Information getInformation() {
		return information;
	}
	public void setInformation(Information information) {
		this.information = information;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getBid() {
		return bid;
	}


	public void setBid(String bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}


	


	

	

}
