package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.OrderDAO;
import com.py.vo.Order;

public class OrderDAOImpl implements OrderDAO{
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement ps = null;// 定义数据库操作对象

	public OrderDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}
	@Override
	/*
	 * 查询所有订单
	 */
	public List<Order> selectOrder() throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * FROM tb_order Order By creaTime DESC";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Order order = null;
		while(rs.next()){
			order = new Order();
			order.setOrderId(rs.getString(1));
			order.setAccount(rs.getString(2));
			order.setReallyName(rs.getString(3));
			order.setAddress(rs.getString(4));
			order.setTel(rs.getString(5));
			order.setSetMoney(rs.getString(6));
			order.setPost(rs.getString(7));
			order.setBz(rs.getString(8));
			order.setSign(rs.getInt(9));
			order.setCreaTime(rs.getString(10));
			list.add(order);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * 根据订单号查询订单
	 */
	public Order selectOrderByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Order order = null;
		String sql = "SELECT * FROM tb_order WHERE orderId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, orderId);
		ResultSet rs = this.ps.executeQuery();		
		while(rs.next()){
			order = new Order();
			order.setOrderId(rs.getString(1));
			order.setAccount(rs.getString(2));
			order.setReallyName(rs.getString(3));
			order.setAddress(rs.getString(4));
			order.setTel(rs.getString(5));
			order.setSetMoney(rs.getString(6));
			order.setPost(rs.getString(7));
			order.setBz(rs.getString(8));
			order.setSign(rs.getInt(9));
			order.setCreaTime(rs.getString(10));
		}
		this.ps.close();
		return order;
	}

	@Override
	/*
	 * 根据会员账号查询订单
	 */
	public List<Order> selectOrderByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		String sql = "SELECT * FROM tb_order WHERE account=? Order By creaTime DESC";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,account);
		ResultSet rs = this.ps.executeQuery();
		Order order = null;
		while(rs.next()){
			order = new Order();
			order.setOrderId(rs.getString(1));
			order.setAccount(rs.getString(2));
			order.setReallyName(rs.getString(3));
			order.setAddress(rs.getString(4));
			order.setTel(rs.getString(5));
			order.setSetMoney(rs.getString(6));
			order.setPost(rs.getString(7));
			order.setBz(rs.getString(8));
			order.setSign(rs.getInt(9));
			order.setCreaTime(rs.getString(10));
			list.add(order);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * 增加订单
	 */
	public boolean insertOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_order VALUES(?,?,?,?,?,?,?,?,?,now())";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,order.getOrderId());
		this.ps.setString(2,order.getAccount());
		this.ps.setString(3,order.getReallyName());
		this.ps.setString(4,order.getAddress());
		this.ps.setString(5,order.getTel());
		this.ps.setString(6,order.getSetMoney());
		this.ps.setString(7,order.getPost());
		this.ps.setString(8,order.getBz());
		this.ps.setInt(9,order.getSign());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 删除订单
	 */
	public boolean deleteOrderById(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_order WHERE orderId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, orderId);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 出货
	 */
	public boolean updateOrderSign(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "UPDATE tb_order SET sign=? WHERE orderId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, 1);
		this.ps.setString(2,orderId);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	/*
	 * 根据配送地址查询配送数量
	 */
	public int selectOrderByAddress(String address) throws Exception {
		String sql = "SELECT COUNT(*) FROM tb_order WHERE address=? and sign = 0";
		int num = 0;
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,address);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			num = rs.getInt(1);
		}
		this.ps.close();
		return num;
	}

}
