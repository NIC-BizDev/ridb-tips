package com.nicusa.ridbtips.service.ridb;

import com.nicusa.ridbtips.dao.TipRepository;
import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipVotingService implements VotingService {

	private TipRepository tipRepository;

	@Autowired
	public void setTipRepository(TipRepository tipRepository) {
		this.tipRepository = tipRepository;
	}

	@Override
	@Transactional
	public Tip upvoteTip(Long tipId) {
		Tip tip = tipRepository.findOne(tipId);
		tip.setRating(tip.getRating() + 1);
		return tipRepository.save(tip);
	}

	@Override
	@Transactional
	public Tip downvoteTip(Long tipId) {
		Tip tip = tipRepository.findOne(tipId);
		tip.setRating(tip.getRating() - 1);
		return tipRepository.save(tip);
	}
}
