package com.task.assignment.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.assignment.springboot.model.TaskAssignment;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long>, TaskAssignmentRepositoryCustom{
	TaskAssignment findById(long id);
}