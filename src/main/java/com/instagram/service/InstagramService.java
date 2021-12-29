package com.instagram.service;

import java.util.List;

import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;
import com.instagram.entity.TimeLineEntity;
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

	@Override
	public int deleteProfileService(InstagramUser lu) {
		InstagramDAOInterface ld=DAOFactory.createObject();
		return ld.deleteProfileDAO(lu);
	}

	@Override
	public InstagramUser loginProfileService(InstagramUser lu) {
		InstagramDAOInterface ld=DAOFactory.createObject();
		return ld.loginProfileDAO(lu);
	}

	@Override
	public List<TimeLineEntity> timelineService(InstagramUser lu) {
		InstagramDAOInterface ld=DAOFactory.createObject();
		return ld.timelineProfileDAO(lu);
	}

	@Override
	public int editProfileService(InstagramUser iu) {
		InstagramDAOInterface igd=DAOFactory.createObject();
		 return igd.editProfileService(iu);
	}

}
