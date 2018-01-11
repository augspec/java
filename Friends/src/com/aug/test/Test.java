package com.aug.test;

import java.util.List;

import com.aug.db.entities.User;
import com.aug.db.handle.UserDbHandle;

public class Test {

	public static void main(String[] args) {
		UserDbHandle handle = new UserDbHandle();
		
		List<User> users = handle.getAll();
		
		for (User u : users) {
			System.out.println(u.toString());
		}
	}
}
