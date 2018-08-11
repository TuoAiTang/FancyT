package com.py.factory;

import com.py.dao.*;
import com.py.dao.proxy.*;
public class DAOFactory {
	public static AfficheDAO getAfficheDAOInstance()throws Exception{//取得DAO接口实例
		return new AfficheDAOProxy();//取得代理类的实例
	}
	public static GoodsDAO getGoodsDAOInstance()throws Exception{//取得DAO接口实例
		return new GoodsDAOProxy();//取得代理类的实例
	}
	public static LeavewordsDAO getLeavewordsDAOInstance()throws Exception{//取得DAO接口实例
		return new LeavewordsDAOProxy();//取得代理类的实例
	}
	public static LinkDAO getLinkDAOInstance()throws Exception{//取得DAO接口实例
		return new LinkDAOProxy();//取得代理类的实例
	}
	public static ManagerDAO getManagerDAOInstance()throws Exception{//取得DAO接口实例
		return new ManagerDAOProxy();//取得代理类的实例
	}
	public static MemberDAO getMemberDAOInstance()throws Exception{//取得DAO接口实例
		return new MemberDAOProxy();//取得代理类的实例
	}
	public static OrderDAO getOrderDAOInstance()throws Exception{//取得DAO接口实例
		return new OrderDAOProxy();//取得代理类的实例
	}
	public static OrderDetailDAO getOrderDetailDAOInstance()throws Exception{//取得DAO接口实例
		return new OrderDetailDAOProxy();//取得代理类的实例
	}
	public static SortDAO getSortDAOInstance()throws Exception{//取得DAO接口实例
		return new SortDAOProxy();//取得代理类的实例
	}
	public static FootprintDAO getFootprintDAOInstance()throws Exception{
		return new FootprintDAOProxy();
	}
}
