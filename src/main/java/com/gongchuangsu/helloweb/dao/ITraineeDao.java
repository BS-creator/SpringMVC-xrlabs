package com.gongchuangsu.helloweb.dao;

import java.util.List;
import com.gongchuangsu.helloweb.model.Session;
import com.gongchuangsu.helloweb.model.Trainee;

public interface ITraineeDao {
	List<Trainee> getAllTrainees();
	void addTrainee(Trainee trainee);
	Trainee getTraineeById(long id);
}
