package com.example.onlineStore.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineStore.Repositories.UserRepository;
import com.example.onlineStore.models.User;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserServices implements IUserServices{

	@Autowired
	 private UserRepository userRepository;
	
	@Override
	public boolean addUser(User user) {
		if(userRepository.save(user) != null)
            return true;
        return false;
	}

	@Override
	public List<User> getAll() {
		Iterable<User> usersIter= userRepository.findAll();
		List<User> all= new ArrayList<User>();
		for(User user: usersIter)
			all.add(user);

		return all;
	}

}
