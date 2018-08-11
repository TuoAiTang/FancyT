package com.py.dao;

import java.util.List;
import com.py.vo.Sort;

public interface SortDAO {
	/*
	 * 查询类别
	 */
	public List<Sort> selectSort()throws Exception;
	/*
	 * 通过类别编号查询类别
	 */
	public Sort selectSortBySortId(int sortId)throws Exception;
	/*
	 * 通过类别名称查询类别
	 */
	public Sort selectSortBySortName(String sortName)throws Exception;
	/*
	 * 增加类别
	 */
	public boolean insertSort(Sort sort)throws Exception;
	/*
	 * 删除类别
	 */
	public boolean deleteSortBySortId(int sortId)throws Exception;
}
