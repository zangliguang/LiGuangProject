package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * BusinessRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "business_relation")
public class BusinessRelation implements java.io.Serializable {

	// Fields

	private String brelationid;
	private String businessid;
	private String businessclassid;

	// Constructors

	/** default constructor */
	public BusinessRelation() {
	}

	/** full constructor */
	public BusinessRelation(String businessid, String businessclassid) {
		this.businessid = businessid;
		this.businessclassid = businessclassid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "brelationid", unique = true, nullable = false, length = 40)
	public String getBrelationid() {
		return this.brelationid;
	}

	public void setBrelationid(String brelationid) {
		this.brelationid = brelationid;
	}

	@Column(name = "businessid", length = 40)
	public String getBusinessid() {
		return this.businessid;
	}

	public void setBusinessid(String businessid) {
		this.businessid = businessid;
	}

	@Column(name = "businessclassid", length = 40)
	public String getBusinessclassid() {
		return this.businessclassid;
	}

	public void setBusinessclassid(String businessclassid) {
		this.businessclassid = businessclassid;
	}

}