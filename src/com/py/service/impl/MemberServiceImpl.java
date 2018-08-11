package com.py.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.MemberService;
import com.py.vo.Member;

public class MemberServiceImpl implements MemberService {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * 通过会员账号查询用户
	 */
	public Member selectMemberByAccount(String account) {
		Member member = new Member();
		try {
			member = DAOFactory.getMemberDAOInstance().selectMemberByAccount(
					account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	/*
	 * 会员登录
	 */
	public Member selectMemberLogin(String account, String password) {
		Member member = new Member();
		if (account != null && password != null) {
			try {
				member = DAOFactory.getMemberDAOInstance()
						.selectMemberByAccount(account);
				if (member == null) {
					this.setResult("不存在此会员，请输入正确会员账号！！！");
				} else if (!member.getPassword().equals(password)) {
					this.setResult("密码错误！！！");
				} else {
					this.setResult(null);//登录成功
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return member;
	}

	/*
	 * 查询所有会员
	 */
	public List<Member> selectMember() {
		List<Member> list = new ArrayList<Member>();
		try {
			list = DAOFactory.getMemberDAOInstance().selectMember();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 增加会员
	 */
	public boolean insertMember(Member member) {
		boolean flag = false;
		if (member.getAccount() != null && member.getPassword() != null
				&& member.getReallyName() != null && member.getEmail() != null
				&& member.getTel() != null && member.getIdCard() != null) {
			try {
				flag = DAOFactory.getMemberDAOInstance().insertMember(member);
				if (flag) {
					this.setResult("注册成功！");// 注册成功
				} else {
					this.setResult("此用户名已经存在！！！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return flag;

	}

	/*
	 * 删除会员
	 */
	public boolean deleteMemberByAccount(String account) {
		boolean flag = false;
		try {
			flag = DAOFactory.getMemberDAOInstance().deleteMemberByAccount(
					account);
			if (flag) {
				this.setResult("删除成功！");// 删除成功
			} else {
				this.setResult("不存在该会员，删除失败！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 修改会员信息
	 */
	public boolean updateMember(Member member) {
		boolean flag = false;
		if (member.getAccount() != null && member.getPassword() != null
				&& member.getReallyName() != null && member.getEmail() != null
				&& member.getTel() != null && member.getIdCard() != null) {
			try {
				flag = DAOFactory.getMemberDAOInstance().updateMember(member);
				if (flag) {
					this.setResult("修改成功！");// 修改成功
				} else {
					this.setResult("不存在该会员，修改失败！！！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return flag;
	}
}
