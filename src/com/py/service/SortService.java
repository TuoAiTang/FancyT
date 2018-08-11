package com.py.service;

import java.util.List;

import com.py.vo.Sort;

public interface SortService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 查询类别信息
	 */
	public List<Sort> selectSort();
	/*
	 * 新建类别
	 */
	public boolean insertSort(Sort sort);
	/*
	 * 通过类别编号删除类别
	 */
	public boolean deleteSortBySortId(int sortId);
}
