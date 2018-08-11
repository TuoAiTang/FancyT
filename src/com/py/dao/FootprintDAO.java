package com.py.dao;

import java.util.List;
import com.py.vo.Footprint;

public interface FootprintDAO {
	/*
	 * 查询所有用户所有足迹
	 */
	public List<Footprint> selectAllFp()throws Exception;
	/*
	 * 查询指定用户所有足迹
	 */
	public List<Footprint> selectAllFpByAccount(String account)throws Exception;
	/*
	 * 查询指定用户最近足迹
	 */	
	public List<Footprint> selectThreeFpByAccount(String account)throws Exception;
	/*
	 * 插入足迹
	 */
	public boolean insertFp(Footprint fp)throws Exception;
	
}
