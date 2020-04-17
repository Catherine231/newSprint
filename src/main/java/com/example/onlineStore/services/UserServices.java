package com.example.onlineStore.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineStore.Repositories.UserRepository;
import com.example.onlineStore.models.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.ArrayList;

@Service
public class UserServices implements IUserServices{

	@PersistenceContext private EntityManager em;
	@Autowired private UserRepository userRepository;
	
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

	@Override
	public boolean verifyLogin(String username, String pass) {
		
		TypedQuery query = em.createQuery("select a from User u where u.username=?1 And u.passsword=?2", User.class);
		query.setParameter(1, username);
		query.setParameter(2, pass);
		
		if(!query.equals(null))
			return true;
		 
		return false;
	}

	

}
