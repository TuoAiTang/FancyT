package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.SortService;
import com.py.vo.Sort;

public class SortServiceImpl implements SortService {
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * ��ѯ�����Ϣ
	 */
	public List<Sort> selectSort() {
		List<Sort> list = null;
		try {
			list = DAOFactory.getSortDAOInstance().selectSort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * �½����
	 */
	public boolean insertSort(Sort sort) {
		boolean flag = false;
		if (sort.getSortName() != null) {
			try {
				flag = DAOFactory.getSortDAOInstance().insertSort(sort);
				if (flag) {
					this.setResult("�½����ɹ���");
				} else {
					this.setResult("��������ظ����½����ʧ�ܣ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return flag;
	}

	/*
	 * ͨ�������ɾ�����
	 */
	public boolean deleteSortBySortId(int sortId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getSortDAOInstance().deleteSortBySortId(sortId);
			if (flag) {
				this.setResult("ɾ���ɹ���");
			} else {
				this.setResult("����𲻴��ڣ������Ϣɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
