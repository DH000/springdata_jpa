package com.jpa.springdata.dao.impl.member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.springdata.dao.member.MemberDao;
import com.jpa.springdata.entity.member.Member;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 20, 2015
 */
public class MemberRepositoryImpl implements MemberDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Member findById(Integer id) {
		return entityManager.find(Member.class, id);
	}
	
}
