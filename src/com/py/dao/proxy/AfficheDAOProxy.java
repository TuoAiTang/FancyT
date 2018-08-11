package com.py.dao.proxy;

import java.util.List;
import com.py.dao.AfficheDAO;
import com.py.dao.impl.AfficheDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Affiche;

public class AfficheDAOProxy implements AfficheDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private AfficheDAO dao = null;//����DAO����
	public AfficheDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new AfficheDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ��վ����
	 */
	public List<Affiche> selectAffiche() throws Exception {
		// TODO Auto-generated method stub
		List<Affiche> list = null;//���巵�صļ���
		try{
			list = this.dao.selectAffiche();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ����վ�����Ų�ѯ��վ����
	 */
	public Affiche selectAfficheById(int id) throws Exception {
		// TODO Auto-generated method stub
		Affiche affiche = null;//�������
		try{
			affiche = this.dao.selectAfficheById(id);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return affiche;
	}

	@Override
	/*
	 * ������վ����
	 */
	public boolean insertAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			flag = this.dao.insertAffiche(affiche);
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ����վ����
	 */
	public boolean deleteAfficheById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectAfficheById(id)!=null){
				flag = this.dao.deleteAfficheById(id);//������ʵʵ����
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

}
