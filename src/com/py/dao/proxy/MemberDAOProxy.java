package com.py.dao.proxy;

import java.util.List;
import com.py.dao.MemberDAO;
import com.py.dao.impl.MemberDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Member;

public class MemberDAOProxy implements MemberDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private MemberDAO dao = null;//声明DAO对象
	public MemberDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new MemberDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 *通过会员账号查询用户
	 */
	public Member selectMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Member member = null;//定义对象
		try{
			member = this.dao.selectMemberByAccount(account);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return member;
	}

	@Override
	/*
	 *查询所有会员 
	 */
	public List<Member> selectMember() throws Exception {
		// TODO Auto-generated method stub
		List<Member> list = null;//定义返回的集合
		try{
			list = this.dao.selectMember();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 增加会员
	 */
	public boolean insertMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectMemberByAccount(member.getAccount())==null){//判断数据库中是否存在该会员账号
				flag = this.dao.insertMember(member);//调用真实实现类
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	 /*
	  * 删除会员
	  */
	public boolean deleteMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectMemberByAccount(account)!=null){//判断数据库中是否存在该会员账号
				flag = this.dao.deleteMemberByAccount(account);//调用真实实现类
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}

	@Override
	/*
	 * 修改会员信息
	 */
	public boolean updateMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectMemberByAccount(member.getAccount())!=null){
				flag = this.dao.updateMember(member);//调用真实实现类
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}
}
