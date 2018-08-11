package com.py.dao.proxy;

import java.util.List;
import com.py.dao.MemberDAO;
import com.py.dao.impl.MemberDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Member;

public class MemberDAOProxy implements MemberDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private MemberDAO dao = null;//����DAO����
	public MemberDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new MemberDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 *ͨ����Ա�˺Ų�ѯ�û�
	 */
	public Member selectMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Member member = null;//�������
		try{
			member = this.dao.selectMemberByAccount(account);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return member;
	}

	@Override
	/*
	 *��ѯ���л�Ա 
	 */
	public List<Member> selectMember() throws Exception {
		// TODO Auto-generated method stub
		List<Member> list = null;//���巵�صļ���
		try{
			list = this.dao.selectMember();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ���ӻ�Ա
	 */
	public boolean insertMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectMemberByAccount(member.getAccount())==null){//�ж����ݿ����Ƿ���ڸû�Ա�˺�
				flag = this.dao.insertMember(member);//������ʵʵ����
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	 /*
	  * ɾ����Ա
	  */
	public boolean deleteMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectMemberByAccount(account)!=null){//�ж����ݿ����Ƿ���ڸû�Ա�˺�
				flag = this.dao.deleteMemberByAccount(account);//������ʵʵ����
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * �޸Ļ�Ա��Ϣ
	 */
	public boolean updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectMemberByAccount(member.getAccount())!=null){
				flag = this.dao.updateMember(member);//������ʵʵ����
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}
}
