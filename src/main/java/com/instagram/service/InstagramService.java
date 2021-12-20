package com.instagram.service;

import java.util.List;

import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;
import com.instagram.ytility.DAOFactory;

public class InstagramService implements InstagramServiceInterface {

	public int createProfileService(InstagramUser iu) {
		InstagramDAOInterface id = DAOFactory.createObject();
		return id.createProfileDAO(iu);
	}

	public List<InstagramUser> viewAllProfileService() {
		InstagramDAOInterface id = DAOFactory.createObject();
		return id.viewAllProfileDAO();
	}

	public InstagramUser viewProfileService(InstagramUser iu) throws UserNotFoundException {
		InstagramDAOInterface id = DAOFactory.createObject();
		return id.viewProfileDAO(iu);
	}

}
