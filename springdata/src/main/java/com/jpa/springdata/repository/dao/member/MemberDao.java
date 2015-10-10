package com.jpa.springdata.repository.dao.member;

import com.jpa.springdata.entity.member.Member;

/**
 * 
 * desc:   TODO
 * @author xuelin
 * @date   Sep 20, 2015
 */
public interface MemberDao {
	
	public Member findById(Integer id);
	
}
