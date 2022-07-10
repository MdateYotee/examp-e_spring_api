package com.example.users.services;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.faculty.model.TbFaculty;
import com.example.faculty.repository.TbFacultyRepository;
import com.example.users.exception.UserException;
import com.example.users.model.TbUser;
import com.example.users.payload.UserPayload;
import com.example.users.repository.TbUserRepository;

import lombok.Setter;

@Service
@Setter
public class TbUserService {
	@Autowired
	TbUserRepository userRepository;
	@Autowired
	TbFacultyRepository facultyRepository;
	
	public TbUser addUser(TbUser user) {
		return userRepository.save(user);
	}
	
	public TbUser setUser(UserPayload userPayload, TbUser tbUser) {
		
		if(Objects.nonNull(userPayload.getFacultyId())) {
			TbFaculty faculty = facultyRepository.findOneByfacultyId(userPayload.getFacultyId());
			tbUser.setTbFaculty(faculty);
		}
		
		if(Objects.nonNull(userPayload.getUsername())) {
			tbUser.setUsername(userPayload.getUsername());
		}
		
		if(Objects.nonNull(userPayload.getPassword())) {
			tbUser.setPassword(userPayload.getPassword());
		}
		
		if(Objects.nonNull(userPayload.getDetail())) {
			tbUser.setDetails(userPayload.getDetail());
		}
		
		return tbUser;
		
	}
	
	public void checkNullUser(UserPayload userPayload) throws UserException {
		if(Objects.isNull(userPayload.getFacultyId())) {
			throw UserException.userIsFacultyIdNull();
		}
		
		if (Objects.isNull(userPayload.getUsername())) {
			throw UserException.userIsUsernameNull();
		}
		
		if (Objects.isNull(userPayload.getPassword())) {
			throw UserException.userIsPasswordNull();
		}
		
		if(Objects.isNull(userPayload.getDetail())) {
			throw UserException.userIsDetailNull();
		}
	}
	
	
}
