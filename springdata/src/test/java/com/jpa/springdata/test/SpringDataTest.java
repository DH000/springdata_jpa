package com.jpa.springdata.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpa.springdata.repository.member.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringDataTest {
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void test(){
		memberRepository.findById(1);
	}
	
	@Test
	public void testGreaterOrLike(){
		memberRepository.findByIdGreaterThanOrNameLike(2, "%AA%");
	}
	
	@Test
	public void testQueryByParam(){
		memberRepository.query(1);
	}
	
	public void testSql(){
		memberRepository.queryForSql(1);
	}
	
	@Test
	public void testQueryByParams(){
		memberRepository.query2(1, "test");
		memberRepository.query3(1, "test");
		memberRepository.query4(1, "test");
	}
	
	@Test
	public void testFindForLike(){
		memberRepository.findForLike("test");
		memberRepository.findForLike2("test");
		memberRepository.findForLike3("test");
	}
}
