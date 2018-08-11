package com.py.dao.proxy;

import java.util.List;
import com.py.dao.AfficheDAO;
import com.py.dao.impl.AfficheDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Affiche;

public class AfficheDAOProxy implements AfficheDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private AfficheDAO dao = null;//声明DAO对象
	public AfficheDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new AfficheDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询网站公告
	 */
	public List<Affiche> selectAffiche() throws Exception {
		// TODO Auto-generated method stub
		List<Affiche> list = null;//定义返回的集合
		try{
			list = this.dao.selectAffiche();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 按网站公告编号查询网站公告
	 */
	public Affiche selectAfficheById(int id) throws Exception {
		// TODO Auto-generated method stub
		Affiche affiche = null;//定义对象
		try{
			affiche = this.dao.selectAfficheById(id);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return affiche;
	}

	@Override
	/*
	 * 增加网站公告
	 */
	public boolean insertAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			flag = this.dao.insertAffiche(affiche);
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 删除网站公告
	 */
	public boolean deleteAfficheById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectAfficheById(id)!=null){
				flag = this.dao.deleteAfficheById(id);//调用真实实现类
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

}
