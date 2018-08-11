package com.py.dao.proxy;

import java.util.List;
import com.py.dao.GoodsDAO;
import com.py.dao.impl.GoodsDAOImpl;
import com.py.tool.DatabaseConnection;
import com.py.vo.Goods;

public class GoodsDAOProxy implements GoodsDAO{
	private DatabaseConnection dbc = null;//�������ݿ�������
	private GoodsDAO dao = null;//����DAO����
	public GoodsDAOProxy()throws Exception{//�ڹ��췽����ʵ�������ӣ�ͬʱʵ����dao����
		this.dbc = new DatabaseConnection();//�������ݿ�
		this.dao = new GoodsDAOImpl(this.dbc.getConnection());//ʵ������ʵ������
	}
	@Override
	/*
	 * ��ѯ������Ʒ
	 */
	public List<Goods> selectGoods() throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//���巵�صļ���
		try{
			list = this.dao.selectGoods();//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ����Ʒ��Ų�ѯ��Ʒ
	 */
	public Goods selectGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		Goods goods = null;//�������
		try{
			goods = this.dao.selectGoodsByGoodsId(goodsId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return goods;
	}

	@Override
	/*
	 * ������Ų�ѯ��Ʒ
	 */
	public List<Goods> selectGoodsBySortId(int sortId) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//���巵�صļ���
		try{
			list = this.dao.selectGoodsBySortId(sortId);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}

	@Override
	/*
	 * ���ؼ۱�ʶ��ѯ��Ʒ
	 */
	public List<Goods> selectGoodsByMark(int mark) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//���巵�صļ���
		try{
			list = this.dao.selectGoodsByMark(mark);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	
	@Override
	/*
	 * ���ؼ��ֲ�ѯ��Ʒ
	 */
	public List<Goods> selectKeywords(String keywords) throws Exception {
		// TODO Auto-generated method stub
		List<Goods> list = null;//���巵�صļ���
		try{
			list = this.dao.selectKeywords(keywords);//������ʵʵ����
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return list;
	}
	
	@Override
	/*
	 * ������Ʒ
	 */
	public boolean insertGoods(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectGoodsByGoodsId(goods.getGoodsId())==null){
				flag = this.dao.insertGoods(goods);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * ɾ����Ʒ
	 */
	public boolean deleteGoodsByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectGoodsByGoodsId(goodsId)!=null){
				flag = this.dao.deleteGoodsByGoodsId(goodsId);
			}

		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}

	@Override
	/*
	 * �޸���Ʒ�۸���Ϣ
	 */
	public boolean updateGoodsPrice(Goods goods) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;//�����־λ
		try{
			if(this.dao.selectGoodsByGoodsId(goods.getGoodsId())!=null){
				flag = this.dao.updateGoodsPrice(goods);
			}
		}catch(Exception e){
			throw e;//���쳣���������ó�����
		}finally{
			this.dbc.close();//�ر����ݿ�����
		}
		return flag;
	}
}
