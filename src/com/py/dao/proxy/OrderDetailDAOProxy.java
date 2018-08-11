package com.py.dao.proxy;

import java.util.List;
import com.py.dao.OrderDetailDAO;
import com.py.dao.impl.OrderDetailDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.OrderDetail;

public class OrderDetailDAOProxy implements OrderDetailDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private OrderDetailDAO dao = null;//声明DAO对象
	public OrderDetailDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new OrderDetailDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 通过订单号查询订单明细
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(String orderId)
			throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;//定义返回的集合
		try{
			list = this.dao.selectOrderDetailByOrderId(orderId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	@Override
	public List<OrderDetail> selectOrderDetailByGoodsId(int goodsId)
			throws Exception {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;//定义返回的集合
		try{
			list = this.dao.selectOrderDetailByGoodsId(goodsId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	@Override
	/*
	 * 增加订单明细
	 */
	public boolean insertOrderDetail(OrderDetail orderDetail) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			flag = this.dao.insertOrderDetail(orderDetail);
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 删除订单明细
	 */
	public boolean deleteOrderDetailByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectOrderDetailByOrderId(orderId)!=null){
				flag = this.dao.deleteOrderDetailByOrderId(orderId);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}


}
