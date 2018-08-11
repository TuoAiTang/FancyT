package com.py.service;

import java.util.List;

import com.py.vo.Link;

public interface LinkService {
	/*
	 * 设置result的getter与setter方法
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * 查询友情链接
	 */
	public List<Link> selectLink();
	/*
	 * 通过编号删除友情链接
	 */
	public boolean deleteLinkById(int id);
	/*
	 * 增加友情链接
	 */
	public boolean insertLink(Link link);
}
