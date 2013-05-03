package com.trainingplus.server.endpoint;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.trainingplus.server.dao.TplusDAOFactory;
import com.trainingplus.server.dao.TplusDAOFactory.IPersonDAO;
import com.trainingplus.server.model.Person;

@Api(name = "trainingplus")
public class PersonEndpoint {
	
	IPersonDAO dao = TplusDAOFactory.getPersonDAO();

	/**
	 * This method lists all the entities inserted in datastore. It uses HTTP
	 * GET method.
	 * 
	 * @return List of all entities persisted.
	 */
	public List<Person> listPerson() {
		return dao.listAll();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET
	 * method.
	 * 
	 * @param id
	 *            the primary key of the java bean.
	 * @return The entity with primary key id.
	 * @throws EntityNotFoundException 
	 */
	public Person getPerson(@Named("id") Long id) throws EntityNotFoundException {
		return dao.get(id);
	}

	/**
	 * This inserts the entity into App Engine datastore. It uses HTTP POST
	 * method.
	 * 
	 * @param person
	 *            the entity to be inserted.
	 * @return The inserted entity.
	 */
	public Person insertPerson(Person person) {
		dao.put(person);
		return person;
	}

	/**
	 * This method is used for updating a entity. It uses HTTP PUT method.
	 * 
	 * @param person
	 *            the entity to be updated.
	 * @return The updated entity.
	 */
	public Person updatePerson(Person person) {
		dao.put(person);
		return person;
	}

	/**
	 * This method removes the entity with primary key id. It uses HTTP DELETE
	 * method.
	 * 
	 * @param id
	 *            the primary key of the entity to be deleted.
	 * @return The deleted entity.
	 * @throws EntityNotFoundException 
	 */
	public Person removePerson(@Named("id") Long id) throws EntityNotFoundException {
		Person person = dao.get(id);
		dao.deleteKey(new Key<Person>(Person.class, id));
		return person;
	}

}
