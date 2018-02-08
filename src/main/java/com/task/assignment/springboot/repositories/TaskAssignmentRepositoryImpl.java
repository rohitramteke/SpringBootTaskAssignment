package com.task.assignment.springboot.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.task.assignment.springboot.model.TaskAssignment;



@Transactional
public class TaskAssignmentRepositoryImpl implements TaskAssignmentRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TaskAssignment assignTask(TaskAssignment assignment) {
		return (TaskAssignment) entityManager.createQuery("Select * Task_Assignment ");
	}

	@Override
	public TaskAssignment updateTaskAssignment(TaskAssignment assignment) {
		return (TaskAssignment) entityManager.createQuery("update Task_Assignment ");
	}


}