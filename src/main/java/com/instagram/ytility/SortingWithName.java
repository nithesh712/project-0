package com.instagram.ytility;

import java.util.Comparator;

import com.instagram.entity.InstagramUser;

public class SortingWithName implements Comparator<InstagramUser> {

	public int compare(InstagramUser o1, InstagramUser o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
