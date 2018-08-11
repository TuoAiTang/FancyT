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
	 * 查询类别信息
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
	 * 新建类别
	 */
	public boolean insertSort(Sort sort) {
		boolean flag = false;
		if (sort.getSortName() != null) {
			try {
				flag = DAOFactory.getSortDAOInstance().insertSort(sort);
				if (flag) {
					this.setResult("新建类别成功！");
				} else {
					this.setResult("类别名称重复，新建类别失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return flag;
	}

	/*
	 * 通过类别编号删除类别
	 */
	public boolean deleteSortBySortId(int sortId) {
		boolean flag = false;
		try {
			flag = DAOFactory.getSortDAOInstance().deleteSortBySortId(sortId);
			if (flag) {
				this.setResult("删除成功！");
			} else {
				this.setResult("该类别不存在，类别信息删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
