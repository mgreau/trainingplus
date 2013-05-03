package com.trainingplus.server.dao;
import com.googlecode.objectify.ObjectifyService;
import com.trainingplus.server.model.Club;
import com.trainingplus.server.model.Coach;
import com.trainingplus.server.model.Person;
import com.trainingplus.server.model.Player;
import com.trainingplus.server.model.Season;
import com.trainingplus.server.model.SeasonClub;

public class TplusDAOFactory {

	// Declare entity-specific versions of each Generic interface
	public interface IPersonDAO extends IGenericDAO<Person> {}
	public interface IPlayerDAO extends IGenericDAO<Player> {}
	public interface ICoachDAO extends IGenericDAO<Coach> {}
	public interface ISeasonDAO extends IGenericDAO<Season> {}
	public interface ISeasonClubDAO extends IGenericDAO<SeasonClub> {}

	// The use those interfaces as we declare entity-specific DAOs
	private static class PersonDAO extends ObjectifyGenericDAO<Person> implements IPersonDAO {}
	private static class PlayerDAO extends ObjectifyGenericDAO<Player> implements IPlayerDAO {}
	private static class CoachDAO extends ObjectifyGenericDAO<Coach> implements ICoachDAO {}
	private static class SeasonDAO extends ObjectifyGenericDAO<Season> implements ISeasonDAO {}
	private static class SeasonClubDAO extends ObjectifyGenericDAO<SeasonClub> implements ISeasonClubDAO {}

	static{
		ObjectifyService.register(Club.class);
		ObjectifyService.register(Season.class);
		ObjectifyService.register(Person.class);
		ObjectifyService.register(SeasonClub.class);
		ObjectifyService.register(Coach.class);
		ObjectifyService.register(Player.class);
	}

	// Static-only usage pattern
	protected TplusDAOFactory() {}

	public static ClubDAO getClubDAO() {
		return new ClubDAO();
	}
	
	public static PersonDAO getPersonDAO() {
		return new PersonDAO();
	}
	
	public static SeasonDAO getSeasonDAO() {
		return new SeasonDAO();
	}
	
	public static SeasonClubDAO getSeasonClubDAO() {
		return new SeasonClubDAO();
	}
	
	public static CoachDAO getCoachDAO() {
		return new CoachDAO();
	}
	
	public static PlayerDAO getPlayerDAO() {
		return new PlayerDAO();
	}

}