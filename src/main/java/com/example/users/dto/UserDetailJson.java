package com.example.users.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.users.model.TbUser;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDetailJson {
	private String facultyName;
	private String userName;
	private String passWrod;
	private String detail;
	
	public static List<UserDetailJson> packUserJsonList(List<TbUser> list){
		List<UserDetailJson> userDetailJsons = new ArrayList<UserDetailJson>();
		for(TbUser tbUser : list) {
			UserDetailJson detailJson = new UserDetailJson();
			detailJson.setDetail(tbUser.getUserDetails());
			detailJson.setFacultyName(tbUser.getTbFaculty().getFacultyName());
			detailJson.setUserName(tbUser.getUserUsername());
			detailJson.setPassWrod(tbUser.getUserPassword());
			userDetailJsons.add(detailJson);
		}
		
		return userDetailJsons;
		
	}
	
	public static UserDetailJson packUserJson(TbUser list){
			UserDetailJson detailJson = new UserDetailJson();
			detailJson.setDetail(list.getUserDetails());
			detailJson.setFacultyName(list.getTbFaculty().getFacultyName());
			detailJson.setUserName(list.getUserUsername());
			detailJson.setPassWrod(list.getUserPassword());
		
		return detailJson;
		
	}

}
