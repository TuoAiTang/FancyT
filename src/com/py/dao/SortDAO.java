package com.py.dao;

import java.util.List;
import com.py.vo.Sort;

public interface SortDAO {
	/*
	 * ��ѯ���
	 */
	public List<Sort> selectSort()throws Exception;
	/*
	 * ͨ������Ų�ѯ���
	 */
	public Sort selectSortBySortId(int sortId)throws Exception;
	/*
	 * ͨ��������Ʋ�ѯ���
	 */
	public Sort selectSortBySortName(String sortName)throws Exception;
	/*
	 * �������
	 */
	public boolean insertSort(Sort sort)throws Exception;
	/*
	 * ɾ�����
	 */
	public boolean deleteSortBySortId(int sortId)throws Exception;
}
