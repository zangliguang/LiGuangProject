package com.zang.liguang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.util.TextUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.Bussinessclass;
import com.zang.liguang.po.Poetry;
import com.zang.liguang.po.Poetryclass;
import com.zang.liguang.po.User;
import com.zang.liguang.service.PoetryService;
import com.zang.liguang.service.UserService;
import com.zang.liguang.util.LiGuangUtils;

/**
 * @author zanglg
 *
 */
@Namespace("/liguang")
@Results({ @Result(name = "GOTO", location = "poetry/addPoetry.jsp"), 
	       @Result(name = "session", location = "business!getAllBusinessClassToWeb.do", type = "redirect"),
	       @Result(name = "poetrylist", location = "poetry/poetryList.jsp"),
	       @Result(name = "poetrycontent", location = "poetry/poetryContent.jsp"),
		@Result(name = "upload", location = "upload.vm"), })
public class PoetryAction extends ActionSupport {

	@Autowired
	private PoetryService poetryService;
	private static final long serialVersionUID = 1L;
	private Poetry poetry;
	private String id;
	private String createdate;
	private int toJson;// 1为true，0为false
	private boolean writeToJson;// 1为true，0为false
	private List<Poetry> poetrylist;
	private List<Poetryclass> poetryClasslist;
	private int currentPage=0;
	private int pageNum=0;
	private int pageSize=10;
	private int poetryNum=0;
	private String  PoetryId;

	@Override
	public String execute() throws Exception {
		String result = ERROR;
		if (null != result) {
			result = SUCCESS;
		}

		return result;
	}

	public String saveOrupdate() {
		String result = "addfail";
		if (poetryService.getPoetryByContent(poetry.getPoetry()).size() == 0) {
			poetryService.saveOrupdate(poetry);

			if (poetryService.getPoetry(poetry)) {
				result = "addsucess";
			}
		}
		return result;
	}

	public String getAllPoetry() throws IOException {
		poetrylist = poetryService.listAllPoetry();
		LiGuangUtils.listToJson(poetrylist);
		return null;
	}
	public String listAllPoetryByPage() throws IOException {
		poetrylist = poetryService.listAllPoetryByPage(currentPage,pageSize);
		poetryNum = poetryService.listAllPoetry().size();
		pageNum=poetryNum/pageSize+(poetryNum%pageSize==0?0:1);
		//LiGuangUtils.listToJson(poetrylist);
		return "poetrylist";
	}

	public String gotoAddPoetryPage() throws IOException {
		poetryClasslist = poetryService.listAllPoetryClass();
		return "GOTO";
	}
	public String getPoetrybyId() {
		poetry = poetryService.getPoetryById(PoetryId);
		return "poetrycontent";
	}

	public Poetry getPoetry() {
		return poetry;
	}

	public void setPoetry(Poetry poetry) {
		this.poetry = poetry;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Poetry> getPoetrylist() {
		return poetrylist;
	}

	public void setPoetrylist(List<Poetry> poetrylist) {
		this.poetrylist = poetrylist;
	}

	public int getPoetryNum() {
		return poetryNum;
	}

	public void setPoetryNum(int poetryNum) {
		this.poetryNum = poetryNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPoetryId() {
		return PoetryId;
	}

	public void setPoetryId(String poetryId) {
		PoetryId = poetryId;
	}

}
