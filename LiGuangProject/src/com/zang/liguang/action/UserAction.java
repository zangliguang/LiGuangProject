package com.zang.liguang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.User;
import com.zang.liguang.service.UserService;
import com.zang.liguang.util.LiGuangUtils;

@Namespace("/liguang")
@Results({ @Result(name = "success", location = "loginSucess.jsp"),
		@Result(name = "ERROR", location = "error.vm"),
		@Result(name =  "session", location = "business!getAllBusinessClassToWeb.do", type = "redirect"),
		@Result(name = "upload", location = "upload.vm"), })
public class UserAction extends ActionSupport {

	@Autowired
	private UserService userService;
	private static final long serialVersionUID = 1L;
	private User user;
	private String ip;
	private String birthday;
	

	@Override
	public String execute() throws Exception {
		System.out.println(user.getLoginname());
		String result = ERROR;
		System.out.println(ip);
		if (null!=userService.login(user)) {
			result = SUCCESS;
		}

		return result;
	}

	public String login() {
		user.setPwd(LiGuangUtils.Md5(user.getPwd()));
		String result = ERROR;
		System.out.println(ip);
		if(null!=ServletActionContext.getRequest().getSession().getAttribute("user")){
			result =  "session";
		}else{
			User newUser=userService.login(user);
			if (null!=newUser) {
				ServletActionContext.getRequest().getSession().setAttribute("user", newUser); 
				ServletActionContext.getRequest().getSession().setAttribute("ip", ip); 
//				session.getAttribute("变量名"); //此时取出来的是Object, 一般需要强转 
//				session.removeAttribute("变量名"); 
//				session.invalidate(); //删除所有session中保存的键  
				
				result = SUCCESS;
			}
		}
		return result;
	}

	public String register() {
		System.out.println(user.getLoginname());
		user.setPwd(LiGuangUtils.Md5(user.getPwd()));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			user.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userService.addNewUser(user);
		return SUCCESS;
	}
	public String saveOrupdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			user.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userService.saveOrupdate(user);
		return SUCCESS;
	}
	public String deleteUser() {
		userService.deleteUser(user);
		return SUCCESS;
	}

	public String getAll() throws IOException {
		List<User> list = userService.listAll();
		JSONObject jobj = new JSONObject();
		
		jobj.accumulate("total", list.size());// total代表一共有多少数据
		jobj.put("rows", list);// row是代表显示的页的数据
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jobj);
		out.flush();
		out.close();
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
