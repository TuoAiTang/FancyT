package com.py.factory;

import com.py.dao.*;
import com.py.dao.proxy.*;
public class DAOFactory {
	public static AfficheDAO getAfficheDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new AfficheDAOProxy();//ȡ�ô������ʵ��
	}
	public static GoodsDAO getGoodsDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new GoodsDAOProxy();//ȡ�ô������ʵ��
	}
	public static LeavewordsDAO getLeavewordsDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new LeavewordsDAOProxy();//ȡ�ô������ʵ��
	}
	public static LinkDAO getLinkDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new LinkDAOProxy();//ȡ�ô������ʵ��
	}
	public static ManagerDAO getManagerDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new ManagerDAOProxy();//ȡ�ô������ʵ��
	}
	public static MemberDAO getMemberDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new MemberDAOProxy();//ȡ�ô������ʵ��
	}
	public static OrderDAO getOrderDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new OrderDAOProxy();//ȡ�ô������ʵ��
	}
	public static OrderDetailDAO getOrderDetailDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new OrderDetailDAOProxy();//ȡ�ô������ʵ��
	}
	public static SortDAO getSortDAOInstance()throws Exception{//ȡ��DAO�ӿ�ʵ��
		return new SortDAOProxy();//ȡ�ô������ʵ��
	}
	public static FootprintDAO getFootprintDAOInstance()throws Exception{
		return new FootprintDAOProxy();
	}
}
