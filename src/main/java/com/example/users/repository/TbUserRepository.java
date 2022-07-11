package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.model.TbUser;


public interface TbUserRepository extends JpaRepository<TbUser, Long>{
	TbUser findByUserUuid(String userUuid);



}
