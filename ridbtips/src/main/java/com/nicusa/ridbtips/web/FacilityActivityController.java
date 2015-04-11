package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilityActivity")
public class FacilityActivityController {

	private TipService tipService;

	@Autowired
	@Qualifier("FacilityActivityTipService")
	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	@RequestMapping("{facilityActivityId}/tips")
	public List<Tip> findTipsForFacilityActivity(@PathVariable Long facilityActivityId,
			@RequestParam(required = false) boolean hideUserCreated) {
		if (hideUserCreated) {
			return tipService.findAllAutomatedTips(facilityActivityId);
		} else {
			return tipService.findAllUserCreatedTips(facilityActivityId);
		}
	}

}
