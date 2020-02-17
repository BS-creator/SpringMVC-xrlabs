package com.gongchuangsu.helloweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gongchuangsu.helloweb.dao.ISessionDao;
import com.gongchuangsu.helloweb.dao.ITraineeDao;
import com.gongchuangsu.helloweb.exception.ResourceNotFoundException;
import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;
import com.gongchuangsu.helloweb.service.ISessionService;
import com.gongchuangsu.helloweb.service.ITraineeService;

@Controller
public class SessionsController {

	@Autowired
	private ISessionService sessionService;

	@RequestMapping(value = "/sessions", method = RequestMethod.GET)
	public String getAllSessions(Model model) {
		List<Session> sessions = sessionService.getAllSessions();
		model.addAttribute("sessions", sessions);
		return "sessions";
	}

	@RequestMapping(value = "/detail/{eid}", method = RequestMethod.GET)
	public String getSessionById(@PathVariable long eid, Model model) throws ResourceNotFoundException {
		Trainee trainee = sessionService.getTraineeById(eid);
		List<Session> sessions = sessionService.getSessionsByEid(eid);
		
		int len = sessions.size()-1;
		model.addAttribute("trainee", trainee);
		model.addAttribute("last", len);
		model.addAttribute("sessions", sessions);
		return "detail";
	}

	@RequestMapping(value = "/archivesProcess/{session_id}/{restore}/{detail}", method = RequestMethod.GET)
	public String archivesProcess(@PathVariable long session_id,@PathVariable int restore,@PathVariable int detail, Model model) {
		sessionService.archivesProcess(session_id, restore);
		if(restore == 0) {
			return "redirect:/archives";  
		}else if (detail != 0) {
			return "redirect:/detail/"+detail+"";
		}
		return "redirect:/sessions";  
	}


}