package com.py.dao.proxy;

import java.util.List;
import com.py.dao.GoodsDAO;
import com.py.dao.impl.GoodsDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Goods;

public class GoodsDAOProxy implements GoodsDAO{
	private DatabaseConnection dbc = null;//定义数据库连接类
	private GoodsDAO dao = null;//声明DAO对象
	public GoodsDAOProxy()throws Exception{//在构造方法中实例化连接，同时实例化dao对象
		this.dbc = new DatabaseConnection();//连接数据库
		this.dao = new GoodsDAOImpl(this.dbc.getConnection());//实例化真实主题类
	}
	@Override
	/*
	 * 查询所有商品
	 */
	public List<Goods> selectGoods() throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//定义返回的集合
		try{
			list = this.dao.selectGoods();//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 按商品编号查询商品
	 */
	public Goods selectGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		Goods goods = null;//定义对象
		try{
			goods = this.dao.selectGoodsByGoodsId(goodsId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return goods;
	}

	@Override
	/*
	 * 按类别编号查询商品
	 */
	public List<Goods> selectGoodsBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//定义返回的集合
		try{
			list = this.dao.selectGoodsBySortId(sortId);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}

	@Override
	/*
	 * 按特价标识查询商品
	 */
	public List<Goods> selectGoodsByMark(int mark) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//定义返回的集合
		try{
			list = this.dao.selectGoodsByMark(mark);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	
	@Override
	/*
	 * 按关键字查询商品
	 */
	public List<Goods> selectKeywords(String keywords) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//定义返回的集合
		try{
			list = this.dao.selectKeywords(keywords);//调用真实实现类
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return list;
	}
	
	@Override
	/*
	 * 增加商品
	 */
	public boolean insertGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectGoodsByGoodsId(goods.getGoodsId())==null){
				flag = this.dao.insertGoods(goods);
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
	 * 删除商品
	 */
	public boolean deleteGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectGoodsByGoodsId(goodsId)!=null){
				flag = this.dao.deleteGoodsByGoodsId(goodsId);
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
	 * 修改商品价格信息
	 */
	public boolean updateGoodsPrice(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//定义标志位
		try{
			if(this.dao.selectGoodsByGoodsId(goods.getGoodsId())!=null){
				flag = this.dao.updateGoodsPrice(goods);
			}
		}catch(Exception e){
			throw e;//将异常交给被调用出处理
		}finally{
			this.dbc.close();//关闭数据库连接
		}
		return flag;
	}
}
