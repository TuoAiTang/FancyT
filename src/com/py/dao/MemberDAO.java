package com.py.dao;
import java.util.List;
import com.py.vo.Member;
public interface MemberDAO {
	/*
	 *通过会员账号查询用户
	 */
	public Member selectMemberByAccount(String account)throws Exception;
	/*
	 *查询所有会员 
	 */
	public List<Member> selectMember()throws Exception;
	/*
	 * 增加会员
	 */
	public boolean insertMember(Member member)throws Exception;
	 /*
	  * 删除会员
	  */
	public boolean deleteMemberByAccount(String account)throws Exception;
	/*
	 * 修改会员信息
	 */
	public boolean updateMember(Member member)throws Exception;
}
