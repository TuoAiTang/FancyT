package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.LinkDAO;
import com.py.vo.Link;

public class LinkDAOImpl implements LinkDAO{
	private Connection conn = null;// �������ݿ����Ӷ���
	private PreparedStatement ps = null;// �������ݿ��������
	public LinkDAOImpl(Connection conn) {// �������ݿ�����
		this.conn = conn;
	}
	@Override
	/*
	 * ��ѯ��վ��������
	 */
	public List<Link> selectLink() throws Exception {
		// TODO Auto-generated method stub
		List<Link> list = new ArrayList<Link>();
		String sql = "SELECT * FROM tb_link ORDER BY id ASC";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Link link = null;
		while(rs.next()){
			link = new Link();
			link.setId(rs.getInt(1));
			link.setLinkName(rs.getString(2));
			link.setLinkAddress(rs.getString(3));
			list.add(link);
		}
		this.ps.close();
		return list;
	}
	
	@Override
	/*
	 * ͨ�����ӱ�Ų�ѯ��վ��������
	 */
	public Link selectLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_link WHERE id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		ResultSet rs = this.ps.executeQuery();
		Link link = null;
		while(rs.next()){
			link = new Link();
			link.setId(rs.getInt(1));
			link.setLinkName(rs.getString(2));
			link.setLinkAddress(rs.getString(3));
		}
		this.ps.close();
		return link;
	}
	
	@Override
	/*
	 * ������վ��������
	 */
	public boolean insertLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_link(linkName,linkAddress) VALUES(?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1,link.getLinkName());
		this.ps.setString(2,link.getLinkAddress());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * ɾ����վ��������
	 */
	public boolean deleteLinkById(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_link WHERE id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, id);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * �޸���վ��������
	 */
	public boolean updateLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "UPDATE tb_link(linkName,linkAddress) SET linkName=?,linkAddress=? WHERE id=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, link.getLinkName());
		this.ps.setString(2, link.getLinkAddress());
		this.ps.setInt(3, link.getId());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
	

}
