package com.task.assignment.springboot.service;

import com.task.assignment.springboot.model.TaskAssignment;

public interface TaskAssignmentService {
	
	TaskAssignment findById(Long id);
	
	TaskAssignment assignTask(TaskAssignment taskAssign);
	
	TaskAssignment updateTaskAssignment(TaskAssignment taskAssign);
}