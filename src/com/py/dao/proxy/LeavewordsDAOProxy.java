package com.py.dao.proxy;

import java.util.List;
import com.py.dao.LeavewordsDAO;
import com.py.dao.impl.LeavewordsDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Leavewords;

public class LeavewordsDAOProxy implements LeavewordsDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private LeavewordsDAO dao = null;//����DAO����
	public LeavewordsDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new LeavewordsDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ�û�����
	 */
	public List<Leavewords> selectLeavewords() throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list = null;//���巵�صļ���
		try{
			list = this.dao.selectLeavewords();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	
	@Override
	/*
	 * ͨ�����Ա�Ų�ѯ�û�����
	 */
	public Leavewords selectLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//�������
		try{
			leavewords = this.dao.selectLeavewordsById(id);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return leavewords;
	}
	@Override
	/*
	 * ͨ����Ʒ��Ų�ѯ�û�����
	 */
	public List<Leavewords> selectLeavewordsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		List<Leavewords> list= null;//���巵�صļ���
		try{
			list = this.dao.selectLeavewordsByGoodsId(goodsId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	@Override
	/*
	 * ͨ���û��˺Ų�ѯ�û�����
	 */
	public Leavewords selectLeavewordsByAccount(String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//�������
		try{
			leavewords = this.dao.selectLeavewordsByAccount(account);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return leavewords;
	}
	@Override
	/*
	 * ���û��˺ź��û������ѯ�û�����
	 */
	public Leavewords selectLeavewords(int goodsId, String account)
			throws Exception {
		// TODO Auto-generated method stub
		Leavewords leavewords = null;//�������
		try{
			leavewords = this.dao.selectLeavewords(goodsId,account);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return leavewords;
	}

	@Override
	/*
	 * �����û�����
	 */
	public boolean insertLeavewords(Leavewords leavewords) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			flag = this.dao.insertLeavewords(leavewords);
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ���û�����
	 */
	public boolean deleteLeavewordsById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectLeavewordsById(id)!=null){
				flag = this.dao.deleteLeavewordsById(id);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}
	
	
}
