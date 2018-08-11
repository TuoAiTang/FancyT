package com.py.service;

import java.util.List;

import com.py.vo.Manager;

public interface ManagerService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 管理员登录
	 */
	public Manager selectManagerLogin(String account,String password);
	/*
	 * 查询管理员
	 */
	public List<Manager> selectManager();
	/*
	 * 删除管理员
	 */
	public boolean deleteManagerByAccount(String account);
	/*
	 * 增加管理员
	 */
	public boolean insertManager(Manager manager);
	/*
	 * 修改管理员
	 */
	public boolean updateManager(Manager manager);
}
