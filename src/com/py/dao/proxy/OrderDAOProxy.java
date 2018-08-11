package com.py.dao.proxy;

import java.util.List;
import com.py.dao.OrderDAO;
import com.py.dao.impl.OrderDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Order;

public class OrderDAOProxy implements OrderDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private OrderDAO dao = null;//����DAO����
	public OrderDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new OrderDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ���ж���
	 */
	public List<Order> selectOrder() throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = null;//���巵�صļ���
		try{
			list = this.dao.selectOrder();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ���ݶ����Ų�ѯ����
	 */
	public Order selectOrderByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Order order = null;//�������
		try{
			order = this.dao.selectOrderByOrderId(orderId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return order;
	}

	@Override
	/*
	 * ���ݻ�Ա�˺Ų�ѯ����
	 */
	public List<Order> selectOrderByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = null;//���巵�صļ���
		try{
			list = this.dao.selectOrderByAccount(account);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ���Ӷ���
	 */
	public boolean insertOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectOrderByOrderId(order.getOrderId())==null){
				flag = this.dao.insertOrder(order);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ������
	 */
	public boolean deleteOrderById(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectOrderByOrderId(orderId)!=null){
				flag = this.dao.deleteOrderById(orderId);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ����
	 */
	public boolean updateOrderSign(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectOrderByOrderId(orderId)!=null){
				flag = this.dao.updateOrderSign(orderId);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}
	/*
	 * �������͵�ַ��ѯ��������
	 */
	public int selectOrderByAddress(String address) throws Exception {
		// TODO Auto-generated method stub
		int num = 0;
		try{
			num = this.dao.selectOrderByAddress(address);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return num;
	}

}
