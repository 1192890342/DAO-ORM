package cn.mldn.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.vo.Members;

public interface IMembersService {
	public boolean add(Members vo)throws Exception ;  
	public List<Members> list()throws Exception ;
	public Members editPre(Integer id)throws Exception ;
	public boolean edit(Members vo)throws Exception ; 
	public boolean remove(Set<Integer> ids)throws Exception ; 
	public Map<String,Object> listSplip(int currentPage,int lineSize)throws Exception ; 
	public Map<String,Object> listSplip(String column,String keyWord,int currentPage,int lineSize)throws Exception ;
}
