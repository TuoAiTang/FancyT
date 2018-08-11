package com.py.dao.proxy;

import java.util.List;
import com.py.dao.OrderDetailDAO;
import com.py.dao.impl.OrderDetailDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.OrderDetail;

public class OrderDetailDAOProxy implements OrderDetailDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private OrderDetailDAO dao = null;//����DAO����
	public OrderDetailDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new OrderDetailDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ͨ�������Ų�ѯ������ϸ
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId)
			throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;//���巵�صļ���
		try{
			list = this.dao.selectOrderDetailByOrderId(orderId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	@Override
	public List<OrderDetail> selectOrderDetailByGoodsId(int goodsId)
			throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;//���巵�صļ���
		try{
			list = this.dao.selectOrderDetailByGoodsId(goodsId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	@Override
	/*
	 * ���Ӷ�����ϸ
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			flag = this.dao.insertOrderDetail(orderDetail);
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ��������ϸ
	 */
	public boolean deleteOrderDetailByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectOrderDetailByOrderId(orderId)!=null){
				flag = this.dao.deleteOrderDetailByOrderId(orderId);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}


}
