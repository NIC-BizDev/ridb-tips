package com.nicusa.ridbtips.domain;

import java.util.ArrayList;
import java.util.List;

public class TipFixtures {

	public static Tip getUserTip() {
		return new Tip(1L, "Some tip", 1, Boolean.TRUE);
	}

	public static Tip getAutomatedTip() {
		return new Tip(2L, "Some tip", 3, Boolean.FALSE);
	}

	public static Tip getBadUserTip() {
		return new Tip(3L, "Bad tip", -1, Boolean.TRUE);
	}

	public static List<Tip> getTips() {
		List<Tip> tips = new ArrayList<Tip>();
		tips.add(getUserTip());
		tips.add(getAutomatedTip());
		tips.add(getBadUserTip());
		return tips;
	}

	public static List<Tip> getTips(Long ridbId, Boolean userCreated) {
		List<Tip> tips = new ArrayList<Tip>();
		tips.add(new Tip(ridbId, "A tip", 1, userCreated));
		tips.add(new Tip(ridbId, "Another tip", 2, userCreated));
		tips.add(new Tip(ridbId, "Really bad tip", -9, userCreated));
		return tips;
	}

}
