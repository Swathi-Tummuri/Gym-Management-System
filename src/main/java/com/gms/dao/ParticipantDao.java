package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.bean.Participant;
import com.gms.resource.DbResource;

public class ParticipantDao {

	public int addParticipant(Participant ppt) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("insert into participants values(?,?,?,?,?)");
		pstmt.setInt(1, ppt.getId());
		pstmt.setString(2, ppt.getName());
		pstmt.setString(3, ppt.getEmail());
		pstmt.setInt(4,ppt.getMobile());
		pstmt.setInt(5, ppt.getBatchid());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int updateParticipant(Participant ppt) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("update participants set batchid = ? where id = ?");
		pstmt.setInt(2, ppt.getId());
		pstmt.setInt(1, ppt.getBatchid());
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int deleteParticipant(int id) {
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from participants where id = ?");
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<Participant> findAllParticipants() {
		List<Participant> listOfParticipants = new ArrayList<>();
		try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from participants");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Participant ppt = new Participant();
			ppt.setId(rs.getInt(1));
			ppt.setName(rs.getString(2));
			ppt.setEmail(rs.getString(3));
			ppt.setMobile(rs.getInt(4));
			ppt.setBatchid(rs.getInt(5));
			listOfParticipants.add(ppt);
		}
		} catch (Exception e) {
			System.err.println(e);
		
		}
		return listOfParticipants;
	}
}
