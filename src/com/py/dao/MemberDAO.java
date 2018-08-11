package com.py.dao;
import java.util.List;
import com.py.vo.Member;
public interface MemberDAO {
	/*
	 *ͨ����Ա�˺Ų�ѯ�û�
	 */
	public Member selectMemberByAccount(String account)throws Exception;
	/*
	 *��ѯ���л�Ա 
	 */
	public List<Member> selectMember()throws Exception;
	/*
	 * ���ӻ�Ա
	 */
	public boolean insertMember(Member member)throws Exception;
	 /*
	  * ɾ����Ա
	  */
	public boolean deleteMemberByAccount(String account)throws Exception;
	/*
	 * �޸Ļ�Ա��Ϣ
	 */
	public boolean updateMember(Member member)throws Exception;
}
