package com.py.dao;

import java.util.List;
import com.py.vo.Order;

public interface OrderDAO {
	/*
	 * 查询所有订单
	 */
	public List<Order> selectOrder()throws Exception;
	/*
	 * 根据订单号查询订单
	 */
	public Order selectOrderByOrderId(String orderId)throws Exception;
	/*
	 * 根据会员账号查询订单
	 */
	public List<Order> selectOrderByAccount(String account)throws Exception;
	/*
	 * 增加订单
	 */
	public boolean insertOrder(Order order)throws Exception;
	/*
	 * 删除订单
	 */
	public boolean deleteOrderById(String orderId)throws Exception;
	/*
	 * 出货
	 */
	public boolean updateOrderSign(String orderId)throws Exception;
	/*
	 * 根据配送地址查询订单数量
	 */
	public int selectOrderByAddress(String address)throws Exception;
}
