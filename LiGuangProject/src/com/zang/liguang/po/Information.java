package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Information entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "information")
public class Information implements java.io.Serializable {

	// Fields

	private String inforid;
	private String ownerid;
	private String bid;
	private String subject;
	private String content;

	// Constructors

	/** default constructor */
	public Information() {
	}

	/** full constructor */
	public Information(String ownerid, String bid, String subject, String content) {
		this.ownerid = ownerid;
		this.bid = bid;
		this.subject = subject;
		this.content = content;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "inforid", unique = true, nullable = false, length = 40)
	public String getInforid() {
		return this.inforid;
	}

	public void setInforid(String inforid) {
		this.inforid = inforid;
	}

	@Column(name = "ownerid", length = 40)
	public String getOwnerid() {
		return this.ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	@Column(name = "bid", length = 40)
	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	@Column(name = "subject", length = 40)
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "content", length = 200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}