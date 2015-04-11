package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	private TipService tipService;

	@Autowired
	@Qualifier("EventTipService")
	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	@RequestMapping(value = "{eventId}/tips", method = RequestMethod.GET)
	public List<Tip> findTipsForEvent(@PathVariable Long eventId,
			@RequestParam(required = false) boolean hideUserCreated) {
		if (hideUserCreated) {
			return tipService.findAllAutomatedTips(eventId);
		} else {
			return tipService.findAllUserCreatedTips(eventId);
		}
	}

}
