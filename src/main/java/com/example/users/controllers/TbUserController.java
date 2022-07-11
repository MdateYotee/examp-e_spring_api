package com.example.users.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.users.payload.UserPayload;
import com.example.users.repository.TbUserRepository;

@Controller
@RequestMapping("/user")
public class TbUserController {
	@Autowired
	TbUserRepository tbUserRepository;

	@Autowired
	TbUserBusiness userBusiness;

	@GetMapping("/")
	public ResponseEntity<TbUserJson> user() throws UserException {
		TbUserJson user = new TbUserJson();

		return ResponseEntity.ok(user);
	}

	@GetMapping(path = "/list")
	public @ResponseBody List<TbUserJson> userList() throws UserException {
		List<TbUserJson> userList = new ArrayList<TbUserJson>();

		return userList;
	}

	@PostMapping("/adduser")
	public ResponseEntity<Void> adduser(@RequestBody UserPayload userPayload) throws UserException {

		userBusiness.addUser(userPayload);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/updateuser")
	public ResponseEntity<Void> updateuser(@RequestBody UserPayload userPayload) throws UserException {

		userBusiness.addUser(userPayload);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<Void> deleteuser(@PathVariable String userId) throws UserException {

		userBusiness.deleteUser(userId);

		return ResponseEntity.ok().build();
	}

}
