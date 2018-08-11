package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.MemberDAO;
import com.py.vo.Member;

public class MemberDAOImpl implements MemberDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement ps = null;// 定义数据库操作对象

	public MemberDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	@Override
	/*
	 * 通过会员账号查询用户
	 */
	public Member selectMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		Member member = null;//声明Member对象
		String sql = "SELECT * FROM tb_member WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象
		this.ps.setString(1, account);//设置会员账号
		ResultSet rs = this.ps.executeQuery();//执行查询操作
		if(rs.next()){
			member = new Member();//实例化Member对象
			member.setAccount(rs.getString(1));//设置account内容
			member.setPassword(rs.getString(2));//设置password内容
			member.setReallyName(rs.getString(3));//设置reallyName内容
			member.setEmail(rs.getString(4));//设置email内容
			member.setTel(rs.getString(5));//设置tel内容
			member.setIdCard(rs.getString(6));//设置idCard内容
			member.setIntergrate(rs.getInt(7));//设置积分
		}
		this.ps.close();//关闭PreparedStatement操作
		return member;//如果查询不到结果则返回null
	}


	@Override
	/*
	 * 查询所有会员
	 */
	public List<Member> selectMember() throws Exception {
		List<Member> list = new ArrayList<Member>();//定义集合
		String sql = "SELECT * FROM tb_member order by intergrate desc";//实例化PreparedStatement对象
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();//执行查询操作
		Member member = null;//声明Member对象
		while(rs.next()){//依次取出全部数据
			member = new Member();
			member.setAccount(rs.getString(1));//设置account内容
			member.setPassword(rs.getString(2));//设置password内容
			member.setReallyName(rs.getString(3));//设置reallyName内容
			member.setEmail(rs.getString(4));//设置email内容
			member.setTel(rs.getString(5));//设置tel内容
			member.setIdCard(rs.getString(6));//设置idCard内容
			member.setIntergrate(rs.getInt(7));//设置积分
			list.add(member);
		}
		this.ps.close();//关闭PreparedStatement操作
		return list;//返回集合
    }


	@Override
	/*
	 * 增加会员
	 */
	public boolean insertMember(Member member) throws Exception {
		boolean flag = false;//定义标识符
		String sql = "INSERT INTO tb_member VALUES(?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象			
		this.ps.setString(1,member.getAccount());//设置account内容
		this.ps.setString(2,member.getPassword());//设置password内容
		this.ps.setString(3,member.getReallyName());//设置reallyName内容
		this.ps.setString(4,member.getEmail());//设置email内容
		this.ps.setString(5,member.getTel());//设置tel内容
		this.ps.setString(6,member.getIdCard());//设置idCard内容
		this.ps.setInt(7,0);//设置初始积分为0
		if(this.ps.executeUpdate()>0){//执行插入操作
			flag = true;//插入成功则将标识符变为true
		}
		this.ps.close();//关闭PreparedStatement操作
		return flag;//返回标识符
	}


	@Override
	/*
	 * 删除会员
	 */
	public boolean deleteMemberByAccount(String account) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_member WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, account);
		if(this.ps.executeUpdate()>0){//数据库发生更新
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 修改会员信息
	 */
	public boolean updateMember(Member member) throws Exception {
		boolean flag = false;//定义标识符
		String sql = "UPDATE tb_member SET password=?,reallyName=?,email=?,tel=?,idCard=?,intergrate=? WHERE account=?";
		this.ps = this.conn.prepareStatement(sql);//实例化PreparedStatement对象	
		//this.ps.setString(1,member.getAccount());//设置account内容
		this.ps.setString(1,member.getPassword());//设置password内容
		this.ps.setString(2,member.getReallyName());//设置reallyName内容
		this.ps.setString(3,member.getEmail());//设置email内容
		this.ps.setString(4,member.getTel());//设置tel内容
		this.ps.setString(5,member.getIdCard());//设置idCard内容
		this.ps.setInt(6, member.getIntergrate());//设置积分
		this.ps.setString(7,member.getAccount());//设置用户名
		if(this.ps.executeUpdate()>0){//执行插入操作
			flag = true;//插入成功则将标识符变为true
		}
		this.ps.close();//关闭PreparedStatement操作
		return flag;//返回标识符
	}


}
