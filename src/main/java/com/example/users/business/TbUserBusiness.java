package com.example.users.business;

import java.util.List;

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
	
	public TbUser findUserByUUID(String userUUID) {
		
		return userService.findUserByUUID(userUUID);
	}
	
	public List<TbUser> findUserAll() {
		
		return userService.findAll();
	}

	public TbUser addUser(UserPayload userPayload) throws UserException {

		userService.checkNullUser(userPayload);
		TbUser user = userService.packUser(userPayload, new TbUser());

		return userService.addUser(user);

	}

	public TbUser updateUser(UserPayload userPayload) throws UserException {

		userService.checkNullUser(userPayload);
		TbUser users = userService.findUserByUUID(userPayload.getUserUuid());
		TbUser user = userService.packUser(userPayload, users);

		return userService.addUser(user);

	}

	public void deleteUser(String userUUID) throws UserException {
		userService.deleteUser(userUUID);

	}

}
