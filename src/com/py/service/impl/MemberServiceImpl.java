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
	 * ͨ����Ա�˺Ų�ѯ�û�
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
	 * ��Ա��¼
	 */
	public Member selectMemberLogin(String account, String password) {
		Member member = new Member();
		if (account != null && password != null) {
			try {
				member = DAOFactory.getMemberDAOInstance()
						.selectMemberByAccount(account);
				if (member == null) {
					this.setResult("�����ڴ˻�Ա����������ȷ��Ա�˺ţ�����");
				} else if (!member.getPassword().equals(password)) {
					this.setResult("������󣡣���");
				} else {
					this.setResult(null);//��¼�ɹ�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return member;
	}

	/*
	 * ��ѯ���л�Ա
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
	 * ���ӻ�Ա
	 */
	public boolean insertMember(Member member) {
		boolean flag = false;
		if (member.getAccount() != null && member.getPassword() != null
				&& member.getReallyName() != null && member.getEmail() != null
				&& member.getTel() != null && member.getIdCard() != null) {
			try {
				flag = DAOFactory.getMemberDAOInstance().insertMember(member);
				if (flag) {
					this.setResult("ע��ɹ���");// ע��ɹ�
				} else {
					this.setResult("���û����Ѿ����ڣ�����");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return flag;

	}

	/*
	 * ɾ����Ա
	 */
	public boolean deleteMemberByAccount(String account) {
		boolean flag = false;
		try {
			flag = DAOFactory.getMemberDAOInstance().deleteMemberByAccount(
					account);
			if (flag) {
				this.setResult("ɾ���ɹ���");// ɾ���ɹ�
			} else {
				this.setResult("�����ڸû�Ա��ɾ��ʧ�ܣ�����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * �޸Ļ�Ա��Ϣ
	 */
	public boolean updateMember(Member member) {
		boolean flag = false;
		if (member.getAccount() != null && member.getPassword() != null
				&& member.getReallyName() != null && member.getEmail() != null
				&& member.getTel() != null && member.getIdCard() != null) {
			try {
				flag = DAOFactory.getMemberDAOInstance().updateMember(member);
				if (flag) {
					this.setResult("�޸ĳɹ���");// �޸ĳɹ�
				} else {
					this.setResult("�����ڸû�Ա���޸�ʧ�ܣ�����");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return flag;
	}
}
