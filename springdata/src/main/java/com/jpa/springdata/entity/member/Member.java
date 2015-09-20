package com.jpa.springdata.entity.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * desc: 会员实体
 * 
 * @author xuelin
 * @date Sep 15, 2015
 */
@Entity
@Table(name = "JPA_MEMBER")
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1736121715366199534L;
	
	private Integer id;
	private String name;
	private Integer age;
	private Date birthDay;
	private Date registerDate;
	
	public Member() {
		super();
	}

	public Member(String name, Integer age, Date birthDay) {
		super();
		this.name = name;
		this.age = age;
		this.birthDay = birthDay;
		this.registerDate = new Date();
	}

	@Id
	@GeneratedValue
	@Column(name = "ID")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH_DAY")
	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	@Column(name = "REGISTER_DATE")
	public Date getRegisterDate() {
		return registerDate;
	}
	
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", birthDay=" + birthDay + ", registerDate=" + registerDate + "]";
	}
}
