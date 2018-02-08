package com.task.assignment.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.task.assignment.springboot.model.TaskAssignment;
import com.task.assignment.springboot.service.TaskAssignmentService;
import com.task.assignment.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/taskAssign")
public class TaskAssignmentRestController {
	
	@Autowired
	TaskAssignmentService taskService;
	
	public static final Logger logger = LoggerFactory.getLogger(TaskAssignmentRestController.class);

	
	@RequestMapping(value = "/assignUser/{userId}", method = RequestMethod.POST)
	public ResponseEntity<?> assignTask(@RequestBody TaskAssignment task, UriComponentsBuilder ucBuilder) {
		taskService.assignTask(task);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/task/all/{id}").buildAndExpand(task.getTaskId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/assignUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateTaskAssignment(@PathVariable("id") long id, @RequestBody TaskAssignment task) {
		logger.info("Updating Task with id {}", id);

		TaskAssignment taskAssignment = taskService.findById(id);

		if (taskAssignment == null) {
			logger.error("Unable to update. Task with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Task with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		taskAssignment.setTaskId(task.getTaskId());
		taskAssignment.setUserId(task.getUserId());

		taskService.updateTaskAssignment(taskAssignment);
		return new ResponseEntity<TaskAssignment>(taskAssignment, HttpStatus.OK);
	}

}
