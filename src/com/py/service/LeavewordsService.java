package com.py.service;

import java.util.List;

import com.py.vo.Leavewords;

public interface LeavewordsService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 查询用户留言
	 */
	public List<Leavewords> selectLeavewords();
	/*
	 * 通过留言编号查询用户留言信息
	 */
	public Leavewords selectLeavewordsById(int id);	
	/*
	 * 增加用户留言信息
	 */
	public boolean insertLeavewords(Leavewords leavewords);
	/*
	 * 通过留言编号删除用户留言信息
	 */
	public boolean deleteLeavewordsById(int id);
}
