package com.py.service;

import java.util.List;

import com.py.vo.Goods;

public interface GoodsService {
	/*
	 * ����result��getter��setter����
	 */
	public String getResult();
	public void setResult(String result);
	/*
	 * �������ID������Ʒ
	 */
	public List<Goods> selectGoodsBySortId(int sortId);
	/*
	 * �����ؼ۱�ʶ������Ʒ
	 */
	public List<Goods> selectGoodsByMark(int mark);
	/*
	 * ���ݹؼ���������Ʒ
	 */
	public List<Goods> selectByKeywords(String keywords);
	/*
	 * ������Ʒ
	 */
	public List<Goods> selectGoods();
	/*
	 * ������ƷID������Ʒ
	 */
	public Goods selectGoodsByGoodsId(int goodsId);
	/*
	 * ������ƷIDɾ����Ʒ
	 */
	public boolean deleteGoodsByGoodsId(int goodsId);
	/*
	 * ������Ʒ
	 */
	public boolean insertGoods(Goods goods);
	/*
	 * �޸���Ʒ�۸�
	 */
	public boolean updateGoodsPrice(Goods goods);
}
