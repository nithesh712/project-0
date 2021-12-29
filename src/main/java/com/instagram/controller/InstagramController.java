package com.instagram.controller;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.instagram.entity.InstagramUser;
import com.instagram.entity.TimeLineEntity;
import com.instagram.exception.UserNotFoundException;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;
import com.instagram.ytility.ServiceFactory;
import com.instagram.ytility.SortingWithName;

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
		
		Collections.sort(a, new SortingWithName());
		
		System.out.println("______________________________");
		
		System.out.println("After Sorting");
		
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
		System.out.println("enter Email to view profile");
		String email = sc.next();
		
		InstagramUser iu = new InstagramUser();
		iu.setEmail(email);
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

	@Override
	public int deleteProfileController() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter email");
		String email=sc.next();
		
		InstagramUser lu=new InstagramUser();
		lu.setEmail(email);
		
		InstagramServiceInterface ls=ServiceFactory.createObject();
		int lu1=ls.deleteProfileService(lu);
		return lu1;
	}

	@Override
	public int loginProfileController() {
		Scanner sc=new Scanner(System.in);
		
		
		
		System.out.println("enter email");
		String email=sc.next();
		
		System.out.println("enter password");
		String password=sc.next();
		
		
		InstagramUser lu=new InstagramUser();
	
		lu.setEmail(email);
		lu.setPassword(password);
		
		
		InstagramServiceInterface ls=ServiceFactory.createObject();
		InstagramUser uu=ls.loginProfileService(lu);
		if(uu!=null) {
			System.out.println("Welcome "+uu.getName());
			
			System.out.println("press 1 to view timeline");
			System.out.println("press 2 to upload photo");
			System.out.println("press 3 edit profile");
			
			System.out.println("enter your choice");
			int cc=sc.nextInt();
			
			switch(cc) {
			case 1 : List<TimeLineEntity> tresult=ls.timelineService(lu);
				for(TimeLineEntity ti:tresult) {
					System.out.println();
				}
			break;
//			case 3 : int i = ic.editProfileController();
//			if(i>0) {
//				System.out.println("Edit Success");
//			} else {
//				System.out.println("Edit Fail");
//			}
//			break;
			}
		}
		
		return 0;
	}

	@Override
	public int EditProfileController() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Update Name: ");
		String name = sc.next();
		
		System.out.print("Update Password: ");
		String password = sc.next();
		
		System.out.print("Update Address: ");
		String address = sc.next();
		
		System.out.print("Update Email: ");
		String email = sc.next();
		
       // After taking input need to send to service in form of object
		
		InstagramUser iu = new InstagramUser();
		
		iu.setName(name);
		iu.setPassword(password);
		iu.setAddress(address);
		iu.setEmail(email);
		
		// Object controller created and need to pass to service
		
		InstagramServiceInterface igs = ServiceFactory.createObject();
		int i = igs.editProfileService(iu);
		
		return i;
	}

}
