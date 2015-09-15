package com.jpa.springdata.entity.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jpa.springdata.entity.member.Member;

/**
 * 
 * desc: 会员订单
 * 
 * @author xuelin
 * @date Sep 15, 2015
 */
@Entity
@Table(name = "JPA_ORDER")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 6715139392245369558L;
	
	private Integer id;
	private String name;
	private Member member;
	
	public Order() {
		super();
	}
	
	public Order(String name, Member member) {
		super();
		this.name = name;
		this.member = member;
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
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", member=" + member + "]";
	}
}
