package com.example.onlineStore.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineStore.Repositories.UserRepository;
import com.example.onlineStore.models.User;

import com.example.onlineStore.MyUserDetails;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;

@Service
public class UserServices implements IUserServices{
	
	@Autowired private UserRepository userRepository;
	
	@Override
	public boolean addUser(User user) {
		if(userRepository.save(user) != null)
            return true;
        return false;
	}

	@Override
	public List<User> getAll() {
		if(MyUserDetails.getType().equals("admin")){
			Iterable<User> usersIter = userRepository.findAll();
			List<User> all = new ArrayList<User>();
			for (User user : usersIter)
				all.add(user);

			return all;
		}else{
			return null;
		}
	}

	@Override
	public boolean verifyLogin(String username, String pass) 
	{
		
		User user= findByUsername(username);
		if(user!= null && user.getPassword().equals(pass)) {
			MyUserDetails.login(username, user.getType());
			return true;
		}
		
		return false;
	}

	@Override
	public void logout(){
		MyUserDetails.logout();
	}

	@Override
	public User findByUsername(String name) 
	{
		Iterable<User> usersIter= userRepository.findAll();
		for(User user: usersIter) 
		{
			if(user.getUsername().equals(name))
				return user;		
		}
		return null;
	}


	

}
