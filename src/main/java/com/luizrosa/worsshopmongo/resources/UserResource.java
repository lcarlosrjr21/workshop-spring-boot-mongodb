package com.luizrosa.worsshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luizrosa.worsshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User luiz = new User("1", "Luiz Rosa", "luiz@email.com");
		User maria = new User("2", "Maria", "maria@email.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(luiz,maria));
		return ResponseEntity.ok().body(list);
	}
}
