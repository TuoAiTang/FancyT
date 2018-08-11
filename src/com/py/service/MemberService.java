package com.py.service;


import java.util.List;
import com.py.vo.Member;

public interface MemberService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ͨ����Ա�˺Ų�ѯ�û�
	 */
	public Member selectMemberByAccount(String account);
	/*
	 * ��Ա��¼
	 */
	public Member selectMemberLogin(String account, String password);
	/*
	 * ��ѯ���л�Ա
	 */
	public List<Member> selectMember();
	/*
	 * ���ӻ�Ա
	 */
	public boolean insertMember(Member member);
	/*
	 * ɾ����Ա
	 */
	public boolean deleteMemberByAccount(String account);
	/*
	 * �޸Ļ�Ա��Ϣ
	 */
	public boolean updateMember(Member member);
}
