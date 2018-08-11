package com.py.service;


import java.util.List;
import com.py.vo.Member;

public interface MemberService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 通过会员账号查询用户
	 */
	public Member selectMemberByAccount(String account);
	/*
	 * 会员登录
	 */
	public Member selectMemberLogin(String account, String password);
	/*
	 * 查询所有会员
	 */
	public List<Member> selectMember();
	/*
	 * 增加会员
	 */
	public boolean insertMember(Member member);
	/*
	 * 删除会员
	 */
	public boolean deleteMemberByAccount(String account);
	/*
	 * 修改会员信息
	 */
	public boolean updateMember(Member member);
}
