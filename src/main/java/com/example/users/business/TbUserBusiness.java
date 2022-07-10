package com.example.users.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.users.exception.UserException;
import com.example.users.model.TbUser;
import com.example.users.payload.UserPayload;
import com.example.users.services.TbUserService;

import lombok.Setter;

@Service
@Setter
public class TbUserBusiness {
	@Autowired
	TbUserService userService;
	
	public TbUser addUser(UserPayload userPayload) throws UserException{
		
		 userService.checkNullUser(userPayload);
		 TbUser user = userService.setUser(userPayload, new TbUser());
		 
		return userService.addUser(user);
		 
	}

}
