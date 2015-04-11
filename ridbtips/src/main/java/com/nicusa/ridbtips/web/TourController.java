package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
			return tipService.findAllAutomatedTips(tourId);
		} else {
			return tipService.findAllUserCreatedTips(tourId);
		}
	}

}
