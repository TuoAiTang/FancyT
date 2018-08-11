package com.py.dao;

import java.util.List;
import com.py.vo.Link;

public interface LinkDAO {
	/*
	 * ��ѯ��վ��������
	 */
	public List<Link> selectLink()throws Exception;
	/*
	 * ͨ�����ӱ�Ų�ѯ��վ��������
	 */
	public Link selectLinkById(int id)throws Exception;
	/*
	 * ������վ��������
	 */
	public boolean insertLink(Link link)throws Exception;
	/*
	 * ɾ����վ��������
	 */
	public boolean deleteLinkById(int id)throws Exception;
	/*
	 * �޸���վ��������
	 */
	public boolean updateLink(Link link)throws Exception;
}
