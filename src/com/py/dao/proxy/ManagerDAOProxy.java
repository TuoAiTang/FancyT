package com.py.dao.proxy;

import java.util.List;
import com.py.dao.ManagerDAO;
import com.py.dao.impl.ManagerDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Manager;

public class ManagerDAOProxy implements ManagerDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private ManagerDAO dao = null;//����DAO����
	public ManagerDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new ManagerDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ����Ա��Ϣ
	 */
	public List<Manager> selectManager() throws Exception {
		// TODO Auto-generated method stub
		List<Manager> list = null;//���巵�صļ���
		try{
			list = this.dao.selectManager();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ������Ա�˺Ų�ѯ����Ա
	 */
	public Manager selectManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Manager manager = null;//�������
		try{
			manager = this.dao.selectManagerByAccount(account);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return manager;
	}

	@Override
	/*
	 * ���ӹ���Ա
	 */
	public boolean insertManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectManagerByAccount(manager.getAccount())==null){
				flag = this.dao.insertManager(manager);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ������Ա
	 */
	public boolean deleteManagerByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectManagerByAccount(account)!=null){
				flag = this.dao.deleteManagerByAccount(account);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * �޸Ĺ���Ա
	 */
	public boolean updateManager(Manager manager) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectManagerByAccount(manager.getAccount())!=null){
				flag = this.dao.updateManager(manager);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

}
