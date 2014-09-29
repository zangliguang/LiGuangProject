package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Bussinessclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bussinessclass")
public class Bussinessclass implements java.io.Serializable {

	// Fields

	private String bclassid;
	private String bclassname;
	private Integer ordernum;

	// Constructors

	/** default constructor */
	public Bussinessclass() {
	}

	/** full constructor */
	public Bussinessclass(String bclassname, Integer ordernum) {
		this.bclassname = bclassname;
		this.ordernum = ordernum;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "bclassid", unique = true, nullable = false, length = 40)
	public String getBclassid() {
		return this.bclassid;
	}

	public void setBclassid(String bclassid) {
		this.bclassid = bclassid;
	}

	@Column(name = "bclassname", length = 40)
	public String getBclassname() {
		return this.bclassname;
	}

	public void setBclassname(String bclassname) {
		this.bclassname = bclassname;
	}

	@Column(name = "ordernum")
	public Integer getOrdernum() {
		return this.ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

}