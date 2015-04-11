package com.nicusa.ridbtips.service.ridb;

import com.nicusa.ridbtips.domain.Tip;
import com.nicusa.ridbtips.domain.TipFixtures;
import com.nicusa.ridbtips.service.TipService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RecreationAreaActivityTipService")
public class RecreationAreaActivityTipService implements TipService {

	@Override
	public List<Tip> findAll() {
		return TipFixtures.getTips();
	}

	@Override
	public List<Tip> findAllUserCreatedTips(Long ridbId) {
		return TipFixtures.getTips(ridbId, Boolean.TRUE);
	}

	@Override
	public List<Tip> findAllAutomatedTips(Long ridbId) {
		return TipFixtures.getTips(ridbId, Boolean.FALSE);
	}
}
