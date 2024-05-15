package com.techblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	// method to insert user to database.

	public boolean saveUser(User user) {
		boolean f = false;

		try {

			String sql = "insert into users(name, email, password, gender) values(?,?,?,?)";
			PreparedStatement pst = this.con.prepareStatement(sql);
			pst.setNString(1, user.getName());
			pst.setNString(2, user.getEmail());
			pst.setNString(3, user.getPassword());
			pst.setNString(4, user.getGender());

			pst.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// get user by email and password

	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {

			String sql = "select * from users where email=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet set = pst.executeQuery();

			if (set.next()) {
				user = new User();
				// fetch data from database
				String name = set.getString("name");
				// set data to user object
				user.setName(name);

				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// update user details

	public boolean updateUser(User user) {

		boolean f = false;

		try {

			String sql = "update users set name=?, email=?, password=? where id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setInt(4, user.getId());

			pst.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User getUserByUserId(int userId) {
		User user = null;
		String q = "select * from users where id=?";
		try {
			PreparedStatement pst = this.con.prepareStatement(q);
			pst.setInt(1, userId);
			ResultSet set = pst.executeQuery();
			if(set.next()) {
				user = new User();
				// fetch data from database
				String name = set.getString("name");
				// set data to user object
				user.setName(name);

				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGender(set.getString("gender"));

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
}
