package com.trainingplus.server.dao;

import com.googlecode.objectify.Key;
import com.trainingplus.server.dao.TplusDAOFactory.ISeasonClubDAO;
import com.trainingplus.server.model.Club;
import com.trainingplus.server.model.Season;
import com.trainingplus.server.model.SeasonClub;

public class ClubDAO extends ObjectifyGenericDAO<Club> implements IClubDAO {

	@Override
	public void subscribeClubToASeason(Club club, Season season)
			throws Exception {
		// check if club has already subscribed to this season
		if (club != null && season != null) {
			ISeasonClubDAO daoSC = TplusDAOFactory.getSeasonClubDAO();
			if (club.getId() != null && season.getId() != null) {
				if (ofy()
						.query(SeasonClub.class)
						.filter("club", new Key<Club>(Club.class, club.getId()))
						.filter("season",
								new Key<Season>(Season.class, season.getId()))
						.count() > 0) {
					throw new Exception(
							"club has already subscribed to this season");
				}
			}
			Key<SeasonClub> ksc = daoSC.put(new SeasonClub(club, season));
			club.getSeasons().add(ksc);
			put(club);
		}
	}
}
