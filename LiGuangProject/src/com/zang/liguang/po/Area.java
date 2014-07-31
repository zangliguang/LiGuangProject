package com.zang.liguang.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "area", catalog = "db_liguang")
public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String name;
	private String citycode;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(String code, String name, String citycode) {
		this.code = code;
		this.name = name;
		this.citycode = citycode;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 6)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "citycode", nullable = false, length = 6)
	public String getCitycode() {
		return this.citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

}