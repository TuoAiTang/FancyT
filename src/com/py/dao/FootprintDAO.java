package com.py.dao;

import java.util.List;
import com.py.vo.Footprint;

public interface FootprintDAO {
	/*
	 * ��ѯ�����û������㼣
	 */
	public List<Footprint> selectAllFp()throws Exception;
	/*
	 * ��ѯָ���û������㼣
	 */
	public List<Footprint> selectAllFpByAccount(String account)throws Exception;
	/*
	 * ��ѯָ���û�����㼣
	 */	
	public List<Footprint> selectThreeFpByAccount(String account)throws Exception;
	/*
	 * �����㼣
	 */
	public boolean insertFp(Footprint fp)throws Exception;
	
}
