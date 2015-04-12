package com.nicusa.ridbtips.service;

import com.nicusa.ridbtips.domain.Tip;

public interface VotingService {

	Tip upvoteTip(Long tipId);
	Tip downvoteTip(Long tipId);

}
