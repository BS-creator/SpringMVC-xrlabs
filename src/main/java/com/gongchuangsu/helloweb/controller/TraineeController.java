package com.gongchuangsu.helloweb.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gongchuangsu.helloweb.model.Trainee;
import com.gongchuangsu.helloweb.service.ISessionService;
import com.gongchuangsu.helloweb.service.ITraineeService;

@Controller
public class TraineeController {

	@Autowired
	private ITraineeService traineeService;
	@Autowired
	private ISessionService sessionService;

	@RequestMapping(value = "/trainee", method = RequestMethod.GET)
	public String getAllTrainees(Model model) {
		List<Trainee> trainees = traineeService.getAllTrainees();
		model.addAttribute("trainees", trainees);
		model.addAttribute("trainee", new Trainee());
		return "trainee";
	}

	@RequestMapping(value = "/trainee_add", method = RequestMethod.POST)
	public String trainee_add(@ModelAttribute Trainee trainee, @RequestParam MultipartFile picture) throws IOException {
		System.out.println(trainee.getId());
		byte[] encodeBase64 = Base64.encodeBase64(picture.getBytes());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		trainee.setPictureBase64(base64Encoded);
		trainee.setFileName(picture.getOriginalFilename());
		traineeService.addTrainee(trainee);
		return "redirect:trainee";
	}


}