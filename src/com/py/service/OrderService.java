package com.py.service;

import java.util.List;

import com.py.vo.Order;
import com.py.vo.OrderDetail;

public interface OrderService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 创建订单
	 */
	public boolean insertOrder(Order order,List<OrderDetail> list);
	/*
	 * 查询订单
	 */
	public List<Order> selectOrder();
	/*
	 * 通过订单ID查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId);
	/*
	 * 修改订单标识
	 */
	public boolean updateOrderSign(String orderId);
	/*
	 * 通过订单编号删除订单
	 */
	public boolean deleteOrderByOrderId(String orderId);
	/*
	 * 配送地址规划
	 */
	public int selectOrderByAddress(String address);
}
