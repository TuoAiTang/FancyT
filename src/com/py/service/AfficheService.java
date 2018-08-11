package com.py.service;

import java.util.List;

import com.py.vo.Affiche;

public interface AfficheService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ͨ������ID��ѯ������Ϣ
	 */
	public Affiche selectAfficheById(int id);
	/*
	 * ��ѯ������Ϣ
	 */
	public List<Affiche> selectAffiche();
	/*
	 * ͨ������IDɾ������
	 */
	public boolean deleteAfficheById(int id);
	/*
	 * ���ӹ�����Ϣ
	 */
	public boolean insertAffiche(Affiche affiche);
}
