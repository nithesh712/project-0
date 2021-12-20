package com.instagram.dao;

import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu);

	public List<InstagramUser> viewAllProfileDAO();

	InstagramUser viewProfileDAO(InstagramUser iu) throws UserNotFoundException;

}
