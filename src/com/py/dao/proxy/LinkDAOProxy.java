package com.py.dao.proxy;

import java.util.List;
import com.py.dao.LinkDAO;
import com.py.dao.impl.LinkDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Link;

public class LinkDAOProxy implements LinkDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private LinkDAO dao = null;//����DAO����
	public LinkDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new LinkDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ��վ��������
	 */
	public List<Link> selectLink() throws Exception {
		// TODO Auto-generated method stub
		List<Link> list = null;//���巵�صļ���
		try{
			list = this.dao.selectLink();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ͨ�����ӱ�Ų�ѯ��վ��������
	 */
	public Link selectLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		Link link = null;//�������
		try{
			link = this.dao.selectLinkById(id);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return link;
	}
	
	@Override
	/*
	 * ������վ��������
	 */
	public boolean insertLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectLinkById(link.getId())==null){
				flag = this.dao.insertLink(link);
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
	 * ɾ����վ��������
	 */
	public boolean deleteLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectLinkById(id)!=null){
				flag = this.dao.deleteLinkById(id);
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
	 * �޸���վ��������
	 */
	public boolean updateLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectLinkById(link.getId())!=null){
				flag = this.dao.updateLink(link);
			}

		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}	
}
