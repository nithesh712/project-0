package com.instagram;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.instagram.controller.InstagramControllerInterface;
import com.instagram.ytility.ControllerFactory;

public class TestInstagramController {
	InstagramControllerInterface InstagramControllerInterface;
	
	@Before
	public void setUp() throws Exception {
		InstagramControllerInterface = ControllerFactory.createObject();
	}

	@After
	public void tearDown() throws Exception {
		InstagramControllerInterface = null;
	}

	
	@Test
	public void testcreateProfileController() {
		System.out.println("Inside Create Profile Controller");
		int result = InstagramControllerInterface.createProfileController();
		assert result > 0 : "Create Profile Fail";
	}
	
	@Test
	public void testViewProfileController() {
		System.out.println("Inside View Profile Controller");
		int result = InstagramControllerInterface.viewProfileController();
		assert result > 0 : "View Profile Fail";
	}
	 
	@Test
	public void testViewAllProfileController() {
		System.out.println("Inside View All Profile Controller");
		int result = InstagramControllerInterface.viewAllProfileController();
		assert result > 0 : "view all profiles fail";
	}
	
//	@Test
//	public void testLoginController() {
//		System.out.println("Inside View Login Controller");
//		int result = InstagramControllerInterface.loginProfileController();
//		assert result > 0 : "Login test Fail";
//	}
//	
	
	
	 @Test 
	 public void testDeleteProfileController() {
		 System.out.println("Inside Delete Profile Controller"); int result =
		 InstagramControllerInterface.deleteProfileController(); assert result > 0 :
	     "Error during delete profiles"; }
	 
	
}
