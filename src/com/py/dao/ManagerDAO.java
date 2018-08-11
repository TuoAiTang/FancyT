package com.py.dao;

import java.util.List;
import com.py.vo.Manager;

public interface ManagerDAO {
	/*
	 * ��ѯ����Ա��Ϣ
	 */
	public List<Manager> selectManager()throws Exception;
	/*
	 * ������Ա�˺Ų�ѯ����Ա
	 */
	public Manager selectManagerByAccount(String account)throws Exception;
	/*
	 * ���ӹ���Ա
	 */
	public boolean insertManager(Manager manager)throws Exception;
	/*
	 * ɾ������Ա
	 */
	public boolean deleteManagerByAccount(String account)throws Exception;
	/*
	 * �޸Ĺ���Ա
	 */
	public boolean updateManager(Manager manager)throws Exception;

}
