package com.example.accessingdatamysql;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

@RestController// This means that this class is a Controller
// This means URL's start with /demo (after Application path)
public class MainController {
  @Autowired // This means to get the bean called userRepository
  // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;

<<<<<<< HEAD
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public boolean add(@RequestBody User user)
    {
      if(userRepository.save(user) != null)
          return true;
      return false;
    }
=======
    @PostMapping(path="/add") // Map ONLY POST Requests
    public boolean add(@RequestBody User user)
	    {
        if(userRepository.save(user) != null)
            return true;
        return false;
      }
>>>>>>> master

  @RequestMapping(value="/add", method=RequestMethod.GET)
   public List<User> getAllUsers() {
      // TODO Auto-generated method stub
      Iterable<User> usersIter= userRepository.findAll();
      List<User> all= new ArrayList<User>();
      for(User user: usersIter)
        all.add(user);

      return all;
   }
}
