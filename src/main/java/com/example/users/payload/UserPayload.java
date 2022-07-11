package com.example.users.payload;

import lombok.Data;

@Data
public class UserPayload {
	private String userUuid;
	private long facultyId;
	private String username;
	private String password;
	private String detail;

}
