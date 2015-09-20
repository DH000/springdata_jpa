package com.jpa.springdata.repository.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.springdata.entity.member.Member;

/**
 * 
 * desc:   会员数据层
 * @author xuelin
 * @date   Sep 15, 2015
 */
public interface MemberRepository extends JpaRepository<Member, Integer>, JpaSpecificationExecutor<Member> {

	public Member findById(Integer id);
	
	public List<Member> findByIdGreaterThanOrNameLike(Integer id, String name);
	
	@Query(value = "select m.* from JPA_MEMBER m where m.ID = ?", nativeQuery = true)
	public Member queryForSql(Integer id);
	
	@Query("from Member m where m.id = ?")
	public Member query(Integer id);
	
	@Query("from Member m where m.id = ? and m.name = ?")
	public Member query2(Integer id, String name);
	
	@Query("from Member m where m.id = ?1 and m.name = ?2")
	public Member query3(Integer id, String name);
	
	@Query("from Member m where m.id = :id and m.name = :name")
	public Member query4(@Param("id") Integer id, @Param("name") String name);
	
	/**
	 * 
	 * desc: 参数需要传入'%{}%'格式参数
	 * @param name
	 * @return
	 */
	@Query("from Member m where m.name like ?")
	public Member findForLike(String name);
	
	/**
	 * 
	 * desc: %?%行不通
	 * @param name
	 * @return
	 */
	@Query("from Member m where m.name like %?1%")
	public Member findForLike2(String name);
	
	@Query("from Member m where m.name like %:name%")
	public Member findForLike3(@Param("name") String name);
	
	@Modifying
	@Query("update Member m set m.name = ? where m.id = ?")
	public void updateMember(String name, Integer id);
	
	@Modifying
	@Query("delete from Member m where m.id = ?")
	public void deleteMember(Integer id);
	
}




