package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.LinkService;
import com.py.vo.Link;

public class LinkServiceImpl implements LinkService{
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	/*
	 * ��ѯ��������
	 */
	public List<Link> selectLink() {
		List<Link> list = null;
		try {
			list = DAOFactory.getLinkDAOInstance().selectLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ͨ�����ɾ����������
	 */
	public boolean deleteLinkById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getLinkDAOInstance().deleteLinkById(id);
			if(flag){
				this.setResult("ɾ���ɹ���");
			}else{
				this.setResult("ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * ������������
	 */
	public boolean insertLink(Link link) {
		boolean flag = false;
		if(link.getLinkName()!=null&&link.getLinkAddress()!=null){
			try {
				flag = DAOFactory.getLinkDAOInstance().insertLink(link);
				if(flag){
					this.setResult("���ӳɹ���");
				}else{
					this.setResult("����ʧ�ܣ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.setResult("������Ϊ�գ�");
		}
		return false;
	}

}
