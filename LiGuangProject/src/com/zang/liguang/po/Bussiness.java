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
@Table(name = "bussiness")
public class Bussiness implements java.io.Serializable {

	// Fields

	private String bid;
	private String bname;
	private String classid;
	private String shopname;
	private String province;
	private String city;
	private String area;
	private String detailaddress;
	private String mastername;
	private String masterphone;
	private String masteremail;
	private String shopphone;
	private String licence;
	private String remarks;
	private Integer isLegal;
	private String masterid;

	// Constructors

	/** default constructor */
	public Bussiness() {
	}

	/** full constructor */
	public Bussiness(String bname, String classid, String shopname, String province, String city, String area, String detailaddress, String mastername,
			String masterphone, String masteremail, String shopphone, String licence, String remarks, Integer isLegal, String masterid) {
		this.bname = bname;
		this.classid = classid;
		this.shopname = shopname;
		this.province = province;
		this.city = city;
		this.area = area;
		this.detailaddress = detailaddress;
		this.mastername = mastername;
		this.masterphone = masterphone;
		this.masteremail = masteremail;
		this.shopphone = shopphone;
		this.licence = licence;
		this.remarks = remarks;
		this.isLegal = isLegal;
		this.masterid = masterid;
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

	@Column(name = "shopname", length = 40)
	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	@Column(name = "province", length = 20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 20)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "detailaddress", length = 40)
	public String getDetailaddress() {
		return this.detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	@Column(name = "mastername", length = 20)
	public String getMastername() {
		return this.mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	@Column(name = "masterphone", length = 20)
	public String getMasterphone() {
		return this.masterphone;
	}

	public void setMasterphone(String masterphone) {
		this.masterphone = masterphone;
	}

	@Column(name = "masteremail", length = 20)
	public String getMasteremail() {
		return this.masteremail;
	}

	public void setMasteremail(String masteremail) {
		this.masteremail = masteremail;
	}

	@Column(name = "shopphone", length = 20)
	public String getShopphone() {
		return this.shopphone;
	}

	public void setShopphone(String shopphone) {
		this.shopphone = shopphone;
	}

	@Column(name = "licence", length = 40)
	public String getLicence() {
		return this.licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	@Column(name = "remarks", length = 100)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "isLegal")
	public Integer getIsLegal() {
		return this.isLegal;
	}

	public void setIsLegal(Integer isLegal) {
		this.isLegal = isLegal;
	}

	@Column(name = "masterid", length = 40)
	public String getMasterid() {
		return this.masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

}