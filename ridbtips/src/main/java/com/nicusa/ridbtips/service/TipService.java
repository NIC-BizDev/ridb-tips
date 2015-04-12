package com.nicusa.ridbtips.service;

import com.nicusa.ridbtips.domain.LeaveTipRequest;
import com.nicusa.ridbtips.domain.Tip;

import java.util.List;

public interface TipService {

	List<Tip> findAllTips(Long ridbId);
	List<Tip> findNonUserCreatedTips(Long ridbId);
	Tip saveTip(LeaveTipRequest leaveTipRequest);

}
