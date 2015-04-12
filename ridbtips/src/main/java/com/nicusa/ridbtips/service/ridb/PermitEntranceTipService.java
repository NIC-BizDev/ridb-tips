package com.nicusa.ridbtips.service.ridb;

import com.nicusa.ridbtips.dao.TipRepository;
import com.nicusa.ridbtips.domain.LeaveTipRequest;
import com.nicusa.ridbtips.domain.RidbType;
import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("PermitEntranceTipService")
public class PermitEntranceTipService implements TipService {

	private TipRepository tipRepository;

	@Autowired
	public void setTipRepository(TipRepository tipRepository) {
		this.tipRepository = tipRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tip> findAllTips(Long ridbId) {
		return tipRepository.findByRidbIdAndRidbTypeOrderByRatingDesc(ridbId, RidbType.PERMIT_ENTRANCE);
	}

	@Override
	public List<Tip> findNonUserCreatedTips(Long ridbId) {
		return tipRepository.findByRidbIdAndRidbTypeAndUserCreatedOrderByRatingDesc(ridbId, RidbType.PERMIT_ENTRANCE, Boolean.FALSE);
	}

	@Override
	@Transactional
	public Tip saveTip(LeaveTipRequest leaveTipRequest) {
		Tip tip = new Tip(leaveTipRequest.getRidbId(), leaveTipRequest.getDescription(),
				0, Boolean.TRUE, RidbType.PERMIT_ENTRANCE);
		tipRepository.save(tip);
		return tip;
	}
}
