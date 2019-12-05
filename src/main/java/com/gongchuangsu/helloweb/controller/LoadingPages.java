package com.gongchuangsu.helloweb.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;
import com.gongchuangsu.helloweb.model.User;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.orm.hibernate4.HibernateTemplate;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class LoadingPages extends HandlerInterceptorAdapter {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String allrequest(Model model) {
		System.out.println("called ok");
		return "redirect:/login";
	}

	@RequestMapping(value = "/archives", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String archives(Model model) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2VHSGDS\\PROGRAMMER;databaseName=again", "mine", "world");
			Statement statement = conn.createStatement();
            
			String sql = "SELECT *, T.name as t_emp FROM sessions as S LEFT JOIN trainee as T ON S.employee_id = T.id WHERE archives!=1 ORDER BY name";
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
            
            model.addAttribute("sessions", sessions);
            return "archives";

		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

	@RequestMapping(value = "/reset_password", method = RequestMethod.GET)
	public String reset_password() {
		return "reset_password";
	}

}
