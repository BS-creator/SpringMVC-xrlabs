package com.gongchuangsu.helloweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongchuangsu.helloweb.dao.ISessionDao;
import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;

@Service
public class SessionService implements ISessionService{
	@Autowired
	private ISessionDao SessionDao;
	
	
	@Override
	public List<Session> getAllSessions() {
		return SessionDao.getAllSessions();
	}

	@Override
	public Trainee getTraineeById(long SessionId) {
		return SessionDao.getTraineeById(SessionId);
	}

	@Override
	public List<Session> getSessionsByEid(long id) {
		return SessionDao.getSessionsByEid(id);
	}

	@Override
	public void archivesProcess(long session_id, int restore) {
		SessionDao.archivesProcess(session_id, restore);
		
	}

}
