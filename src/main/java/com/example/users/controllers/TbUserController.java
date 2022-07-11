package com.example.users.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.users.business.TbUserBusiness;
import com.example.users.exception.UserException;
import com.example.users.json.TbUserJson;
import com.example.users.model.TbUser;
import com.example.users.payload.UserPayload;

@Controller
@RequestMapping("/user")
public class TbUserController {
	@Autowired
	TbUserBusiness userBusiness;


	@GetMapping(path = "/list")
	public @ResponseBody List<TbUser> userList() throws UserException {
		List<TbUser> userList = userBusiness.findUserAll();

		return userList;
	}
	
	@GetMapping(path = "/list/{userUUID}")
	public @ResponseBody ResponseEntity<TbUser> getuserById(@PathVariable String userUUID) throws UserException {
 		TbUser tbUser = userBusiness.findUserByUUID(userUUID);
 		 return ResponseEntity.ok(tbUser);
	}

	@PostMapping("/adduser")
	public ResponseEntity<Void> adduser(@RequestBody UserPayload userPayload) throws UserException {

		userBusiness.addUser(userPayload);

		 return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<Void> updateuser(@RequestBody UserPayload userPayload) throws UserException {

		userBusiness.updateUser(userPayload);

		 return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<Void> deleteuser(@PathVariable String userId) throws UserException {

		userBusiness.deleteUser(userId);

		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
