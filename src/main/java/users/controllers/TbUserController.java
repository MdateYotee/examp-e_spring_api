package users.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jdk.jshell.spi.ExecutionControl.UserException;
import users.json.TbUserJson;
import users.repository.TbUserRepository;

@Controller 
@RequestMapping(path="/user") 
public class TbUserController {
	@Autowired 
	private TbUserRepository tbUserRepository;
	
	@GetMapping(path="/")
    public ResponseEntity<TbUserJson> user() throws UserException {
		TbUserJson user = new TbUserJson();
	
        return ResponseEntity.ok(user);
    }
	@GetMapping(path="/list")
    public  @ResponseBody List<TbUserJson> userList() throws UserException {
		List<TbUserJson> userList = new ArrayList<TbUserJson>();
	 
        return userList;
    }
}
