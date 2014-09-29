package com.zang.liguang.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zang.liguang.po.Attachment;
import com.zang.liguang.po.User;
import com.zang.liguang.service.AttachmentService;
import com.zang.liguang.service.InformationService;
import com.zang.liguang.util.LiGuangUtils;

/**
 * @author zanglg
 *
 */
@Namespace("/liguang")
@Results({ @Result(name = "success", location = "loginSucess.jsp"), @Result(name = "ERROR", location = "error.vm"),
		@Result(name = "GETBUSINESSCLASS", location = "first.jsp"), })
public class UploaderAction extends ActionSupport {

	private File file;
	private Attachment att;
	private String uid;
	private String filename;
	private Long filesize;
	private String  belongid;
	@Autowired
	private AttachmentService attachmentService;

	@Override
	public String execute() throws Exception {
		System.out.println(filename);
		System.out.println(file.getName());
		System.out.println(file.length());
		String RandomfileName = LiGuangUtils.getNewFilename(filename);
		att = new Attachment();
		att.setUploaddate(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		att.setFilename(filename);
		att.setUid(uid);
		//att.setBelongid(belongid);
		att.setFilesize(file.length());
		String outpathString = ServletActionContext.getServletContext().getRealPath("/upload/" + RandomfileName);
		String AttUrl = "/upload/" + RandomfileName;
		att.setFileurl(AttUrl);
		att.setFiletype(LiGuangUtils.isPicture(filename) ? "pic" : "doc");
		if (!(new File(outpathString)).getParentFile().exists()) {
			(new File(outpathString)).getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/upload/" + RandomfileName));
		FileInputStream fis = new FileInputStream(file);

		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		fos.close();
		fis.close();
		if (LiGuangUtils.isPicture(outpathString)) {
			String smallname = LiGuangUtils.CreateThumbnail(ServletActionContext.getServletContext().getRealPath("/upload"), RandomfileName);
			att.setSmallurl("/upload/" + RandomfileName);
		}
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		String ip = (String) ServletActionContext.getRequest().getSession().getAttribute("ip");
		att.setUid(null != user ? user.getUid() : null);
		att.setIp(null != ip ? ip : null);
		attachmentService.save(att);

		return super.execute();
	}

	public void deleteNoOwnerfile() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (null != user) {
			attachmentService.updateAttachmentBelongid("delete", user.getUid());
		}
	}

	public void removeByNameAndSize() {
		attachmentService.removeByNameAndSize(filename, filesize);
	}

	public void getAlldeleteOrRemoveFile() throws IOException {
		List<Attachment> abandonFileList = attachmentService.getAlldeleteOrRemoveFile();
		attachmentService.deleteAlldeleteOrRemoveFile();
		LiGuangUtils.listToJson(abandonFileList);
		/**删除文件
		  for (Attachment att : abandonFileList) {
			File file = new File(ServletActionContext.getServletContext().getRealPath(att.getFileurl()));
			File smallfile;
			if (LiGuangUtils.isPicture(file.getName())) {
				smallfile = new File(ServletActionContext.getServletContext().getRealPath(att.getSmallurl()));
				if (smallfile.exists()) {
					smallfile.delete();
				}
			}
			if (file.exists()) {
				file.delete();
			}
		}*/
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Attachment getAtt() {
		return att;
	}

	public void setAtt(Attachment att) {
		this.att = att;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getBelongid() {
		return belongid;
	}

	public void setBelongid(String belongid) {
		this.belongid = belongid;
	}

}
