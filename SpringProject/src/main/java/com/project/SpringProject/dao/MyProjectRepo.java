package com.project.SpringProject.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.SpringProject.model.Feedback;

public interface MyProjectRepo extends CrudRepository<Feedback, Integer>{

}
