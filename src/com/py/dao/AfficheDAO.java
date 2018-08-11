package com.py.dao;

import java.util.List;
import com.py.vo.Affiche;

public interface AfficheDAO {
	/*
	 * ��ѯ��վ����
	 */
	public List<Affiche> selectAffiche()throws Exception;
	/*
	 * ����վ�����Ų�ѯ��վ����
	 */
	public Affiche selectAfficheById(int id)throws Exception;
	/*
	 * ������վ����
	 */
	public boolean insertAffiche(Affiche affiche)throws Exception;
	/*
	 * ɾ����վ����
	 */
	public boolean deleteAfficheById(int id)throws Exception;

}
