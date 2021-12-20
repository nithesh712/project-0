package com.instagram.ytility;

import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;

public class DAOFactory {
	
	private DAOFactory() {
		
	}
	private static InstagramDAOInterface id;
	
	public static InstagramDAOInterface createObject() {
		if(id==null) {
			id=new InstagramDAO();
		}
		
		return id;
	}

}
