package com.cg.onlinepizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinepizza.model.Admin;
import com.cg.onlinepizza.dao.adminRepository;

@Service
@Transactional

public class AdminLogin {

	@Autowired
	adminRepository AdminRepo;
	
	public Admin addNewUser(Admin user) {
		
		AdminRepo.save(user);
		return user;
	}
	public String signIn(String userName,String password)  {
		if(!AdminRepo.existsById(userName))
			return "User doesnt exist";
		Admin user1=AdminRepo.findById(userName).orElse(null);
		if(!user1.getPassword().equals(password))
			return "Password didnt match";
		return "Logged In SuccessFully";
	}
}
