package com.gongchuangsu.helloweb.dao;

import java.util.List;
import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;

public interface ISessionDao {
	List<Session> getAllSessions();
	Trainee getTraineeById(long SessionId);
	List<Session> getSessionsByEid(long id);
	void archivesProcess(long session_id, int restore);
	Session getSessionById(long id);
	Session createSession(Session trainee);
	void updateSession(Session sessionDetails);
	void deleteSession(long id);
	Session getLatestSession(long eid);
}
