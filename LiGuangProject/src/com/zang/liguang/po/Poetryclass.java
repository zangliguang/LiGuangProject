package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Poetryclass entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "poetryclass")
public class Poetryclass implements java.io.Serializable {

	// Fields

	private String poetryclassid;
	private String classname;

	// Constructors

	/** default constructor */
	public Poetryclass() {
	}

	/** full constructor */
	public Poetryclass(String classname) {
		this.classname = classname;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "poetryclassid", unique = true, nullable = false, length = 40)
	public String getPoetryclassid() {
		return this.poetryclassid;
	}

	public void setPoetryclassid(String poetryclassid) {
		this.poetryclassid = poetryclassid;
	}

	@Column(name = "classname", length = 40)
	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

}