package com.instagram;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.dao.InstagramDAO;
import com.instagram.entity.InstagramUser;

public class TestInstagramDAO {
	InstagramDAO InstagramDAO;
	
	@Before
	public void setUp() throws Exception {
		InstagramDAO = new InstagramDAO();
	}

	@After
	public void tearDown() throws Exception {
		InstagramDAO = null;
	}
	
	@Test
	public void testViewAllProfileDAO() {
		System.out.println("Entering into view All profile DAO");
		List<InstagramUser> fbuserList = InstagramDAO.viewAllProfileDAO();
		int result=0;
		if(fbuserList.size()> 0) {
			result =1;
		}
		assert result > 0: "profiles not found";
	}
	
	@Test
	public void testViewProfileDAO() {
		System.out.println("Entering into view profile DAO");
		InstagramUser facebookUser = new InstagramUser();
		facebookUser.setEmail("aaa");
		InstagramUser iguser = InstagramDAO.viewProfileDAO(facebookUser);
		int result=0;
		if(null != iguser.getName()) {
			result =1;
		}
		assert result > 0: "profile not found";
	}

//	@Test
//	public void testCreateProfileDAO() {
//		System.out.println("Entering into create profile DAO");
//		InstagramUser igu = new InstagramUser();
//		igu.setName("Nithesh");
//		igu.setEmail("nithesh@gmail.com");
//		igu.setPassword("12345");
//		igu.setAddress("AP");
//		int result = InstagramDAO.createProfileDAO(igu);
//		assert result > 0: "Error while creating profile";
//	}
}
