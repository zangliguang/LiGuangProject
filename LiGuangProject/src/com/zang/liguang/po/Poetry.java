package com.zang.liguang.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Poetry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "poetry")
public class Poetry implements java.io.Serializable {

	// Fields

	private String poetryid;
	private Timestamp creationdate;
	private String remarks;
	private String poetry;
	private String title;
	private String author;
	private String classid;

	// Constructors

	/** default constructor */
	public Poetry() {
	}

	/** full constructor */
	public Poetry(Timestamp creationdate, String remarks, String poetry, String title, String author, String classid) {
		this.creationdate = creationdate;
		this.remarks = remarks;
		this.poetry = poetry;
		this.title = title;
		this.author = author;
		this.classid = classid;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "poetryid", unique = true, nullable = false, length = 40)
	public String getPoetryid() {
		return this.poetryid;
	}

	public void setPoetryid(String poetryid) {
		this.poetryid = poetryid;
	}

	@Column(name = "creationdate", length = 19)
	public Timestamp getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Timestamp creationdate) {
		this.creationdate = creationdate;
	}

	@Column(name = "remarks", length = 100)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "poetry", length = 800)
	public String getPoetry() {
		return this.poetry;
	}

	public void setPoetry(String poetry) {
		this.poetry = poetry;
	}

	@Column(name = "title", length = 40)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author", length = 10)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "classid", length = 40)
	public String getClassid() {
		return this.classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

}