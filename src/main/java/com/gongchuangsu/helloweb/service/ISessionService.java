package com.gongchuangsu.helloweb.service;

import java.util.List;

import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;

public interface ISessionService {
	List<Session> getAllSessions();
	Trainee getTraineeById(long SessionId);
	List<Session> getSessionsByEid(long id);
	void archivesProcess(long session_id, int restore);
}
