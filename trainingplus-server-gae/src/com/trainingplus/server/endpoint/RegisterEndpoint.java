package com.trainingplus.server.endpoint;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.trainingplus.server.dao.TplusDAOFactory;
import com.trainingplus.server.dao.TplusDAOFactory.IPersonDAO;
import com.trainingplus.server.model.Person;

@Api(name = "trainingplus")
public class RegisterEndpoint {

	
	@ApiMethod(name = "register.members", httpMethod = "GET")
	public List<Person> members() {
		IPersonDAO dao = TplusDAOFactory.getPersonDAO();
		return dao.listAll();
	}


}
