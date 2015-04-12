package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VotingController {

	private VotingService votingService;

	@Autowired
	public void setVotingService(VotingService votingService) {
		this.votingService = votingService;
	}

	@RequestMapping(value = "/tip/{tipId}/upvote")
	public ResponseEntity<?> upvoteTip(@PathVariable Long tipId) {
		try {
			votingService.upvoteTip(tipId);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/tip/{tipId}/downvote")
	public ResponseEntity<?> downvoteTip(@PathVariable Long tipId) {
		try {
			votingService.downvoteTip(tipId);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
