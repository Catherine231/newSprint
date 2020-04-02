package com.example.onlineStore.services;
import java.util.List;

import com.example.onlineStore.models.User;

public interface IUserServices {
	public boolean addUser(User user);
	public List<User> getAll();

}
