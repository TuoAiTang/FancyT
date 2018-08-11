package com.py.dao;

import java.util.List;
import com.py.vo.Goods;

public interface GoodsDAO {
	/*
	 * 查询所有商品
	 */
	public List<Goods> selectGoods()throws Exception;
	/*
	 * 按商品编号查询商品
	 */
	public Goods selectGoodsByGoodsId(int goodsId)throws Exception;
	/*
	 * 按类别编号查询商品
	 */
	public List<Goods> selectGoodsBySortId(int sortId)throws Exception;
	/*
	 * 按特价标识查询商品
	 */
	public List<Goods> selectGoodsByMark(int mark)throws Exception;
	/*
	 * 按关键字查询商品
	 */
	public List<Goods> selectKeywords(String keywords)throws Exception;
	/*
	 * 增加商品
	 */
	public boolean insertGoods(Goods goods)throws Exception;
	/*
	 * 删除商品
	 */
	public boolean deleteGoodsByGoodsId(int goodsId)throws Exception;
	/*
	 * 修改商品价格信息
	 */
	public boolean updateGoodsPrice(Goods goods)throws Exception;
}
