package com.example.onlineStore.services;
import java.util.List;

import com.example.onlineStore.models.User;

public interface IUserServices {
	public boolean addUser(User user);
	public boolean verifyLogin(String username, String pass);
	public List<User> getAll();

}
