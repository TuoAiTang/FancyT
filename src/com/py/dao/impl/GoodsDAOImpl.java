package com.py.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.py.dao.GoodsDAO;
import com.py.vo.Goods;

public class GoodsDAOImpl implements GoodsDAO{
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement ps = null;// 定义数据库操作对象
	public GoodsDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}
	@Override
	/*
	 * 查询所有商品
	 */
	public List<Goods> selectGoods() throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM tb_goods ORDER BY goodsId DESC";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		Goods goods = null;
		while(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setSortId(rs.getInt(2));
			goods.setTshirtName(rs.getString(3));
			goods.setIntroduce(rs.getString(4));
			goods.setBrands(rs.getString(5));
			goods.setPublishdate(rs.getString(6));
			goods.setNowprice(rs.getFloat(7));
			goods.setFreeprice(rs.getFloat(8));
			goods.setPicture(rs.getString(9));
			goods.setMark(rs.getInt(10));			
			list.add(goods);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * 按商品编号查询商品
	 */
	public Goods selectGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		Goods goods = null;
		String sql = "SELECT * FROM tb_goods WHERE goodsId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, goodsId);
		ResultSet rs = this.ps.executeQuery();
		if(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setSortId(rs.getInt(2));
			goods.setTshirtName(rs.getString(3));
			goods.setIntroduce(rs.getString(4));
			goods.setBrands(rs.getString(5));
			goods.setPublishdate(rs.getString(6));
			goods.setNowprice(rs.getFloat(7));
			goods.setFreeprice(rs.getFloat(8));
			goods.setPicture(rs.getString(9));
			goods.setMark(rs.getInt(10));			
		}
		this.ps.close();
		return goods;
	}

	@Override
	/*
	 * 按类别编号查询商品
	 */
	public List<Goods> selectGoodsBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM tb_goods WHERE sortId=? ORDER BY goodsId DESC";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, sortId);
		ResultSet rs = this.ps.executeQuery();
		Goods goods = null;
		while(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setSortId(rs.getInt(2));
			goods.setTshirtName(rs.getString(3));
			goods.setIntroduce(rs.getString(4));
			goods.setBrands(rs.getString(5));
			goods.setPublishdate(rs.getString(6));
			goods.setNowprice(rs.getFloat(7));
			goods.setFreeprice(rs.getFloat(8));
			goods.setPicture(rs.getString(9));
			goods.setMark(rs.getInt(10));			
			list.add(goods);
		}
		this.ps.close();
		return list;
	}

	@Override
	/*
	 * 按特价标识查询商品
	 */
	public List<Goods> selectGoodsByMark(int mark) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM tb_goods WHERE mark=? ORDER BY goodsId DESC";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, mark);
		ResultSet rs = this.ps.executeQuery();
		Goods goods = null;
		while(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setSortId(rs.getInt(2));
			goods.setTshirtName(rs.getString(3));
			goods.setIntroduce(rs.getString(4));
			goods.setBrands(rs.getString(5));
			goods.setPublishdate(rs.getString(6));
			goods.setNowprice(rs.getFloat(7));
			goods.setFreeprice(rs.getFloat(8));
			goods.setPicture(rs.getString(9));
			goods.setMark(rs.getInt(10));
			list.add(goods);
		}
		this.ps.close();
		return list;
	}
	@Override
	/*
	 * 按关键字查询商品
	 */
	public List<Goods> selectKeywords(String keywords) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = new ArrayList<Goods>();
		String sql = "SELECT * FROM tb_goods WHERE tshirtName LIKE ? OR brands LIKE ? ORDER BY goodsId DESC";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setString(1, "%"+keywords+"%");
		this.ps.setString(2, "%"+keywords+"%");
		ResultSet rs = this.ps.executeQuery();
		Goods goods = null;
		while(rs.next()){
			goods = new Goods();
			goods.setGoodsId(rs.getInt(1));
			goods.setSortId(rs.getInt(2));
			goods.setTshirtName(rs.getString(3));
			goods.setIntroduce(rs.getString(4));
			goods.setBrands(rs.getString(5));
			goods.setPublishdate(rs.getString(6));
			goods.setNowprice(rs.getFloat(7));
			goods.setFreeprice(rs.getFloat(8));
			goods.setPicture(rs.getString(9));
			goods.setMark(rs.getInt(10));
			list.add(goods);
		}
		this.ps.close();
		return list;
	}
	@Override
	/*
	 * 增加商品
	 */
	public boolean insertGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "INSERT INTO tb_goods(sortId,tshirtName,introduce,brands,publishdate,nowprice,freeprice,picture,mark) VALUES(?,?,?,?,?,?,?,?,?)";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1,goods.getSortId());
		this.ps.setString(2,goods.getTshirtName());
		this.ps.setString(3,goods.getIntroduce());
		this.ps.setString(4,goods.getBrands());
		this.ps.setString(5,goods.getPublishdate());
		this.ps.setFloat(6,goods.getNowprice());
		this.ps.setFloat(7,goods.getFreeprice());
		this.ps.setString(8,goods.getPicture());
		this.ps.setInt(9,0);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 删除商品
	 */
	public boolean deleteGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "DELETE FROM tb_goods WHERE goodsId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1,goodsId);
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}

	@Override
	/*
	 * 修改商品价格信息
	 */
	public boolean updateGoodsPrice(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "UPDATE tb_goods SET freeprice=?,nowprice=?,mark=? WHERE goodsId=?";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setFloat(1,goods.getFreeprice());
		this.ps.setFloat(2,goods.getNowprice());
		this.ps.setInt(3,goods.getMark());
		this.ps.setInt(4,goods.getGoodsId());
		if(this.ps.executeUpdate()>0){
			flag = true;
		}
		this.ps.close();
		return flag;
	}
}
