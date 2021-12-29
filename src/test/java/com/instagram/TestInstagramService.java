package com.instagram;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;

public class TestInstagramService {
	InstagramServiceInterface InstagramServiceInterface;
	@Before
	public void setUp() throws Exception {
		InstagramServiceInterface = new InstagramService();
	}

	@After
	public void tearDown() throws Exception {
		InstagramServiceInterface = null;
	}
	
	@Test
	public void testViewAllProfileService() {
		System.out.println("Entering into View all profile Sevice");
		List<InstagramUser> fbuserList = InstagramServiceInterface.viewAllProfileService();
		int result=0;
		if(fbuserList.size()> 0) {
			result =1;
		}
		assert result > 0: "profiles not found";
	}
	
	@Test
	public void testViewProfileService() throws UserNotFoundException {
		System.out.println("Entering into view profile Service");
		InstagramUser igu = new InstagramUser();
		igu.setEmail("n@gmail.com");
		InstagramUser iguser = InstagramServiceInterface.viewProfileService(igu);
		int result=0;
		if(null != iguser.getName()) {
			result =1;
		}
		assert result > 0: "profile not found";
	}

//	@Test
//	public void testCreateProfileService() {
//		System.out.println("Entering into create profile Service");
//		InstagramUser igu = new InstagramUser();
//		igu.setName("Nithesh");
//		igu.setEmail("n@gmail.com");
//		igu.setPassword("12345");
//		igu.setAddress("AP");
//		int result = InstagramServiceInterface.createProfileService(igu);
//		assert result > 0: "Error while creating profile";
//	}
}
