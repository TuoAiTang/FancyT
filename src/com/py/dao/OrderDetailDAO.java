package com.py.dao;

import java.util.List;
import com.py.vo.OrderDetail;

public interface OrderDetailDAO {
	/*
	 * 通过订单号查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId)throws Exception;
	/*
	 * 通过商品编号查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByGoodsId(int goodsId)throws Exception;
	/*
	 * 增加订单明细
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail)throws Exception;
	/*
	 * 删除订单明细
	 */
	public boolean deleteOrderDetailByOrderId(String orderId)throws Exception;
}
