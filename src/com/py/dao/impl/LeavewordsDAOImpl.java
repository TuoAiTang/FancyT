package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.LeavewordsDAO;
import com.py.vo.Leavewords;

public class LeavewordsDAOImpl implements LeavewordsDAO{
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement ps = null;// 定义数据库操作对象
	public LeavewordsDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}
	@Override
	/*
	 * 查询用户留言
	 */
	public List<Leavewords> selectLeavewords() throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list = new ArrayList<Leavewords>();
		String sql = "SELECT * FROM tb_leavewords ORDER BY id DESC";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Leavewords leavewords = null;
		while(rs.next()){
			leavewords = new Leavewords();
			leavewords.setId(rs.getInt(1));
			leavewords.setGoodsId(rs.getInt(2));
			leavewords.setAccount(rs.getString(3));
			leavewords.setTitle(rs.getString(4));
			leavewords.setContent(rs.getString(5));
			leavewords.setCreaTime(rs.getString(6));
			list.add(leavewords);
		}
		this.ps.close();
		return list;
	}
	
	@Override
	/*
	 * 通过留言编号查询用户留言
	 */
	public Leavewords selectLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;
		String sql = "SELECT * FROM tb_leavewords WHERE id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			leavewords = new Leavewords();
			leavewords.setId(rs.getInt(1));
			leavewords.setGoodsId(rs.getInt(2));
			leavewords.setAccount(rs.getString(3));
			leavewords.setTitle(rs.getString(4));
			leavewords.setContent(rs.getString(5));
			leavewords.setCreaTime(rs.getString(6));
		}
		this.ps.close();
		return leavewords;
	}
	
	@Override
	/*
	 * 通过商品编号查询用户留言
	 */
	public List<Leavewords> selectLeavewordsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list = new ArrayList<Leavewords>();
		String sql = "SELECT * FROM tb_leavewords WHERE goodsId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, goodsId);		
		ResultSet rs = this.ps.executeQuery();
		Leavewords leavewords = null;
		while(rs.next()){
			leavewords = new Leavewords();
			leavewords.setId(rs.getInt(1));
			leavewords.setGoodsId(rs.getInt(2));
			leavewords.setAccount(rs.getString(3));
			leavewords.setTitle(rs.getString(4));
			leavewords.setContent(rs.getString(5));
			leavewords.setCreaTime(rs.getString(6));
			list.add(leavewords);
		}
		this.ps.close();
		return list;
	}
	@Override
	/*
	 * 通过用户账号查询用户留言
	 */
	public Leavewords selectLeavewordsByAccount(String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;
		String sql = "SELECT * FROM tb_leavewords WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			leavewords = new Leavewords();
			leavewords.setId(rs.getInt(1));
			leavewords.setGoodsId(rs.getInt(2));
			leavewords.setAccount(rs.getString(3));
			leavewords.setTitle(rs.getString(4));
			leavewords.setContent(rs.getString(5));
			leavewords.setCreaTime(rs.getString(6));
		}
		this.ps.close();
		return leavewords;
	}
	@Override
	/*
	 * 按用户账号和用户密码查询用户留言
	 */
	public Leavewords selectLeavewords(int goodsId, String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;
		String sql = "SELECT * FROM tb_leavewords WHERE goodsId=? AND account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, goodsId);
		this.ps.setString(2, account);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			leavewords = new Leavewords();
			leavewords.setId(rs.getInt(1));
			leavewords.setGoodsId(rs.getInt(2));
			leavewords.setAccount(rs.getString(3));
			leavewords.setTitle(rs.getString(4));
			leavewords.setContent(rs.getString(5));
			leavewords.setCreaTime(rs.getString(6));
		}
		this.ps.close();
		return leavewords;
	}

	@Override
	/*
	 * 增加用户留言
	 */
	public boolean insertLeavewords(Leavewords leavewords) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_leavewords(goodsId,account,title,content,creaTime) VALUES(?,?,?,?,now())";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1,leavewords.getGoodsId());
		this.ps.setString(2,leavewords.getAccount());
		this.ps.setString(3,leavewords.getTitle());
		this.ps.setString(4,leavewords.getContent());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 删除用户留言
	 */
	public boolean deleteLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_leavewords WHERE id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}	
}
