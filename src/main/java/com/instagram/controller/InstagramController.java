package com.instagram.controller;

import java.util.List;
import java.util.Scanner;

import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;
import com.instagram.ytility.ServiceFactory;

public class InstagramController implements InstagramControllerInterface {

	public int createProfileController() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = sc.next();
		
		System.out.print("Enter Email: ");
		String email = sc.next();
		
		System.out.print("Enter Password: ");
		String password = sc.next();
		
		System.out.print("Enter Address: ");
		String address = sc.next();
		
       // After taking input need to send to service in form of object
		
		InstagramUser iu = new InstagramUser();
		
		iu.setName(name);
		iu.setEmail(email);
		iu.setPassword(password);
		iu.setAddress(address);
		
		// Object controller created and need to pass to service
		
		InstagramServiceInterface igs = ServiceFactory.createObject();
		int i = igs.createProfileService(iu);
		
		return i;
	}
	
	public int viewAllProfileController() {
		int aa = 0;
		InstagramServiceInterface igs = new InstagramService();
		List<InstagramUser> a = igs.viewAllProfileService();
		
		for(InstagramUser i3 : a) {
			if(i3 != null) {
				System.out.println("_____________________________");
				System.out.println("Name is: "+ i3.getName());
				System.out.println("Email is: "+ i3.getEmail());
				System.out.println("Password is: "+ i3.getPassword());
				System.out.println("Address is: "+ i3.getAddress());
				aa++;
			} else {
				break;
			}
		}
		
		
		return aa;
	}

	public int viewProfileController() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter  name to view profile");
		String name = sc.next();
		
		InstagramUser iu = new InstagramUser();
		iu.setName(name);
		int i2=0;
		
		InstagramServiceInterface igs = ServiceFactory.createObject();
		
		try {
			InstagramUser s3=igs.viewProfileService(iu);
			
			if(s3!=null) {
				System.out.println("name is "+s3.getName());
				System.out.println("Password is "+s3.getPassword());
				System.out.println("Email is "+s3.getEmail());
				System.out.println("Address is "+s3.getAddress());
				i2=1;
			}
			}
			catch(UserNotFoundException e) {
				System.err.println(e);
			}
			return i2;
	}

}
