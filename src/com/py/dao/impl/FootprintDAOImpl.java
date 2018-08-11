package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.py.dao.FootprintDAO;
import com.py.vo.Footprint;

public class FootprintDAOImpl implements FootprintDAO {
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement ps = null;// �������ݿ��������
	public FootprintDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}
	@Override
	public List<Footprint> selectAllFp() throws Exception {
		List<Footprint> list = new ArrayList<Footprint>();
		String sql = "select * from footprint order by leavetime desc";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Footprint fp = null;
		while(rs.next()) {
			fp = new Footprint();
			fp.setAccount(rs.getString("account"));
			fp.setGoodsId(rs.getInt(2));
			fp.setLeavetime(rs.getString("leavetime"));
			list.add(fp);
		}
		
		this.ps.close();
		return list;
	}

	@Override
	public List<Footprint> selectAllFpByAccount(String account) throws Exception {
		List<Footprint> list = new ArrayList<Footprint>();
		String sql = "select * from footprint where account=? order by leavetime desc";
		this.ps = this.conn.prepareStatement(sql);
		ps.setString(1, account);
		ResultSet rs = this.ps.executeQuery();
		Footprint fp = null;
		while(rs.next()) {
			fp = new Footprint();
			fp.setAccount(rs.getString("account"));
			fp.setGoodsId(rs.getInt(2));
			fp.setLeavetime(rs.getString("leavetime"));
			list.add(fp);
		}
		
		this.ps.close();
		return list;
	}

	@Override
	public List<Footprint> selectThreeFpByAccount(String account) throws Exception {
		List<Footprint> list = new ArrayList<Footprint>();
		String sql = "select * from footprint where account=? order by leavetime desc";
		this.ps = this.conn.prepareStatement(sql);
		ps.setString(1, account);
		ResultSet rs = this.ps.executeQuery();
		Footprint fp = null;
		//ֻȡǰ�������ظ�Ԫ��
		int i = 0;
		while(rs.next()&&(i<3)) {
			fp = new Footprint();
			fp.setAccount(rs.getString("account"));
			fp.setGoodsId(rs.getInt(2));
			fp.setLeavetime(rs.getString("leavetime"));
			if(!include_in(fp,list)) {
				list.add(fp);
				i++;
			}
		}
		
		this.ps.close();
		return list;
	}

	@Override
	public boolean insertFp(Footprint fp) throws Exception {
		boolean flag = false;
		String sql = "insert into footprint values(?,?,now())";
		this.ps = this.conn.prepareStatement(sql);
		ps.setString(1, fp.getAccount());
		ps.setInt(2, fp.getGoodsId());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	//�ж�Ԫ�ص�goodsId�Ƿ��Ѿ����ֹ�
	public boolean include_in(Footprint fp, List<Footprint> list) {
		boolean flag = false;
		if(list.size() == 0) {
			flag = false;
		}else {
			for (Footprint footprint : list) {
				if(footprint.getGoodsId() == fp.getGoodsId()) {
					flag = true;
				}
			}
		}
		
		return flag;
	}
	
}
