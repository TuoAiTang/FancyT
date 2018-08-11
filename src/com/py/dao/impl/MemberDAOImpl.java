package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.MemberDAO;
import com.py.vo.Member;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement ps = null;// �������ݿ��������

	public MemberDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}

	@Override
	/*
	 * ͨ����Ա�˺Ų�ѯ�û�
	 */
	public Member selectMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Member member = null;//����Member����
		String sql = "SELECT * FROM tb_member WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����
		this.ps.setString(1, account);//���û�Ա�˺�
		ResultSet rs = this.ps.executeQuery();//ִ�в�ѯ����
		if(rs.next()){
			member = new Member();//ʵ����Member����
			member.setAccount(rs.getString(1));//����account����
			member.setPassword(rs.getString(2));//����password����
			member.setReallyName(rs.getString(3));//����reallyName����
			member.setEmail(rs.getString(4));//����email����
			member.setTel(rs.getString(5));//����tel����
			member.setIdCard(rs.getString(6));//����idCard����
			member.setIntergrate(rs.getInt(7));//���û���
		}
		this.ps.close();//�ر�PreparedStatement����
		return member;//�����ѯ��������򷵻�null
	}


	@Override
	/*
	 * ��ѯ���л�Ա
	 */
	public List<Member> selectMember() throws Exception {
		List<Member> list = new ArrayList<Member>();//���弯��
		String sql = "SELECT * FROM tb_member order by intergrate desc";//ʵ����PreparedStatement����
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();//ִ�в�ѯ����
		Member member = null;//����Member����
		while(rs.next()){//����ȡ��ȫ������
			member = new Member();
			member.setAccount(rs.getString(1));//����account����
			member.setPassword(rs.getString(2));//����password����
			member.setReallyName(rs.getString(3));//����reallyName����
			member.setEmail(rs.getString(4));//����email����
			member.setTel(rs.getString(5));//����tel����
			member.setIdCard(rs.getString(6));//����idCard����
			member.setIntergrate(rs.getInt(7));//���û���
			list.add(member);
		}
		this.ps.close();//�ر�PreparedStatement����
		return list;//���ؼ���
    }


	@Override
	/*
	 * ���ӻ�Ա
	 */
	public boolean insertMember(Member member) throws Exception {
		boolean flag = false;//�����ʶ��
		String sql = "INSERT INTO tb_member VALUES(?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����			
		this.ps.setString(1,member.getAccount());//����account����
		this.ps.setString(2,member.getPassword());//����password����
		this.ps.setString(3,member.getReallyName());//����reallyName����
		this.ps.setString(4,member.getEmail());//����email����
		this.ps.setString(5,member.getTel());//����tel����
		this.ps.setString(6,member.getIdCard());//����idCard����
		this.ps.setInt(7,0);//���ó�ʼ����Ϊ0
		if(this.ps.executeUpdate()>0){//ִ�в������
			flag = true;//����ɹ��򽫱�ʶ����Ϊtrue
		}
		this.ps.close();//�ر�PreparedStatement����
		return flag;//���ر�ʶ��
	}


	@Override
	/*
	 * ɾ����Ա
	 */
	public boolean deleteMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_member WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		if(this.ps.executeUpdate()>0){//���ݿⷢ������
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * �޸Ļ�Ա��Ϣ
	 */
	public boolean updateMember(Member member) throws Exception {
		boolean flag = false;//�����ʶ��
		String sql = "UPDATE tb_member SET password=?,reallyName=?,email=?,tel=?,idCard=?,intergrate=? WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);//ʵ����PreparedStatement����	
		//this.ps.setString(1,member.getAccount());//����account����
		this.ps.setString(1,member.getPassword());//����password����
		this.ps.setString(2,member.getReallyName());//����reallyName����
		this.ps.setString(3,member.getEmail());//����email����
		this.ps.setString(4,member.getTel());//����tel����
		this.ps.setString(5,member.getIdCard());//����idCard����
		this.ps.setInt(6, member.getIntergrate());//���û���
		this.ps.setString(7,member.getAccount());//�����û���
		if(this.ps.executeUpdate()>0){//ִ�в������
			flag = true;//����ɹ��򽫱�ʶ����Ϊtrue
		}
		this.ps.close();//�ر�PreparedStatement����
		return flag;//���ر�ʶ��
	}


}
