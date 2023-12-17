package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.bean.Batch;
import com.gms.resource.DbResource;

public class BatchDao {

	
	public int addBatch(Batch bch) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into batches values(?,?,?)");
		pstmt.setInt(1, bch.getBatchid());
		pstmt.setString(2, bch.getTiming());
		pstmt.setString(3, bch.getInstructor());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateBatch(Batch bch) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("update batches set instructor = ? where batchid = ?");
		pstmt.setInt(2, bch.getBatchid());
		pstmt.setString(1, bch.getInstructor());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteBatch(int batchid) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from batches where batchid = ?");
		pstmt.setInt(1, batchid);
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Batch> findAllBatches() {
		List<Batch> listOfBatches = new ArrayList<>();
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from batches");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Batch bch = new Batch();
			bch.setBatchid(rs.getInt(1));
			bch.setTiming(rs.getString(2));
			bch.setInstructor(rs.getString(3));
			listOfBatches.add(bch);
		}
		} catch (Exception e) {
			System.err.println(e);
		
		}
		return listOfBatches;
	}
}
