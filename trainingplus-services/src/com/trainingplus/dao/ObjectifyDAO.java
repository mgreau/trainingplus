package com.trainingplus.dao;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.DAOBase;
import com.trainingplus.model.Club;

public class ObjectifyDAO extends DAOBase {
	
	static{
		ObjectifyService.register(Club.class);
	}

}
