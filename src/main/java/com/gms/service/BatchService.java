package com.gms.service;

import java.util.List;

import com.gms.bean.Batch;
import com.gms.dao.BatchDao;

public class BatchService {
	
	BatchDao bd = new BatchDao();
	public String addBatch(Batch bch) {
		if(bch.getBatchid()<0) {
			return "BatchId must be > 0";
		}else if (bd.addBatch(bch)>0) {
			return "Batch record stored successfully";
		}else {
			return "Batch record didn't stored";
		}
	}
	
	public String updateBatch(Batch bch) {
		if(bd.updateBatch(bch)>0) {
			return "Batch instructor chaged successfully";
		}else {
			return "Batch instructor didn't changed";
		}
	}
	
	public String deleteBatch(int batchid) {
		if(bd.deleteBatch(batchid)>0) {
			return "Batch record deleted successfully";
		}else {
			return "Batch record didn't deleted, because some participants are still on this batch";
		}
	}
	
	public List<Batch> findAllBatches() {
		return bd.findAllBatches();
	}
}
