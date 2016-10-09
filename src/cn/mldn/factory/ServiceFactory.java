package cn.mldn.factory;

import cn.mldn.service.proxy.ServiceProxy;

public class ServiceFactory {
	public static <T> T getInstance(Class<T> cls){
		try{
			return new ServiceProxy().bind(cls);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null ; 
	}
}
