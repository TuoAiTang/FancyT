package com.py.dao;

import java.util.List;
import com.py.vo.OrderDetail;

public interface OrderDetailDAO {
	/*
	 * ͨ�������Ų�ѯ������ϸ
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId)throws Exception;
	/*
	 * ͨ����Ʒ��Ų�ѯ������ϸ
	 */
	public List<OrderDetail> selectOrderDetailByGoodsId(int goodsId)throws Exception;
	/*
	 * ���Ӷ�����ϸ
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail)throws Exception;
	/*
	 * ɾ��������ϸ
	 */
	public boolean deleteOrderDetailByOrderId(String orderId)throws Exception;
}
