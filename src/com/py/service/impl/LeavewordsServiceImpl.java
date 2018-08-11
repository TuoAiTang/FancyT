package com.py.service.impl;

import java.util.List;

import com.py.factory.DAOFactory;
import com.py.service.LeavewordsService;
import com.py.vo.Leavewords;

public class LeavewordsServiceImpl implements LeavewordsService{
	private String result = null;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	/*
	 * 查询用户留言
	 */
	public List<Leavewords> selectLeavewords() {
		List<Leavewords> list = null;
		try {
			list = DAOFactory.getLeavewordsDAOInstance().selectLeavewords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * 通过留言编号查询用户留言信息
	 */
	public Leavewords selectLeavewordsById(int id) {
		Leavewords leavewords = null;
		try {
			leavewords = DAOFactory.getLeavewordsDAOInstance()
					.selectLeavewordsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leavewords;
	}

	/*
	 * 增加用户留言信息
	 */
	public boolean insertLeavewords(Leavewords leavewords) {
		boolean flag = false;
		if(leavewords.getAccount()!=null&&leavewords.getGoodsId()!=0&&leavewords.getTitle()!=null&&leavewords.getContent()!=null){
			try {
				flag = DAOFactory.getLeavewordsDAOInstance().insertLeavewords(
						leavewords);
				if(flag){
					this.setResult("留言成功！");
				}else{
					this.setResult("留言失败！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else{
			this.setResult("表单信息为空！");
		}
		return flag;
	}

	/*
	 * 通过留言编号删除用户留言信息
	 */
	public boolean deleteLeavewordsById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getLeavewordsDAOInstance().deleteLeavewordsById(
					id);
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

}
