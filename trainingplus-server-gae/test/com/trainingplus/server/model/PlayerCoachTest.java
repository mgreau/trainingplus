package com.trainingplus.server.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.trainingplus.server.dao.TplusDAOFactory;
import com.trainingplus.server.dao.TplusDAOFactory.ICoachDAO;
import com.trainingplus.server.dao.TplusDAOFactory.IPersonDAO;
import com.trainingplus.server.dao.TplusDAOFactory.IPlayerDAO;

public class PlayerCoachTest {

	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(
			new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	@Test
	public void createPeople() {
		IPersonDAO persDAO = TplusDAOFactory.getPersonDAO();
		ICoachDAO coachDAO = TplusDAOFactory.getCoachDAO();
		IPlayerDAO playerDAO = TplusDAOFactory.getPlayerDAO();

		Person zizou = new Person("Zidane", "zizou@free.fr");
		persDAO.put(zizou);

		Player messi = new Player("Messi", "messi@free.fr");
		messi.setBestFoot("right");
		playerDAO.put(messi);

		Coach guardo = new Coach("Guardolia", "guardo@free.fr");
		guardo.setCertificate("Pro");
		coachDAO.put(guardo);

		// This will return the Cat
		try {
			Person fetched = persDAO.get(messi.getId());
		} catch (EntityNotFoundException e) {
			fail();
		}

		// This query will produce three objects, the Animal, Mammal, and Cat
		List<Person> all = persDAO.listAll();
		assertEquals(3, all.size());

		// This query will produce the Mammal and Cat
		List<Player> players = playerDAO.listAll();
		assertEquals(1, players.size());
	}
	


}
