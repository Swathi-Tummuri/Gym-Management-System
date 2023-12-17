package com.gms.service;

import java.util.List;

import com.gms.bean.Participant;
import com.gms.dao.ParticipantDao;

public class ParticipantService {

	ParticipantDao pd = new ParticipantDao();
	public String addParticipant(Participant ppt) {
		if(ppt.getId()<0) {
			return "Id must be > 0";
		}else if (pd.addParticipant(ppt)>0) {
			return "Participant record stored successfully";
		}else {
			return "Participant record didn't stored";
		}
	}
	
	public String updateParticipant(Participant ppt) {
		if(pd.updateParticipant(ppt)>0) {
			return "Participant batch chaged successfully";
		}else {
			return "Participant batch didn't changed";
		}
	}
	
	public String deleteParticipant(int id) {
		if(pd.deleteParticipant(id)>0) {
			return "Participant record deleted successfully";
		}else {
			return "Participant record didn't deleted";
		}
	}
	
	public List<Participant> findAllParticipants() {
		return pd.findAllParticipants();
	}
}
