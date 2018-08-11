package com.py.service;

import java.util.List;

import com.py.vo.Leavewords;

public interface LeavewordsService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * ��ѯ�û�����
	 */
	public List<Leavewords> selectLeavewords();
	/*
	 * ͨ�����Ա�Ų�ѯ�û�������Ϣ
	 */
	public Leavewords selectLeavewordsById(int id);	
	/*
	 * �����û�������Ϣ
	 */
	public boolean insertLeavewords(Leavewords leavewords);
	/*
	 * ͨ�����Ա��ɾ���û�������Ϣ
	 */
	public boolean deleteLeavewordsById(int id);
}
