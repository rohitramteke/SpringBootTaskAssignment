package com.task.assignment.springboot.repositories;

import org.springframework.stereotype.Repository;

import com.task.assignment.springboot.model.TaskAssignment;

@Repository
public interface TaskAssignmentRepositoryCustom {
	TaskAssignment assignTask(TaskAssignment assignment);
	TaskAssignment updateTaskAssignment(TaskAssignment assignment);

}