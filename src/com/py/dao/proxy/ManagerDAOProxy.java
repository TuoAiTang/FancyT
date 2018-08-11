package com.py.dao.proxy;

import java.util.List;
import com.py.dao.ManagerDAO;
import com.py.dao.impl.ManagerDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Manager;

public class ManagerDAOProxy implements ManagerDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private ManagerDAO dao = null;//声明DAO对象
	public ManagerDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new ManagerDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询管理员信息
	 */
	public List<Manager> selectManager() throws Exception {
		// TODO Auto-generated method stub
		List<Manager> list = null;//定义返回的集合
		try{
			list = this.dao.selectManager();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 按管理员账号查询管理员
	 */
	public Manager selectManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = null;//定义对象
		try{
			manager = this.dao.selectManagerByAccount(account);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return manager;
	}

	@Override
	/*
	 * 增加管理员
	 */
	public boolean insertManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectManagerByAccount(manager.getAccount())==null){
				flag = this.dao.insertManager(manager);
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
	 * 删除管理员
	 */
	public boolean deleteManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectManagerByAccount(account)!=null){
				flag = this.dao.deleteManagerByAccount(account);
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
	 * 修改管理员
	 */
	public boolean updateManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectManagerByAccount(manager.getAccount())!=null){
				flag = this.dao.updateManager(manager);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

}
