package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.AfficheService;
import com.py.vo.Affiche;

public class AfficheServiceImpl implements AfficheService {
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/*
	 * 通过公告ID查询公告信息
	 */
	public Affiche selectAfficheById(int id) {
		Affiche affiche = null;
		try {
			affiche = DAOFactory.getAfficheDAOInstance().selectAfficheById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affiche;
	}

	/*
	 * 查询公告信息
	 */
	public List<Affiche> selectAffiche() {
		List<Affiche> list = null;
		try {
			list = DAOFactory.getAfficheDAOInstance().selectAffiche();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 通过公告ID删除公告
	 */
	public boolean deleteAfficheById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getAfficheDAOInstance().deleteAfficheById(id);
			if (flag) {
				this.setResult("删除成功！");// 删除成功
			} else {
				this.setResult("删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 增加公告信息
	 */
	public boolean insertAffiche(Affiche affiche) {
		boolean flag = false;
		if (affiche.getAffiche() != null && affiche.getContent() != null) {
			try {
				flag = DAOFactory.getAfficheDAOInstance()
						.insertAffiche(affiche);
				if (flag) {
					this.setResult("增加成功！");// 删除成功
				} else {
					this.setResult("增加失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setResult("表单不能为空！");
		}
		return flag;
	}
}
