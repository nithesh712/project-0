package com.instagram.dao;

import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.entity.TimeLineEntity;
import com.instagram.exception.UserNotFoundException;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu);

	public List<InstagramUser> viewAllProfileDAO();

	InstagramUser viewProfileDAO(InstagramUser iu);

	int deleteProfileDAO(InstagramUser lu);

	InstagramUser loginProfileDAO(InstagramUser lu);

	List<TimeLineEntity> timelineProfileDAO(InstagramUser lu);

	int editProfileService(InstagramUser iu);

}
