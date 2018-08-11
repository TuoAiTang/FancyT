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
	 * 创建订单
	 */
	public boolean insertOrder(Order order, List<OrderDetail> list) {
		boolean flag = false;
		OrderDetail orderdetail = null;
		for (int i = 0; i < list.size(); i++) {// 遍历购物车表单是否为空
			orderdetail = list.get(i);
			if (orderdetail.getOrderId() == null
					|| orderdetail.getGoodsId() == 0
					|| orderdetail.getNumber() == 0
					|| orderdetail.getPrice() == 0.0) {
				this.setResult("购物车表单不能为空！");
				return false;
			}
		}
		if (order.getOrderId() != null && order.getAccount() != null
				&& order.getReallyName() != null && order.getAddress() != null
				&& order.getTel() != null && order.getSetMoney() != null
				&& order.getPost() != null && order.getBz() != null) {// 判断订单表单是否为空
			try {
				flag = DAOFactory.getOrderDAOInstance().insertOrder(order);
				for (int i = 0; i < list.size(); i++) {
					if (!DAOFactory.getOrderDetailDAOInstance()
							.insertOrderDetail(list.get(i))) {//插入订单明细表
						this.setResult("订单明细表插入失败！");
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return flag;
	}

	/*
	 * 查询订单
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
	 * 通过订单ID查询订单明细
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
	 * 修改订单标识
	 */
	public boolean updateOrderSign(String orderId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getOrderDAOInstance().updateOrderSign(orderId);
			if (flag) {
				this.setResult("出货成功！");
			} else {
				this.setResult("出货失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 通过订单编号删除订单
	 */
	public boolean deleteOrderByOrderId(String orderId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getOrderDetailDAOInstance()
					.deleteOrderDetailByOrderId(orderId)
					&& DAOFactory.getOrderDAOInstance()
							.deleteOrderById(orderId);
			if (flag) {
				this.setResult("删除成功！");
			} else {
				this.setResult("删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 配送地址规划
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
