package com.trainingplus.endpoint;

import java.util.ArrayList;
import java.util.List;

import com.google.api.server.spi.config.Api;
import com.trainingplus.model.Club;

@Api(name = "trainingplus")
public class TrainingplusEndpoint {
	
	public List<Club> listClub(){
		List<Club> list = new ArrayList<Club>();
		return list;
	}

}
