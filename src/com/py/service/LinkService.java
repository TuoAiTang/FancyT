package com.py.service;

import java.util.List;

import com.py.vo.Link;

public interface LinkService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ��ѯ��������
	 */
	public List<Link> selectLink();
	/*
	 * ͨ�����ɾ����������
	 */
	public boolean deleteLinkById(int id);
	/*
	 * ������������
	 */
	public boolean insertLink(Link link);
}
