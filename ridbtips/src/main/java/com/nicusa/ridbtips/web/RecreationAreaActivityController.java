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
@RequestMapping("/recreationAreaActivity")
public class RecreationAreaActivityController {

	private TipService tipService;

	@Autowired
	@Qualifier("RecreationAreaActivityTipService")
	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	@RequestMapping("{recreationAreaActivityId}/tips")
	public List<Tip> findTipsForRecreationAreaActivity(@PathVariable Long recreationAreaActivityId,
			@RequestParam(required = false) boolean hideUserCreated) {
		if (hideUserCreated) {
			return tipService.findNonUserCreatedTips(recreationAreaActivityId);
		} else {
			return tipService.findAllTips(recreationAreaActivityId);
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
