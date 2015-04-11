package com.nicusa.ridbtips.service;

import com.nicusa.ridbtips.domain.Tip;

import java.util.List;

public interface TipService {

	List<Tip> findAll();
	List<Tip> findAllUserCreatedTips(Long ridbId);
	List<Tip> findAllAutomatedTips(Long ridbId);


}
