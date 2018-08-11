package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.LinkService;
import com.py.vo.Link;

public class LinkServiceImpl implements LinkService{
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	/*
	 * 查询友情链接
	 */
	public List<Link> selectLink() {
		List<Link> list = null;
		try {
			list = DAOFactory.getLinkDAOInstance().selectLink();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 通过编号删除友情链接
	 */
	public boolean deleteLinkById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getLinkDAOInstance().deleteLinkById(id);
			if(flag){
				this.setResult("删除成功！");
			}else{
				this.setResult("删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/*
	 * 增加友情链接
	 */
	public boolean insertLink(Link link) {
		boolean flag = false;
		if(link.getLinkName()!=null&&link.getLinkAddress()!=null){
			try {
				flag = DAOFactory.getLinkDAOInstance().insertLink(link);
				if(flag){
					this.setResult("增加成功！");
				}else{
					this.setResult("增加失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.setResult("表单不能为空！");
		}
		return false;
	}

}
