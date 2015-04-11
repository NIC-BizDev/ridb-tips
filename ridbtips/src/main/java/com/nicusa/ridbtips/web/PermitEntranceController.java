package com.nicusa.ridbtips.web;

import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permitEntrance")
public class PermitEntranceController {

	private TipService tipService;

	@Autowired
	@Qualifier("PermitEntranceTipService")
	public void setTipService(TipService tipService) {
		this.tipService = tipService;
	}

	@RequestMapping("{permitId}/tips")
	public List<Tip> findTipsForPermitEntrance(@PathVariable Long permitEntranceId,
			@RequestParam(required = false) boolean hideUserCreated) {
		if (hideUserCreated) {
			return tipService.findAllAutomatedTips(permitEntranceId);
		} else {
			return tipService.findAllUserCreatedTips(permitEntranceId);
		}
	}
}
