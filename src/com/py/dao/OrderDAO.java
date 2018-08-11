package com.py.dao;

import java.util.List;
import com.py.vo.Order;

public interface OrderDAO {
	/*
	 * ��ѯ���ж���
	 */
	public List<Order> selectOrder()throws Exception;
	/*
	 * ���ݶ����Ų�ѯ����
	 */
	public Order selectOrderByOrderId(String orderId)throws Exception;
	/*
	 * ���ݻ�Ա�˺Ų�ѯ����
	 */
	public List<Order> selectOrderByAccount(String account)throws Exception;
	/*
	 * ���Ӷ���
	 */
	public boolean insertOrder(Order order)throws Exception;
	/*
	 * ɾ������
	 */
	public boolean deleteOrderById(String orderId)throws Exception;
	/*
	 * ����
	 */
	public boolean updateOrderSign(String orderId)throws Exception;
	/*
	 * �������͵�ַ��ѯ��������
	 */
	public int selectOrderByAddress(String address)throws Exception;
}
