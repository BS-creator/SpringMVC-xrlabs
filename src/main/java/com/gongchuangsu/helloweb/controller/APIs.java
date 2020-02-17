package com.gongchuangsu.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gongchuangsu.helloweb.dao.ISessionDao;
import com.gongchuangsu.helloweb.dao.ITraineeDao;
import com.gongchuangsu.helloweb.model.Login;
import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;
import com.gongchuangsu.helloweb.service.ISessionService;
import com.gongchuangsu.helloweb.service.IUserService;

@RestController
public class APIs {

	@Autowired
	private ISessionService sessionService;
	@Autowired
	private ISessionDao SessionDao;
	@Autowired
	private ITraineeDao TraineeDao;

	@Autowired
	private IUserService userService;
	
	public APIs () {
		System.out.println("called api");
	}
	
//	APIS
	protected boolean check_token(String token) {
		String access_token = new String("59ddb16b-6943-42f5-8e2f-3acb23f8e3c1");
		String tok = new String(token);
		System.out.println(tok.equals(access_token));
		return (tok.equals(access_token)) ? true : false ;
	}

	@RequestMapping(value = "/api/api", method = RequestMethod.GET)
	public void test(Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("okokok");
	}
	@RequestMapping(value = "/api/get_all_sessions", method = RequestMethod.GET)
	public List<Session> get_all_sessions(HttpServletRequest request) {
		System.out.println(request.getHeader("access_token"));
		if((!this.check_token(request.getHeader("access_token")))) {return null;}
		List<Session> sessions = sessionService.getAllSessions();
		return sessions;
	}

	@RequestMapping(value = "/api/get-session/{id}", method = RequestMethod.GET)
    public Session getSesnById(@PathVariable long id, HttpServletRequest request) {
		if((!this.check_token(request.getHeader("access_token")))) {return null;}
		return SessionDao.getSessionById(id);
    }
    
	@RequestMapping(value = "/api/get-latest-session/{eid}", method = RequestMethod.GET)
    public Session getSessionById1(@PathVariable(value = "eid") Integer eid, HttpServletRequest request) {
		if((!this.check_token(request.getHeader("access_token")))) {return null;}
		Session session = SessionDao.getLatestSession(eid);
         // .orElseThrow(() -> new ResourceNotFoundException("Session not found for this id :: " + employee_id));
        return session;
    }
    
	@RequestMapping(value = "/api/get-all-employees", method = RequestMethod.GET)
    public List<Trainee> getAllEmployees(HttpServletRequest request) {
		if((!this.check_token(request.getHeader("access_token")))) {return null;}
		List<Trainee> trainee = TraineeDao.getAllTrainees();
        return trainee;
    }
    
    @RequestMapping(value = "/api/add-trainee", method = RequestMethod.POST)
    public void createTrainee(@Valid @RequestBody Trainee trainee, HttpServletRequest request) {
    	if((!this.check_token(request.getHeader("access_token")))) {return;}
		TraineeDao.addTrainee(trainee);
    }

    @RequestMapping(value = "/api/add-session", method = RequestMethod.POST)
    public Session createSession(@Valid @RequestBody Session session, HttpServletRequest request) {
    	if((!this.check_token(request.getHeader("access_token")))) {return null;}
		return SessionDao.createSession(session);
    }

    @RequestMapping(value = "/api/update-sessions/{id}", method = RequestMethod.PUT)
    public Session updateSession(@PathVariable(value = "id") Long sessionId,
         @Valid @RequestBody Session sessionDetails, HttpServletRequest request) {
    	if((!this.check_token(request.getHeader("access_token")))) {return null;}
		
    	SessionDao.updateSession(sessionDetails);
        return sessionDetails;
    }

    @RequestMapping(value = "/api/delete-sessions/{id}", method = RequestMethod.DELETE)
    public Boolean deleteSession(@PathVariable(value = "id") Long sessionId, HttpServletRequest request) {
    	if((!this.check_token(request.getHeader("access_token")))) {return null;}
		SessionDao.deleteSession(sessionId);
        return true;
    }
    

}