package com.py.dao.proxy;

import java.util.List;

import com.py.dao.FootprintDAO;
import com.py.dao.impl.FootprintDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Footprint;

public class FootprintDAOProxy implements FootprintDAO {
	private DatabaseConnection dbc = null;//�������ݿ�������
	private FootprintDAO dao = null;//����dao
	
	public FootprintDAOProxy() throws Exception{
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new FootprintDAOImpl(this.dbc.getConnection());
	}
	@Override
	/*
	 * �����û������㼣
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
	 * ָ���û������㼣
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
	 * ָ���û�����㼣
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
	 * �����㼣
	 */
	public boolean insertFp(Footprint fp) throws Exception {
		boolean flag = false;//�����־λ
		try{
			flag = this.dao.insertFp(fp);
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		
		return flag;
		
		
	}
	
}
