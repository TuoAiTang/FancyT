package com.py.dao.proxy;

import java.util.List;
import com.py.dao.LinkDAO;
import com.py.dao.impl.LinkDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Link;

public class LinkDAOProxy implements LinkDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private LinkDAO dao = null;//声明DAO对象
	public LinkDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new LinkDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询网站友情链接
	 */
	public List<Link> selectLink() throws Exception {
		// TODO Auto-generated method stub
		List<Link> list = null;//定义返回的集合
		try{
			list = this.dao.selectLink();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 通过链接编号查询网站友情链接
	 */
	public Link selectLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		Link link = null;//定义对象
		try{
			link = this.dao.selectLinkById(id);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return link;
	}
	
	@Override
	/*
	 * 增加网站友情链接
	 */
	public boolean insertLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectLinkById(link.getId())==null){
				flag = this.dao.insertLink(link);
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
	 * 删除网站友情链接
	 */
	public boolean deleteLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectLinkById(id)!=null){
				flag = this.dao.deleteLinkById(id);
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
	 * 修改网站友情链接
	 */
	public boolean updateLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectLinkById(link.getId())!=null){
				flag = this.dao.updateLink(link);
			}

		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}	
}
