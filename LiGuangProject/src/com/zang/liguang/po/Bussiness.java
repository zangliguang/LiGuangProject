package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Bussiness entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bussiness", catalog = "db_liguang")
public class Bussiness implements java.io.Serializable {

	// Fields

	private String bid;
	private String bname;
	private String classid;

	// Constructors

	/** default constructor */
	public Bussiness() {
	}

	/** full constructor */
	public Bussiness(String bname, String classid) {
		this.bname = bname;
		this.classid = classid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "bid", unique = true, nullable = false, length = 40)
	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	@Column(name = "bname", length = 40)
	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	@Column(name = "classid", length = 40)
	public String getClassid() {
		return this.classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

}