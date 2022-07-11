package com.example.users.exception;

import org.springframework.http.HttpStatus;

import com.example.exception.BaseException;



public class UserException extends BaseException {
	protected UserException(String code, HttpStatus status) {
        super("user."+code, status);
    }
	
    public static UserException userIsFacultyIdNull() {
        return new UserException("FacultyIdNull",HttpStatus.EXPECTATION_FAILED);
    }
    public static UserException userIsUsernameNull() {
        return new UserException("UsernameNull",HttpStatus.EXPECTATION_FAILED);
    }
    public static UserException userIsPasswordNull() {
        return new UserException("PasswordNull",HttpStatus.EXPECTATION_FAILED);
    }
    public static UserException userIsDetailNull() {
        return new UserException("DetailNull",HttpStatus.EXPECTATION_FAILED);
    }
    
}
