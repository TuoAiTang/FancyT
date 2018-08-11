package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.SortDAO;
import com.py.vo.Sort;

public class SortDAOImpl implements SortDAO{
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement ps = null;// �������ݿ��������

	public SortDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}

	@Override
	/*
	 * ��ѯ���
	 */
	public List<Sort> selectSort() throws Exception {
		// TODO Auto-generated method stub
		List<Sort> list = new ArrayList<Sort>();
		String sql = "SELECT * FROM tb_sort";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Sort sort = null;
		while(rs.next()){
			sort = new Sort();
			sort.setSortId(rs.getInt(1));
			sort.setSortName(rs.getString(2));
			list.add(sort);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * ͨ������Ų�ѯ���
	 */
	public Sort selectSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;
		String sql = "SELECT * FROM tb_sort WHERE sortId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, sortId);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			sort = new Sort();
			sort.setSortId(rs.getInt(1));
			sort.setSortName(rs.getString(2));
		}
		this.ps.close();
		return sort;
	}
	@Override
	/*
	 * ͨ��������Ʋ�ѯ���
	 */
	public Sort selectSortBySortName(String sortName) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;
		String sql = "SELECT * FROM tb_sort WHERE sortName=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, sortName);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			sort = new Sort();
			sort.setSortId(rs.getInt(1));
			sort.setSortName(rs.getString(2));
		}
		this.ps.close();
		return sort;
	}

	@Override
	/*
	 * �������
	 */
	public boolean insertSort(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_sort(sortName) VALUES(?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,sort.getSortName());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * ɾ�����
	 */
	public boolean deleteSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_sort WHERE sortId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, sortId);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

}
