package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.AfficheService;
import com.py.vo.Affiche;

public class AfficheServiceImpl implements AfficheService {
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * ͨ������ID��ѯ������Ϣ
	 */
	public Affiche selectAfficheById(int id) {
		Affiche affiche = null;
		try {
			affiche = DAOFactory.getAfficheDAOInstance().selectAfficheById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affiche;
	}

	/*
	 * ��ѯ������Ϣ
	 */
	public List<Affiche> selectAffiche() {
		List<Affiche> list = null;
		try {
			list = DAOFactory.getAfficheDAOInstance().selectAffiche();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ͨ������IDɾ������
	 */
	public boolean deleteAfficheById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getAfficheDAOInstance().deleteAfficheById(id);
			if (flag) {
				this.setResult("ɾ���ɹ���");// ɾ���ɹ�
			} else {
				this.setResult("ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * ���ӹ�����Ϣ
	 */
	public boolean insertAffiche(Affiche affiche) {
		boolean flag = false;
		if (affiche.getAffiche() != null && affiche.getContent() != null) {
			try {
				flag = DAOFactory.getAfficheDAOInstance()
						.insertAffiche(affiche);
				if (flag) {
					this.setResult("���ӳɹ���");// ɾ���ɹ�
				} else {
					this.setResult("����ʧ�ܣ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return flag;
	}
}
