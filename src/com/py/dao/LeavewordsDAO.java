package com.py.dao;

import java.util.List;
import com.py.vo.Leavewords;

public interface LeavewordsDAO {
	/*
	 * ��ѯ�û�����
	 */
	public List<Leavewords> selectLeavewords()throws Exception;
	/*
	 * ͨ�����Ա�Ų�ѯ�û�����
	 */
	public Leavewords selectLeavewordsById(int id)throws Exception;
	/*
	 * ͨ����Ʒ��Ų�ѯ�û�����
	 */
	public List<Leavewords> selectLeavewordsByGoodsId(int goodsId)throws Exception;
	/*
	 * ͨ���û��˺Ų�ѯ�û�����
	 */
	public Leavewords selectLeavewordsByAccount(String account)throws Exception;
	/*
	 * ���û��˺ź��û������ѯ�û�����
	 */
	public Leavewords selectLeavewords(int goodsId,String account)throws Exception;
	/*
	 * �����û�����
	 */
	public boolean insertLeavewords(Leavewords leavewords)throws Exception;
	/*
	 * ɾ���û�����
	 */
	public boolean deleteLeavewordsById(int id)throws Exception;	
}
