package com.gongchuangsu.helloweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;
import com.gongchuangsu.helloweb.model.User;


@Transactional
@Repository
public class SessionDao implements ISessionDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getAllSessions() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2VHSGDS\\PROGRAMMER;databaseName=again", "mine", "world");
			Statement statement = conn.createStatement();
            
			String sql = "SELECT *, T.name as t_emp FROM sessions as S LEFT JOIN trainee as T ON S.employee_id = T.id WHERE archives=1 ORDER BY name";
			ResultSet rs = statement.executeQuery(sql);
			List<Session> sessions = new ArrayList<>();
			while (rs.next()) {
				Session session = new Session();
				session.setId(rs.getInt("id"));
				session.setEmployee_id(rs.getInt("employee_id"));
				session.setEmployee_name(rs.getString("t_emp"));
				session.setDate_taken(rs.getString("date_taken"));
				session.setType(rs.getString("type"));
				session.setTime_taken(rs.getString("time_taken"));
				session.setTime_taken_module_1(rs.getString("time_taken_module_1"));
				session.setTime_taken_module_2(rs.getString("time_taken_module_2"));
				session.setTime_taken_module_3(rs.getString("time_taken_module_3"));
				session.setScore_received(rs.getString("score_received"));				
				session.setScore_module_1(rs.getString("score_module_1"));				
				session.setScore_module_2(rs.getString("score_module_2"));				
				session.setScore_module_3(rs.getString("score_module_3"));
				session.setPictureBase64(rs.getString("PictureBase64"));
	            sessions.add(session);
	            
	        }
            conn.commit();
            conn.close();
            
            return sessions;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Trainee getTraineeById(long id) {
		return hibernateTemplate.get(Trainee.class, id);
	}

	@Override
	public Session getLatestSession(long eid) {
		String hql = "from Session as s where archives=1 and s.employee_id="+eid + " order by s.created_at";
		List<Session> sessions =  (List<Session>) hibernateTemplate.find(hql);
		return sessions.size() > 0 ? sessions.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Session> getSessionsByEid(long employee_id) {
		String hql = "from Session as s where archives=1 and s.employee_id="+employee_id + " order by s.employee_name";
		
		return (List<Session>) hibernateTemplate.find(hql);
	}

	@Override
	public Session getSessionById(long id) {
		return hibernateTemplate.get(Session.class, id);
	}


	@Override
	public void archivesProcess(long session_id, int restore) {
		System.out.println(session_id);
		Session u = getSessionById(session_id);
		int aa = 1;
		if(restore == 1) {aa=0;}
		if(u.getArchives() == 0) {aa=1;}
		u.setArchives(aa);
		hibernateTemplate.update(u);
		System.out.println(u.getArchives());

	}

	@Override
	public Session createSession(Session sess) {

		hibernateTemplate.save(sess);
		return null;
	}
	

	@Override
	public void updateSession(Session sessionDetails) {
		Session session = this.getSessionById(sessionDetails.getId());
		session.setEmployee_id(sessionDetails.getEmployee_id());
        session.setAttempts(sessionDetails.getAttempts());
        session.setTime_taken(sessionDetails.getTime_taken());
        session.setTime_taken_module_1(sessionDetails.getTime_taken_module_1());
        session.setTime_taken_module_2(sessionDetails.getTime_taken_module_2());
        session.setTime_taken_module_3(sessionDetails.getTime_taken_module_3());
        session.setDate_taken(sessionDetails.getDate_taken());
        session.setScore_received(sessionDetails.getScore_received());
        session.setType(sessionDetails.getType());
        session.setPlatform(sessionDetails.getPlatform());
        session.setSession_status(sessionDetails.getSession_status());
        session.setCreated_at(sessionDetails.getCreated_at());
        session.setUpdated_at(sessionDetails.getUpdated_at());
        session.setStatus(sessionDetails.getStatus());;
		hibernateTemplate.update(session);
	}

	@Override
	public void deleteSession(long id) {
		hibernateTemplate.delete(this.getSessionById(id));
	}

}
