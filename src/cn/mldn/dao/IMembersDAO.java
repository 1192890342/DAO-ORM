package cn.mldn.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.vo.Members;

public interface IMembersDAO {
	public boolean doCreate(Members vo)throws SQLException ;
	public boolean doUpdate(Members vo)throws SQLException ; 
	public boolean doRemoveBatch(Set<Integer> ids)throws SQLException ; 
	public Members findById(Integer id)throws SQLException ; 
	public List<Members> findAll()throws SQLException ; 
	public List<Members> findAllSplit(Integer currentPage,Integer lineSize)throws SQLException ; 
	public List<Members> findAllSplit(String column,String keyWord,Integer currentPage,Integer lineSize)throws SQLException ;
	public Integer getAllCount()throws SQLException ; 
	public Integer getAllCount(String column,String keyWord)throws SQLException ;
} 
