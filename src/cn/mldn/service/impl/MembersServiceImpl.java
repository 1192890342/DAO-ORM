package cn.mldn.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.mldn.dao.IMembersDAO;
import cn.mldn.dao.impl.MembersDAOImpl;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IMembersService;
import cn.mldn.vo.Members;

public class MembersServiceImpl implements IMembersService {

	@Override 
	public boolean add(Members vo) throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		if(dao.findById(vo.getMid())==null){
			return dao.doCreate(vo) ; 
		}
		return false ;
	}
 
	@Override
	public List<Members> list() throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		return dao.findAll();
	}

	@Override
	public Members editPre(Integer id) throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		return dao.findById(id);
	}

	@Override
	public boolean edit(Members vo) throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		return dao.doUpdate(vo);
	}

	@Override
	public boolean remove(Set<Integer> ids) throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		if(ids==null || ids.size()==0){
			return false ; 
		}
		return dao.doRemoveBatch(ids);
	}

	@Override
	public Map<String, Object> listSplip(int currentPage, int lineSize) throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		Map<String,Object> map = new HashMap<String,Object>() ; 
		map.put("allMembers",dao.findAllSplit(currentPage, lineSize)) ; 
		map.put("memberCount",dao.getAllCount()) ; 
		return map;
	}

	@Override
	public Map<String, Object> listSplip(String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
		IMembersDAO dao = DAOFactory.getInstance(MembersDAOImpl.class) ;
		Map<String,Object> map = new HashMap<String,Object>() ;
		if(column==null || keyWord==null || "".equals(keyWord)){
			map.put("allMembers",dao.findAllSplit(currentPage, lineSize)) ; 
			map.put("membersCount",dao.getAllCount()) ;
		}else{
			map.put("allMembers", dao.findAllSplit(column, keyWord, currentPage, lineSize)) ; 
			map.put("membersCount", dao.getAllCount(column, keyWord)) ; 
		}
		return map;
	}
}
