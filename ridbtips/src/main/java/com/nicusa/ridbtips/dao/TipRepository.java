package com.nicusa.ridbtips.dao;

import com.nicusa.ridbtips.domain.RidbType;
import com.nicusa.ridbtips.domain.Tip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipRepository extends CrudRepository<Tip, Long> {

	List<Tip> findByRidbIdAndRidbType(Long ridbId, RidbType ridbType);
	List<Tip> findByRidbIdAndRidbTypeAndUserCreated(Long ridbId, RidbType ridbType, Boolean userCreated);

}
