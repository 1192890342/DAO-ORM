package cn.mldn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dao.IMembersDAO;
import cn.mldn.dbc.DatabaseConnection;
import cn.mldn.vo.Members;

public class MembersDAOImpl implements IMembersDAO {
	private PreparedStatement pstmt;
	private Connection conn;

	public MembersDAOImpl() {
		this.conn = DatabaseConnection.getConnection();
	}

	@Override
	public boolean doCreate(Members vo) throws SQLException {
		String sql = "insert into members(mid,name,age,birthday,salary,note,photo)values(?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, vo.getMid());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setInt(3, vo.getAge());
		this.pstmt.setDate(4, new java.sql.Date(vo.getBirthday().getTime()));
		this.pstmt.setDouble(5, vo.getSalary());
		this.pstmt.setString(6, vo.getNote());
		this.pstmt.setString(7, vo.getPhoto());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Members vo) throws SQLException {
		String sql = "UPDATE members SET name=?,age=?,birthday=?,salary=?,note=?,photo=? where mid=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setInt(2, vo.getAge());
		this.pstmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
		this.pstmt.setDouble(4, vo.getSalary());
		this.pstmt.setString(5, vo.getNote());
		this.pstmt.setString(6, vo.getPhoto());
		this.pstmt.setInt(7, vo.getMid());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemoveBatch(Set<Integer> ids) throws SQLException {
		StringBuffer buf = new StringBuffer();
		buf.append("DELETE FROM members WHERE mid IN ( ");
		Iterator<Integer> iter = ids.iterator();
		while (iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length() - 1, buf.length()).append(")");
		this.pstmt = this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate() == ids.size();
	}

	@Override
	public Members findById(Integer id) throws SQLException {
		Members vo = null;
		String sql = "select mid,name,age,birthday,salary,note,photo from members where mid=? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, id);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			vo = new Members();
			vo.setMid(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setBirthday(rs.getDate(4));
			vo.setSalary(rs.getDouble(5));
			vo.setNote(rs.getString(6));
			vo.setPhoto(rs.getString(7));
		}
		return vo;
	}

	@Override
	public List<Members> findAll() throws SQLException {
		List<Members> all = new ArrayList<Members>();
		String sql = "select mid,name,age,birthday,salary,note,photo from members ";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Members vo = new Members();
			vo.setMid(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setBirthday(rs.getDate(4));
			vo.setSalary(rs.getDouble(5));
			vo.setNote(rs.getString(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Members> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		List<Members> all = new ArrayList<Members>();
		String sql = "select * from(select mid,name,age,birthday,salary,note,photo,ROWNUM rn from members where"
				+ " rownum<=? )temp " + " where temp.rn>? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, currentPage * lineSize);
		this.pstmt.setInt(2, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Members vo = new Members();
			vo.setMid(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setBirthday(rs.getDate(4));
			vo.setSalary(rs.getDouble(5));
			vo.setNote(rs.getString(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Members> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws SQLException {
		List<Members> all = new ArrayList<Members>();
		String sql = "select * from(select mid,name,age,birthday,salary,note,photo,ROWNUM rn from members where "
				+ column + " like ? and  rownum<=? )temp " + " where temp.rn>? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyWord+"%");
		this.pstmt.setInt(2, currentPage * lineSize);
		this.pstmt.setInt(3, (currentPage - 1) * lineSize);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Members vo = new Members();
			vo.setMid(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setBirthday(rs.getDate(4));
			vo.setSalary(rs.getDouble(5));
			vo.setNote(rs.getString(6));
			vo.setPhoto(rs.getString(7));
			all.add(vo);
		}
		return all;
	}

	@Override
	public Integer getAllCount() throws SQLException {
		String sql = "select count(*) from members " ;
		this.pstmt = this.conn.prepareStatement(sql) ; 
		ResultSet rs = this.pstmt.executeQuery() ; 
		if(rs.next()){
			return rs.getInt(1) ; 
		}
		return 0;
	}

	@Override
	public Integer getAllCount(String column, String keyWord) throws SQLException {
		String sql = "select count(*) from members where "+column+" like ? " ;
		this.pstmt = this.conn.prepareStatement(sql) ; 
		this.pstmt.setString(1, "%"+keyWord+"%");
		ResultSet rs = this.pstmt.executeQuery() ; 
		if(rs.next()){
			return rs.getInt(1) ; 
		}
		return 0;
	}
}
