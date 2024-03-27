package com.assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Entity.Story;
import com.assignment.Service.DataExtract;

@RestController
public class Control {
	
	@Autowired
	private DataExtract da;
	
	@GetMapping("/getTimeStories")
	public ResponseEntity<List<Story>> getTheData() throws Exception{
		return new ResponseEntity<>(da.dataExtract(), HttpStatus.ACCEPTED);
	}
	
}
