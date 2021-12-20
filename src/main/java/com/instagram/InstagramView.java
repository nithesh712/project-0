package com.instagram;

import java.util.Scanner;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class InstagramView {
	public static void main(String[] args) {
		String ss = "y";
		while(ss.equals("y")) {
			
		System.out.println("________Menu_________");
		System.out.println("Press 1 to create");
		System.out.println("Press 2 to view all");
		System.out.println("press 3 to view profile of a user");
		
		System.out.print("Enter Option: ");
		
		Scanner sc = new Scanner(System.in);
		
		int ch = sc.nextInt();
		
		InstagramControllerInterface ic = new InstagramController();
		
		switch(ch) {
		case 1: int i = ic.createProfileController();
			if(i>0) {
				System.out.println("Created Success");
			} else {
				System.out.println("Creation Fail");
			}
			break;
		case 2: int j = ic.viewAllProfileController();
			if(j>0) {
				System.out.println("View All Success and found records " + j);
			} else {
				System.out.println("View All Fail");
			}
			break;
		case 3: int k = ic.viewProfileController();
			if(k>0) {
				System.out.println("User profile found");
			} else {
				System.out.println("User profile not found");
			}
			break;
		default:
			System.out.println("Wrong Choice");
		}
		System.out.println("Do you want to continue: y/n");
		ss = sc.next();
	 }
	}

}
