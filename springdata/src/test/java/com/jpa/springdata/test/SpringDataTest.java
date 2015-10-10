package com.jpa.springdata.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jpa.springdata.entity.member.Member;
import com.jpa.springdata.repository.member.MemberRepository;
import com.jpa.springdata.service.impl.member.MemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringDataTest {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberServiceImpl memberService;
	
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
	
	@Test
	public void testSql(){
		Member member = memberRepository.queryForSql(1);
		System.out.println(member);
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
	
	@Test
	public void testUpdateMember(){
		memberService.updateMember("AAA", 1);
	}
	
	@Test
	public void testDeleteMember(){
		memberService.deleteMember(1);
	}
	
	@Test
	public void testInsertMember(){
		List<Member> members = new ArrayList<Member>();
		for(int i='A'; i<='Z'; i++){
			Member member = new Member("" + (char)i + (char)i, 20 + 1, new Date());
			members.add(member);
		}
		
		memberRepository.save(members);
	}
	
	@Test
	public void testPageAndSortMembers(){
		Page<Member> page = memberService.findByPage(2, 10);
		System.out.println("当前页码：" + page.getNumber());
		System.out.println("当前页记录数：" + page.getSize());
		System.out.println("总记录数：" + page.getTotalElements());
		System.out.println("总页码：" + page.getTotalPages());
		System.out.println("内容：" + page.getContent());
	}
	
	@Test
	public void testPageAndSortMembersByProperty(){
		Page<Member> page = memberService.findByPropertyForPage(2, 8);
		System.out.println("当前页码：" + page.getNumber());
		System.out.println("当前页记录数：" + page.getSize());
		System.out.println("总记录数：" + page.getTotalElements());
		System.out.println("总页码：" + page.getTotalPages());
		System.out.println("内容：" + page.getContent());
	}
	
	@Test
	public void testSaveAndFlush(){
		Member member = new Member("XYY", 20, new Date());
		member.setId(28);
		Member member2 = memberRepository.saveAndFlush(member);
		
		System.out.println(member == member2);
	}
	
	@Test
	public void testCustomRepository(){
		System.out.println(memberRepository.findById(2));
	}
}








