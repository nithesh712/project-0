package com.instagram.service;

import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;

public interface InstagramServiceInterface {

	int createProfileService(InstagramUser iu);

	public List<InstagramUser> viewAllProfileService();

	InstagramUser viewProfileService(InstagramUser iu) throws UserNotFoundException;

}
