package com.instagram.ytility;

import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;

public class ServiceFactory {

	public static InstagramServiceInterface createObject() {
		return new InstagramService();
	}

}
