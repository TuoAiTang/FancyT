package com.py.dao.proxy;

import java.util.List;
import com.py.dao.SortDAO;
import com.py.dao.impl.SortDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Sort;

public class SortDAOProxy implements SortDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private SortDAO dao = null;//声明DAO对象
	public SortDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new SortDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询类别
	 */
	public List<Sort> selectSort() throws Exception {
		// TODO Auto-generated method stub
		List<Sort> list = null;//定义返回的集合
		try{
			list = this.dao.selectSort();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 通过类别编号查询类别
	 */
	public Sort selectSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;//定义对象
		try{
			sort = this.dao.selectSortBySortId(sortId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return sort;
	}
	@Override
	/*
	 * 通过类别名称查询类别
	 */
	public Sort selectSortBySortName(String sortName) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;//定义对象
		try{
			sort = this.dao.selectSortBySortName(sortName);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return sort;
	}

	@Override
	/*
	 * 增加类别
	 */
	public boolean insertSort(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectSortBySortName(sort.getSortName())==null){
				flag = this.dao.insertSort(sort);
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
	 * 删除类别
	 */
	public boolean deleteSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectSortBySortId(sortId)!=null){
				flag = this.dao.deleteSortBySortId(sortId);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

}
