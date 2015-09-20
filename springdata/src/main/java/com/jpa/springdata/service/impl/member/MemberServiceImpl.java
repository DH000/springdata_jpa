package com.jpa.springdata.service.impl.member;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jpa.springdata.entity.member.Member;
import com.jpa.springdata.repository.member.MemberRepository;

@Service("memberService")
public class MemberServiceImpl {
	@Autowired
	private MemberRepository memberRepository;
	
	public void updateMember(String name, Integer id){
		memberRepository.updateMember(name, id);
	}
	
	public void deleteMember(Integer id){
		memberRepository.deleteMember(id);
	}
	
	public Page<Member> findByPage(Integer page, Integer size){
		Sort sort = new Sort(new Sort.Order[]{new Sort.Order(Direction.DESC, "id"), new Sort.Order(Direction.ASC, "birthDay")});
		Pageable pageable = new PageRequest(page, size, sort);
		return memberRepository.findAll(pageable);
	}
	
	public Page<Member> findByPropertyForPage(Integer page, Integer size){
		Specification<Member> spec = new Specification<Member>() {
			public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.gt((Path)root.get("id"), 5);
				return predicate;
			}
		};
		
		Sort sort = new Sort(new Sort.Order[]{new Sort.Order(Direction.DESC, "id"), new Sort.Order(Direction.ASC, "birthDay")});
		Pageable pageable = new PageRequest(page, size, sort);
		
		return memberRepository.findAll(spec, pageable);
	}
}
