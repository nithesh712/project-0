package com.instagram.ytility;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class ControllerFactory {
	private ControllerFactory() {
		
	}
	
	public static InstagramControllerInterface createObject() {
		return new InstagramController();
	}
}
