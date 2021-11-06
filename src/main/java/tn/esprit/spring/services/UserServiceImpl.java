package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);  
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			L.info("In method retrieveAllUsers : "); 
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				L.debug("user : " + user.getLastName());   
			} 
			L.info("Out of method retrieveAllUsers with success" +users.size()); 
		}catch (Exception e) {
			L.error("Out of method retrieveAllUsers : " + e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		L.info("In method addUser : "); 
		User u_saved = userRepository.save(u); 
		L.info("Out of method addUser with success"); 
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		L.info("In method updateUser : ");
		User u_saved = userRepository.save(u); 
		L.info("Out of method updateUser with success : "); 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		L.info("In method deleteUser : ");
		userRepository.deleteById(Long.parseLong(id)); 
		L.info("Out of method deleteUser with success : "); 
	}

	@Override
	public User retrieveUser(String id) {
		L.info("In method retrieveUser : "); 
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		L.info("Out of method retrieveUser with success : "); 
		return u; 
	}

}
