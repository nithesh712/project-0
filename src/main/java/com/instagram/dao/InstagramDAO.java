package com.instagram.dao;

import java.util.ArrayList;
import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.exception.UserNotFoundException;

public class InstagramDAO implements InstagramDAOInterface {
	
	private static List<InstagramUser> igu = new ArrayList<InstagramUser>();
	
	public int createProfileDAO(InstagramUser iu) {
		int i=0;
		igu.add(iu);
		if(igu.size()>0) {
			i=1;
		}
		return i;
	}

	public List<InstagramUser> viewAllProfileDAO() {
		return igu;
	}

	public InstagramUser viewProfileDAO(InstagramUser iu) throws UserNotFoundException {
		InstagramUser iu1 = null;
		int i = 0;
		for(InstagramUser iu11: igu) {
			if(iu11.getName().equals(iu.getName())) {
				iu1 = iu11;
				i = 1;
				break;
			}
		}
		if(i==0) {
			throw new UserNotFoundException();
		}
		return iu1;
	}

}
