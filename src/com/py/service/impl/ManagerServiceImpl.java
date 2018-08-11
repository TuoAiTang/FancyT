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
	 * 管理员登录
	 */
	public Manager selectManagerLogin(String account, String password) {
		Manager manager = new Manager();
		if (account != null && password != null) {
			try {
				manager = DAOFactory.getManagerDAOInstance()
						.selectManagerByAccount(account);
				if (manager == null) {
					this.setResult("不存在此管理员，请重新输入管理员账号！");
				} else if (!manager.getPassword().equals(password)) {
					this.setResult("密码错误！");
				} else {
					this.setResult(null);// 登录成功
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return manager;
	}

	/*
	 * 查询管理员
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
	 * 删除管理员
	 */
	public boolean deleteManagerByAccount(String account) {
		boolean flag = false;
		try {
			flag = DAOFactory.getManagerDAOInstance().deleteManagerByAccount(
					account);
			if (flag) {
				this.setResult("删除成功！");// 删除成功
			} else {
				this.setResult("该管理员已被删除，删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 增加管理员
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
					this.setResult("注册成功！");// 注册成功
				} else {
					this.setResult("此用户名已经存在！！！");
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
	 * 修改管理员
	 */
	public boolean updateManager(Manager manager) {
		boolean flag = false;
		if (manager.getAccount() != null && manager.getPassword() != null
				&& manager.getReallyName() != null && manager.getTel() != null) {
			try {
				flag = DAOFactory.getManagerDAOInstance()
						.updateManager(manager);
				if (flag) {
					this.setResult("修改成功");// 修改成功
				} else {
					this.setResult("该管理员已被删除，修改失败！！！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空");
		}
		return flag;
	}
}
