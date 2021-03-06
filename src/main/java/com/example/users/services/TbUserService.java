package com.example.users.services;

import java.util.List;
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

	public void deleteUser(String userUUID) {
		TbUser tbUser = userRepository.findByUserUuid(userUUID);
		userRepository.delete(tbUser);
	}

	public TbUser findUserByUUID(String userUUID) {
		return userRepository.findByUserUuid(userUUID);

	}
	
	public List<TbUser> findAll() {
		return userRepository.findAll();

	}

	public TbUser packUser(UserPayload userPayload, TbUser tbUser) {

		if (Objects.nonNull(userPayload.getUserUuid())) {
			tbUser.setUserUuid(userPayload.getUserUuid());
		}

		if (Objects.nonNull(userPayload.getFacultyId())) {
			TbFaculty faculty = facultyRepository.findOneByfacultyId(userPayload.getFacultyId());
			tbUser.setTbFaculty(faculty);
		}

		if (Objects.nonNull(userPayload.getUsername())) {
			tbUser.setUserUsername(userPayload.getUsername());
		}

		if (Objects.nonNull(userPayload.getPassword())) {
			tbUser.setUserPassword(userPayload.getPassword());
		}

		if (Objects.nonNull(userPayload.getDetail())) {
			tbUser.setUserDetails(userPayload.getDetail());
		}

		return tbUser;

	}

	public void checkNullUser(UserPayload userPayload) throws UserException {

		if (Objects.isNull(userPayload.getFacultyId())) {
			throw UserException.userIsFacultyIdNull();
		}

		if (Objects.isNull(userPayload.getUsername())) {
			throw UserException.userIsUsernameNull();
		}

		if (Objects.isNull(userPayload.getPassword())) {
			throw UserException.userIsPasswordNull();
		}

		if (Objects.isNull(userPayload.getDetail())) {
			throw UserException.userIsDetailNull();
		}
	}

}
