package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.OrderService;
import com.py.vo.Order;
import com.py.vo.OrderDetail;

public class OrderServiceImpl implements OrderService {
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * ��������
	 */
	public boolean insertOrder(Order order, List<OrderDetail> list) {
		boolean flag = false;
		OrderDetail orderdetail = null;
		for (int i = 0; i < list.size(); i++) {// �������ﳵ���Ƿ�Ϊ��
			orderdetail = list.get(i);
			if (orderdetail.getOrderId() == null
					|| orderdetail.getGoodsId() == 0
					|| orderdetail.getNumber() == 0
					|| orderdetail.getPrice() == 0.0) {
				this.setResult("���ﳵ������Ϊ�գ�");
				return false;
			}
		}
		if (order.getOrderId() != null && order.getAccount() != null
				&& order.getReallyName() != null && order.getAddress() != null
				&& order.getTel() != null && order.getSetMoney() != null
				&& order.getPost() != null && order.getBz() != null) {// �ж϶������Ƿ�Ϊ��
			try {
				flag = DAOFactory.getOrderDAOInstance().insertOrder(order);
				for (int i = 0; i < list.size(); i++) {
					if (!DAOFactory.getOrderDetailDAOInstance()
							.insertOrderDetail(list.get(i))) {//���붩����ϸ��
						this.setResult("������ϸ�����ʧ�ܣ�");
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return flag;
	}

	/*
	 * ��ѯ����
	 */
	public List<Order> selectOrder() {
		List<Order> list = null;
		try {
			list = DAOFactory.getOrderDAOInstance().selectOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ͨ������ID��ѯ������ϸ
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId) {
		List<OrderDetail> list = null;
		try {
			list = DAOFactory.getOrderDetailDAOInstance()
					.selectOrderDetailByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * �޸Ķ�����ʶ
	 */
	public boolean updateOrderSign(String orderId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getOrderDAOInstance().updateOrderSign(orderId);
			if (flag) {
				this.setResult("�����ɹ���");
			} else {
				this.setResult("����ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * ͨ���������ɾ������
	 */
	public boolean deleteOrderByOrderId(String orderId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getOrderDetailDAOInstance()
					.deleteOrderDetailByOrderId(orderId)
					&& DAOFactory.getOrderDAOInstance()
							.deleteOrderById(orderId);
			if (flag) {
				this.setResult("ɾ���ɹ���");
			} else {
				this.setResult("ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * ���͵�ַ�滮
	 */
	public int selectOrderByAddress(String address) {
		int num = 0;
		try {
			num = DAOFactory.getOrderDAOInstance()
					.selectOrderByAddress(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
