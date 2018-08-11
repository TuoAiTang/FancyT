package com.py.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.ManagerService;
import com.py.vo.Manager;

public class ManagerServiceImpl implements ManagerService {
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * ����Ա��¼
	 */
	public Manager selectManagerLogin(String account, String password) {
		Manager manager = new Manager();
		if (account != null && password != null) {
			try {
				manager = DAOFactory.getManagerDAOInstance()
						.selectManagerByAccount(account);
				if (manager == null) {
					this.setResult("�����ڴ˹���Ա���������������Ա�˺ţ�");
				} else if (!manager.getPassword().equals(password)) {
					this.setResult("�������");
				} else {
					this.setResult(null);// ��¼�ɹ�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ�գ�");
		}
		return manager;
	}

	/*
	 * ��ѯ����Ա
	 */
	public List<Manager> selectManager() {
		List<Manager> list = new ArrayList<Manager>();
		try {
			list = DAOFactory.getManagerDAOInstance().selectManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * ɾ������Ա
	 */
	public boolean deleteManagerByAccount(String account) {
		boolean flag = false;
		try {
			flag = DAOFactory.getManagerDAOInstance().deleteManagerByAccount(
					account);
			if (flag) {
				this.setResult("ɾ���ɹ���");// ɾ���ɹ�
			} else {
				this.setResult("�ù���Ա�ѱ�ɾ����ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * ���ӹ���Ա
	 */
	public boolean insertManager(Manager manager) {
		boolean flag = false;
		if (manager.getAccount() != null && manager.getPassword() != null
				&& manager.getReallyName() != null && manager.getTel() != null
				&& manager.getSign() != 0) {
			try {
				flag = DAOFactory.getManagerDAOInstance()
						.insertManager(manager);
				if (flag) {
					this.setResult("ע��ɹ���");// ע��ɹ�
				} else {
					this.setResult("���û����Ѿ����ڣ�����");
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
	 * �޸Ĺ���Ա
	 */
	public boolean updateManager(Manager manager) {
		boolean flag = false;
		if (manager.getAccount() != null && manager.getPassword() != null
				&& manager.getReallyName() != null && manager.getTel() != null) {
			try {
				flag = DAOFactory.getManagerDAOInstance()
						.updateManager(manager);
				if (flag) {
					this.setResult("�޸ĳɹ�");// �޸ĳɹ�
				} else {
					this.setResult("�ù���Ա�ѱ�ɾ�����޸�ʧ�ܣ�����");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("������Ϊ��");
		}
		return flag;
	}
}
