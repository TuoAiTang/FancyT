package com.py.dao;

import java.util.List;
import com.py.vo.Leavewords;

public interface LeavewordsDAO {
	/*
	 * 查询用户留言
	 */
	public List<Leavewords> selectLeavewords()throws Exception;
	/*
	 * 通过留言编号查询用户留言
	 */
	public Leavewords selectLeavewordsById(int id)throws Exception;
	/*
	 * 通过商品编号查询用户留言
	 */
	public List<Leavewords> selectLeavewordsByGoodsId(int goodsId)throws Exception;
	/*
	 * 通过用户账号查询用户留言
	 */
	public Leavewords selectLeavewordsByAccount(String account)throws Exception;
	/*
	 * 按用户账号和用户密码查询用户留言
	 */
	public Leavewords selectLeavewords(int goodsId,String account)throws Exception;
	/*
	 * 增加用户留言
	 */
	public boolean insertLeavewords(Leavewords leavewords)throws Exception;
	/*
	 * 删除用户留言
	 */
	public boolean deleteLeavewordsById(int id)throws Exception;	
}
