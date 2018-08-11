package com.py.dao.proxy;

import java.util.List;
import com.py.dao.SortDAO;
import com.py.dao.impl.SortDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Sort;

public class SortDAOProxy implements SortDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private SortDAO dao = null;//����DAO����
	public SortDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new SortDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ���
	 */
	public List<Sort> selectSort() throws Exception {
		// TODO Auto-generated method stub
		List<Sort> list = null;//���巵�صļ���
		try{
			list = this.dao.selectSort();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ͨ������Ų�ѯ���
	 */
	public Sort selectSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;//�������
		try{
			sort = this.dao.selectSortBySortId(sortId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return sort;
	}
	@Override
	/*
	 * ͨ��������Ʋ�ѯ���
	 */
	public Sort selectSortBySortName(String sortName) throws Exception {
		// TODO Auto-generated method stub
		Sort sort = null;//�������
		try{
			sort = this.dao.selectSortBySortName(sortName);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return sort;
	}

	@Override
	/*
	 * �������
	 */
	public boolean insertSort(Sort sort) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectSortBySortName(sort.getSortName())==null){
				flag = this.dao.insertSort(sort);
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
	 * ɾ�����
	 */
	public boolean deleteSortBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectSortBySortId(sortId)!=null){
				flag = this.dao.deleteSortBySortId(sortId);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

}
