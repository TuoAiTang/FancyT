package com.py.dao.proxy;

import java.util.List;
import com.py.dao.OrderDAO;
import com.py.dao.impl.OrderDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Order;

public class OrderDAOProxy implements OrderDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private OrderDAO dao = null;//声明DAO对象
	public OrderDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new OrderDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询所有订单
	 */
	public List<Order> selectOrder() throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = null;//定义返回的集合
		try{
			list = this.dao.selectOrder();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 根据订单号查询订单
	 */
	public Order selectOrderByOrderId(String orderId) throws Exception {
		// TODO Auto-generated method stub
		Order order = null;//定义对象
		try{
			order = this.dao.selectOrderByOrderId(orderId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return order;
	}

	@Override
	/*
	 * 根据会员账号查询订单
	 */
	public List<Order> selectOrderByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		List<Order> list = null;//定义返回的集合
		try{
			list = this.dao.selectOrderByAccount(account);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 增加订单
	 */
	public boolean insertOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectOrderByOrderId(order.getOrderId())==null){
				flag = this.dao.insertOrder(order);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 删除订单
	 */
	public boolean deleteOrderById(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectOrderByOrderId(orderId)!=null){
				flag = this.dao.deleteOrderById(orderId);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 出货
	 */
	public boolean updateOrderSign(String orderId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectOrderByOrderId(orderId)!=null){
				flag = this.dao.updateOrderSign(orderId);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}
	/*
	 * 根据配送地址查询配送数量
	 */
	public int selectOrderByAddress(String address) throws Exception {
		// TODO Auto-generated method stub
		int num = 0;
		try{
			num = this.dao.selectOrderByAddress(address);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return num;
	}

}
