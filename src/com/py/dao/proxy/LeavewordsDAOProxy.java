package com.py.dao.proxy;

import java.util.List;
import com.py.dao.LeavewordsDAO;
import com.py.dao.impl.LeavewordsDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Leavewords;

public class LeavewordsDAOProxy implements LeavewordsDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private LeavewordsDAO dao = null;//声明DAO对象
	public LeavewordsDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new LeavewordsDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询用户留言
	 */
	public List<Leavewords> selectLeavewords() throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list = null;//定义返回的集合
		try{
			list = this.dao.selectLeavewords();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	
	@Override
	/*
	 * 通过留言编号查询用户留言
	 */
	public Leavewords selectLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//定义对象
		try{
			leavewords = this.dao.selectLeavewordsById(id);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return leavewords;
	}
	@Override
	/*
	 * 通过商品编号查询用户留言
	 */
	public List<Leavewords> selectLeavewordsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list= null;//定义返回的集合
		try{
			list = this.dao.selectLeavewordsByGoodsId(goodsId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	@Override
	/*
	 * 通过用户账号查询用户留言
	 */
	public Leavewords selectLeavewordsByAccount(String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//定义对象
		try{
			leavewords = this.dao.selectLeavewordsByAccount(account);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return leavewords;
	}
	@Override
	/*
	 * 按用户账号和用户密码查询用户留言
	 */
	public Leavewords selectLeavewords(int goodsId, String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//定义对象
		try{
			leavewords = this.dao.selectLeavewords(goodsId,account);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return leavewords;
	}

	@Override
	/*
	 * 增加用户留言
	 */
	public boolean insertLeavewords(Leavewords leavewords) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			flag = this.dao.insertLeavewords(leavewords);
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 删除用户留言
	 */
	public boolean deleteLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectLeavewordsById(id)!=null){
				flag = this.dao.deleteLeavewordsById(id);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}
	
	
}
