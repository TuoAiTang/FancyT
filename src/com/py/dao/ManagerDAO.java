package com.py.dao;

import java.util.List;
import com.py.vo.Manager;

public interface ManagerDAO {
	/*
	 * 查询管理员信息
	 */
	public List<Manager> selectManager()throws Exception;
	/*
	 * 按管理员账号查询管理员
	 */
	public Manager selectManagerByAccount(String account)throws Exception;
	/*
	 * 增加管理员
	 */
	public boolean insertManager(Manager manager)throws Exception;
	/*
	 * 删除管理员
	 */
	public boolean deleteManagerByAccount(String account)throws Exception;
	/*
	 * 修改管理员
	 */
	public boolean updateManager(Manager manager)throws Exception;

}
