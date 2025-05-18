package com.vinterbash.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinterbash.web.model.Organizer;
import com.vinterbash.web.model.Result;
import com.vinterbash.web.service.VinterbashService;

@RestController
@RequestMapping("/vinterbash")
public class VinterbashController {

	@Autowired
	private VinterbashService vinterbashService;

	@PostMapping("/register")
	public ResponseEntity<String> insertOrganizer(@RequestBody Organizer organizer) throws Exception {
		int result = vinterbashService.insertOrganizer(organizer);
		if (result > 0) {
			return ResponseEntity.ok("Organizer inserted successfully");
		} else {
			return ResponseEntity.status(400).body("Failed to insert organizer");
		}
	}

	@PostMapping("/validate")
	public ResponseEntity<String> validateOrganizer(@RequestBody Organizer organizer) throws Exception {
		int result = vinterbashService.validateOrganizer(organizer);
		if (result > 0) {
			return ResponseEntity.ok("Go to organizer home");
		} else {
			return ResponseEntity.status(400).body("Get lost fucker");
		}
	}
	
	@PostMapping("/result")
	public ResponseEntity<String> insertResult(@RequestBody Result res) throws Exception {
	    int result = vinterbashService.insertResult(res);
	    if (result > 0) {
	        return ResponseEntity.ok("Result added successfully");
	    } else {
	        return ResponseEntity.status(400).body("Get lost fucker");
	    }
	}


	@GetMapping("/leaderboard")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> getLeaderboard() {
        return ResponseEntity.ok(vinterbashService.getLeaderboard());
    }

}
