package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.ManagerDAO;
import com.py.vo.Manager;

public class ManagerDAOImpl implements ManagerDAO{
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement ps = null;// �������ݿ��������

	public ManagerDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}
	@Override
	/*
	 * ��ѯ����Ա��Ϣ
	 */
	public List<Manager> selectManager() throws Exception {
		// TODO Auto-generated method stub
		List<Manager> list = new ArrayList<Manager>();
		String sql = "SELECT * FROM tb_manager";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Manager manager = null;
		while(rs.next()){
			manager = new Manager();
			manager.setAccount(rs.getString(1));
			manager.setPassword(rs.getString(2));
			manager.setReallyName(rs.getString(3));
			manager.setTel(rs.getString(4));
			manager.setSign(rs.getInt(5));
			list.add(manager);
		}
		this.ps.close();
		return list;
	}
	
	@Override
	/*
	 * ������Ա�˺Ų�ѯ����Ա
	 */
	public Manager selectManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = null;
		String sql = "SELECT * FROM tb_manager WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			manager = new Manager();
			manager.setAccount(rs.getString(1));
			manager.setPassword(rs.getString(2));
			manager.setReallyName(rs.getString(3));
			manager.setTel(rs.getString(4));
			manager.setSign(rs.getInt(5));
		}
		this.ps.close();
		return manager;
	}

	@Override
	/*
	 * ���ӹ���Ա
	 */
	public boolean insertManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_manager VALUES(?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,manager.getAccount());
		this.ps.setString(2,manager.getPassword());
		this.ps.setString(3,manager.getReallyName());
		this.ps.setString(4,manager.getTel());
		this.ps.setInt(5,manager.getSign());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * ɾ������Ա
	 */
	public boolean deleteManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_manager WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * �޸Ĺ���Ա��Ϣ
	 */
	public boolean updateManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "UPDATE tb_manager SET password=?,reallyName=?,tel=? WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);		
		this.ps.setString(1, manager.getPassword());
		this.ps.setString(2, manager.getReallyName());
		this.ps.setString(3, manager.getTel());
		this.ps.setString(4, manager.getAccount());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	
}
