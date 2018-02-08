package com.task.assignment.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.assignment.springboot.model.TaskAssignment;
import com.task.assignment.springboot.repositories.TaskAssignmentRepository;



@Service("taskAssignmentService")
@Transactional
public class TaskAssignmentServiceImpl implements TaskAssignmentService{

	@Autowired
	private TaskAssignmentRepository taskRepository;

	@Override
	public TaskAssignment assignTask(TaskAssignment taskAssign) {
		return taskRepository.assignTask(taskAssign);
	}

	@Override
	public TaskAssignment updateTaskAssignment(TaskAssignment taskAssign) {
		return taskRepository.updateTaskAssignment(taskAssign);
	}

	@Override
	public TaskAssignment findById(Long id) {
		return taskRepository.findById(id);
	}

	

}