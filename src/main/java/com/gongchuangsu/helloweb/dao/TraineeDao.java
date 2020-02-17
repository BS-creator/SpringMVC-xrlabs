package com.gongchuangsu.helloweb.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;


@Transactional
@Repository
public class TraineeDao implements ITraineeDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public List<Trainee> getAllTrainees() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2VHSGDS\\PROGRAMMER;databaseName=again", "mine", "world");
			Statement statement = conn.createStatement();
            
			String sessions = "SELECT employee_id, MAX(Ss.time_taken) as best_time, MAX(Ss.attempts) as attempts FROM sessions as Ss GROUP BY employee_id";
			String sql = "SELECT T.*, S.best_time as bt, S.attempts as att  FROM trainee as T LEFT JOIN ("+sessions+") as S ON S.employee_id = T.id ORDER BY name";
			ResultSet rs = statement.executeQuery(sql);
			List<Trainee> trainees = new ArrayList<>();
			while (rs.next()) {
				Trainee trainee = new Trainee();
	            long id = rs.getInt("id");
	            String employee_name = rs.getString("name");
	            String employee_email = rs.getString("employee_email");
	            String best_time = rs.getString("bt");
	            String attempt = rs.getString("att");
	            String pictureBase64 = rs.getString("pictureBase64");
	            
	            trainee.setId(id);
	            trainee.setEmployee_name(employee_name);
	            trainee.setEmployee_email(employee_email);
	            trainee.setBest_time(best_time);
	            trainee.setAttempt(attempt);
	            trainee.setPictureBase64(pictureBase64);;
	            
	            trainees.add(trainee);
	            
	            System.out.println(id + ", " + employee_name + ", " + employee_email + ", " + best_time + ", " + attempt);
	        }
            conn.commit();
            conn.close();
            
            return trainees;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void addTrainee(Trainee trainee) {
		System.out.println(trainee.getId()+"...d");

		hibernateTemplate.save(trainee);
		
	}

	@Override
	public Trainee getTraineeById(long id) {
		return hibernateTemplate.get(Trainee.class, id);
	}

	

		


}
