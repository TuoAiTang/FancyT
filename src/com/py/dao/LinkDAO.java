package com.py.dao;

import java.util.List;
import com.py.vo.Link;

public interface LinkDAO {
	/*
	 * 查询网站友情链接
	 */
	public List<Link> selectLink()throws Exception;
	/*
	 * 通过链接编号查询网站友情链接
	 */
	public Link selectLinkById(int id)throws Exception;
	/*
	 * 增加网站友情链接
	 */
	public boolean insertLink(Link link)throws Exception;
	/*
	 * 删除网站友情链接
	 */
	public boolean deleteLinkById(int id)throws Exception;
	/*
	 * 修改网站友情链接
	 */
	public boolean updateLink(Link link)throws Exception;
}
