package com.nicusa.ridbtips.web;

import nicbizdev.ridb.RIDBClient;
import nicbizdev.ridb.RIDBOrganization;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

	private static final String API_KEY = "1F6C17617F5B4A59A11203C1F680F2FF";

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testApplication() {
		return "IT LIVES!";
	}

	@RequestMapping(value = "/orgs", method = RequestMethod.GET)
	public List<RIDBOrganization> getOrganizations() {
		return new RIDBClient(API_KEY).getAllOrganizations();
	}


}
