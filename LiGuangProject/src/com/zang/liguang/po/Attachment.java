package com.zang.liguang.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Attachment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "attachment")
public class Attachment implements java.io.Serializable {

	// Fields

	private String fileid;
	private String filename;
	private String filetype;
	private Long filesize;
	private String fileurl;
	private String smallurl;
	private String uid;
	private String belongid;
	private Timestamp uploaddate;
	private String ip;

	// Constructors

	/** default constructor */
	public Attachment() {
	}

	/** full constructor */
	public Attachment(String filename, String filetype, Long filesize, String fileurl, String smallurl, String uid, String belongid, Timestamp uploaddate,
			String ip) {
		this.filename = filename;
		this.filetype = filetype;
		this.filesize = filesize;
		this.fileurl = fileurl;
		this.smallurl = smallurl;
		this.uid = uid;
		this.belongid = belongid;
		this.uploaddate = uploaddate;
		this.ip = ip;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "fileid", unique = true, nullable = false, length = 40)
	public String getFileid() {
		return this.fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	@Column(name = "filename", length = 40)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "filetype", length = 10)
	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "filesize", precision = 11, scale = 0)
	public Long getFilesize() {
		return this.filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	@Column(name = "fileurl", length = 40)
	public String getFileurl() {
		return this.fileurl;
	}

	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}

	@Column(name = "smallurl", length = 40)
	public String getSmallurl() {
		return this.smallurl;
	}

	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	}

	@Column(name = "uid", length = 40)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "belongid", length = 40)
	public String getBelongid() {
		return this.belongid;
	}

	public void setBelongid(String belongid) {
		this.belongid = belongid;
	}

	@Column(name = "uploaddate", length = 19)
	public Timestamp getUploaddate() {
		return this.uploaddate;
	}

	public void setUploaddate(Timestamp uploaddate) {
		this.uploaddate = uploaddate;
	}

	@Column(name = "ip", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}