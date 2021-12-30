package com.instagram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.instagram.entity.InstagramUser;
import com.instagram.entity.TimeLineEntity;
import com.instagram.exception.UserNotFoundException;

public class InstagramDAO implements InstagramDAOInterface {
	
	private static List<InstagramUser> igu = new ArrayList<InstagramUser>();
	
	public int createProfileDAO(InstagramUser iu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("insert into instagramuser values(?,?,?,?)");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			ps.setString(3, iu.getEmail());
			ps.setString(4, iu.getAddress());
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<InstagramUser> viewAllProfileDAO() {
		List<InstagramUser> ll1 = new ArrayList<InstagramUser>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("select * from instagramuser");

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				InstagramUser ll = new InstagramUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));

				ll1.add(ll);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll1;
	}
	@Override
	public InstagramUser viewProfileDAO(InstagramUser iu) {
		InstagramUser ll = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("select * from instagramuser where email=?");

			ps.setString(1, iu.getEmail());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				ll = new InstagramUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public int deleteProfileDAO(InstagramUser lu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("delete from instagramuser where email=?");

			ps.setString(1, lu.getEmail());

			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public InstagramUser loginProfileDAO(InstagramUser lu) {
		InstagramUser ll = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("select * from instagramuser where email=? and password=?");

			ps.setString(1, lu.getEmail());
			ps.setString(2, lu.getPassword());

			ResultSet res = ps.executeQuery();

			if (res.next()) {
				ll = new InstagramUser();
				ll.setName(res.getString(1));
				ll.setPassword(res.getString(2));
				ll.setEmail(res.getString(3));
				ll.setAddress(res.getString(4));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll;
	}
	
	@Override
	public List<TimeLineEntity> timelineProfileDAO(InstagramUser lu) {
		List<TimeLineEntity> ll1 = new ArrayList<TimeLineEntity>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "govardhan");
			PreparedStatement ps = con.prepareStatement("select * from timeline where receiver=?");
			ps.setString(1, lu.getEmail());
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				TimeLineEntity ll = new TimeLineEntity();
				ll.setSender(res.getString(1));
			    ll.setMessage(res.getString(2));
				ll.setReceiver(res.getString(3));

				ll1.add(ll);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ll1;
	}
	
	@Override
	public int editProfileService(InstagramUser iu) {
		int i = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "123456");
			PreparedStatement ps = con.prepareStatement("UPDATE instagramuser SET name = ?, password = ?, address=? WHERE EMAIL = ?");
			ps.setString(4, iu.getEmail());
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			ps.setString(3, iu.getAddress());
			i = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
