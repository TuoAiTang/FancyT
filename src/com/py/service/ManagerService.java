package com.py.service;

import java.util.List;

import com.py.vo.Manager;

public interface ManagerService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ����Ա��¼
	 */
	public Manager selectManagerLogin(String account,String password);
	/*
	 * ��ѯ����Ա
	 */
	public List<Manager> selectManager();
	/*
	 * ɾ������Ա
	 */
	public boolean deleteManagerByAccount(String account);
	/*
	 * ���ӹ���Ա
	 */
	public boolean insertManager(Manager manager);
	/*
	 * �޸Ĺ���Ա
	 */
	public boolean updateManager(Manager manager);
}
