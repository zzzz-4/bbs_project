package com.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bbs.pojo.userPlate;

import com.bbs.tools.BaseDao;


public class cropsDao {
	public userPlate findTitleByName(String plateTitle) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		userPlate userPlate = null;
		try {
			conn = BaseDao.getCon();
			String sql = "select * from bbs_plate where plateTitle=?";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps, new Object[] {plateTitle});
			if(rs.next()) {
				userPlate=new userPlate(rs.getInt("plateId"),rs.getString("plateTitle"));}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return userPlate;
	}
	public int addCategory(String plateTitle,String plateMessage) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = BaseDao.getCon();
			String sql = "insert into bbs_plate(plateTitle,plateMessage) values(?,?)";
			ps = conn.prepareStatement(sql);
			return BaseDao.alter(ps, new Object[] {plateTitle,plateMessage});
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, null);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return 0;
	}
	public ArrayList<userPlate> listMessage(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<userPlate> array = new ArrayList<>();
		try {
			conn = BaseDao.getCon();
			String sql = "select * from bbs_plate";
			ps = conn.prepareStatement(sql);
			rs = BaseDao.query(ps, null);
			while(rs.next()) {
				array.add(new userPlate(rs.getInt("plateId"),rs.getString("plateTitle"),rs.getString("plateMessage")));
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			try {
				BaseDao.close(conn, ps, rs);
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return array;
	}
	
}
