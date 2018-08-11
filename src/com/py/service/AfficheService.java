package com.py.service;

import java.util.List;

import com.py.vo.Affiche;

public interface AfficheService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 通过公告ID查询公告信息
	 */
	public Affiche selectAfficheById(int id);
	/*
	 * 查询公告信息
	 */
	public List<Affiche> selectAffiche();
	/*
	 * 通过公告ID删除公告
	 */
	public boolean deleteAfficheById(int id);
	/*
	 * 增加公告信息
	 */
	public boolean insertAffiche(Affiche affiche);
}
