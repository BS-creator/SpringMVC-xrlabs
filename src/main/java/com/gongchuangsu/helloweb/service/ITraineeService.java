package com.gongchuangsu.helloweb.service;

import java.util.List;

import com.gongchuangsu.helloweb.model.Trainee;

public interface ITraineeService {
	List<Trainee> getAllTrainees();
	void addTrainee(Trainee trainee);
	Trainee getTraineeById(long id);

}
