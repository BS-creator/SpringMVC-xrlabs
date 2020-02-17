package com.gongchuangsu.helloweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gongchuangsu.helloweb.dao.ITraineeDao;
import com.gongchuangsu.helloweb.model.Trainee;

@Service
public class TraineeService implements ITraineeService{
	@Autowired
	private ITraineeDao TraineeDao;
	
	
	@Override
	public List<Trainee> getAllTrainees() {
		return TraineeDao.getAllTrainees();
	}


	@Override
	public void addTrainee(Trainee trainee) {
		TraineeDao.addTrainee(trainee);
		
	}


	@Override
	public Trainee getTraineeById(long id) {
		return TraineeDao.getTraineeById(id);
	}

	

}
