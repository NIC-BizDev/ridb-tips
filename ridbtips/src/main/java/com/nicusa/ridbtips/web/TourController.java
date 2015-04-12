package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.domain.LeaveTipRequest;
import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourController {

	private TipService tipService;

	@Autowired
	@Qualifier("TourTipService")
	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	@RequestMapping(value = "{tourId}/tips", method = RequestMethod.GET)
	public List<Tip> findTipsForTour(@PathVariable Long tourId,
			@RequestParam(required = false) boolean hideUserCreated) {
		if (hideUserCreated) {
			return tipService.findNonUserCreatedTips(tourId);
		} else {
			return tipService.findAllTips(tourId);
		}
	}

	@RequestMapping(value = "/tip", method = RequestMethod.POST)
	public ResponseEntity<?> addTip(@RequestBody LeaveTipRequest leaveTipRequest) {
		try {
			tipService.saveTip(leaveTipRequest);
			return new ResponseEntity<Tip>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
