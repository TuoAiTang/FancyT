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
	 * ��ѯ�û�����
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
	 * ͨ�����Ա�Ų�ѯ�û�������Ϣ
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
	 * �����û�������Ϣ
	 */
	public boolean insertLeavewords(Leavewords leavewords) {
		boolean flag = false;
		if(leavewords.getAccount()!=null&&leavewords.getGoodsId()!=0&&leavewords.getTitle()!=null&&leavewords.getContent()!=null){
			try {
				flag = DAOFactory.getLeavewordsDAOInstance().insertLeavewords(
						leavewords);
				if(flag){
					this.setResult("���Գɹ���");
				}else{
					this.setResult("����ʧ�ܣ�");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else{
			this.setResult("����ϢΪ�գ�");
		}
		return flag;
	}

	/*
	 * ͨ�����Ա��ɾ���û�������Ϣ
	 */
	public boolean deleteLeavewordsById(int id) {
		boolean flag = false;
		try {
			flag = DAOFactory.getLeavewordsDAOInstance().deleteLeavewordsById(
					id);
			if(flag){
				this.setResult("ɾ���ɹ���");
			}else{
				this.setResult("ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}

}
