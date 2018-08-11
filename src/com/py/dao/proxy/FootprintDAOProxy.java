package com.py.dao.proxy;

import java.util.List;

import com.py.dao.FootprintDAO;
import com.py.dao.impl.FootprintDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Footprint;

public class FootprintDAOProxy implements FootprintDAO {
	private DatabaseConnection dbc = null;//定义数据库连接类
	private FootprintDAO dao = null;//定义dao
	
	public FootprintDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new FootprintDAOImpl(this.dbc.getConnection());
	}
	@Override
	/*
	 * 所有用户所有足迹
	 */
	public List<Footprint> selectAllFp() throws Exception {
		List<Footprint> list = null;
		try {
			list = this.dao.selectAllFp();
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	/*
	 * 指定用户所有足迹
	 */
	public List<Footprint> selectAllFpByAccount(String account) throws Exception {
		List<Footprint> list = null;
		try {
			list = this.dao.selectAllFpByAccount(account);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	/*
	 * 指定用户最近足迹
	 */
	public List<Footprint> selectThreeFpByAccount(String account) throws Exception {
		List<Footprint> list = null;
		try {
			list = this.dao.selectThreeFpByAccount(account);
		}catch(Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		return list;
	}

	@Override
	/*
	 * 插入足迹
	 */
	public boolean insertFp(Footprint fp) throws Exception {
		boolean flag = false;//定义标志位
		try{
			flag = this.dao.insertFp(fp);
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		
		return flag;
		
		
	}
	
}
