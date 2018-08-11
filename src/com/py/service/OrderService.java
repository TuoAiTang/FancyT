package com.py.service;

import java.util.List;

import com.py.vo.Order;
import com.py.vo.OrderDetail;

public interface OrderService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ��������
	 */
	public boolean insertOrder(Order order,List<OrderDetail> list);
	/*
	 * ��ѯ����
	 */
	public List<Order> selectOrder();
	/*
	 * ͨ������ID��ѯ������ϸ
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId);
	/*
	 * �޸Ķ�����ʶ
	 */
	public boolean updateOrderSign(String orderId);
	/*
	 * ͨ���������ɾ������
	 */
	public boolean deleteOrderByOrderId(String orderId);
	/*
	 * ���͵�ַ�滮
	 */
	public int selectOrderByAddress(String address);
}
