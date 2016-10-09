package cn.mldn.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mldn.factory.ServiceFactory;
import cn.mldn.service.impl.MembersServiceImpl;
import cn.mldn.vo.Members;
import junit.framework.TestCase;

public class IMembersServiceTest {

	@Test
	public void testListSplipIntInt() {
		IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ;
		try{
			Map<String,Object> map = s.listSplip(1, 10) ; 
			Integer count = (Integer) map.get("memberCount") ; 
			List<Members>all = (List<Members>) map.get("allMembers") ;
			TestCase.assertTrue(count>0 && all.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test           
	public void testListSplipStringStringIntInt() {
		IMembersService s = ServiceFactory.getInstance(MembersServiceImpl.class) ;
		try{
			Map<String,Object> map = s.listSplip("name", "a", 1, 10); 
			Integer count = (Integer) map.get("memberCount") ; 
			List<Members>all = (List<Members>) map.get("allMembers") ;
			TestCase.assertTrue(count>0 && all.size()>0);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
