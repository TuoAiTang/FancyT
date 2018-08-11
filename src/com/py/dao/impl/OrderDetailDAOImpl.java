package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.OrderDetailDAO;
import com.py.vo.OrderDetail;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement ps = null;// 定义数据库操作对象

	public OrderDetailDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	@Override
	/*
	 * 通过订单号查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sql = "SELECT * FROM tb_orderdetail WHERE orderId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, orderId);
		ResultSet rs = this.ps.executeQuery();
		OrderDetail orderdetail = null;
		while(rs.next()){
			orderdetail = new OrderDetail();
			orderdetail.setOrderId(rs.getString(1));
			orderdetail.setGoodsId(rs.getInt(2));
			orderdetail.setPrice(rs.getFloat(3));
			orderdetail.setNumber(rs.getInt(4));
			list.add(orderdetail);
		}
		this.ps.close();
		return list;
	}
	@Override
	/*
	 * 通过商品编号查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByGoodsId(int goodsId)
			throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		String sql = "SELECT * FROM tb_orderdetail WHERE goodsId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, goodsId);
		ResultSet rs = this.ps.executeQuery();
		OrderDetail orderdetail = null;
		while(rs.next()){
			orderdetail = new OrderDetail();
			orderdetail.setOrderId(rs.getString(1));
			orderdetail.setGoodsId(rs.getInt(2));
			orderdetail.setPrice(rs.getFloat(3));
			orderdetail.setNumber(rs.getInt(4));
			list.add(orderdetail);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * 增加订单明细
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_orderdetail VALUES(?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,orderDetail.getOrderId());
		this.ps.setInt(2,orderDetail.getGoodsId());
		this.ps.setFloat(3,orderDetail.getPrice());
		this.ps.setInt(4,orderDetail.getNumber());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 删除订单明细
	 */
	public boolean deleteOrderDetailByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_orderdetail WHERE orderId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, orderId);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	
}
