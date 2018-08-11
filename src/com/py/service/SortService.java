package com.py.service;

import java.util.List;

import com.py.vo.Sort;

public interface SortService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ��ѯ�����Ϣ
	 */
	public List<Sort> selectSort();
	/*
	 * �½����
	 */
	public boolean insertSort(Sort sort);
	/*
	 * ͨ�������ɾ�����
	 */
	public boolean deleteSortBySortId(int sortId);
}
