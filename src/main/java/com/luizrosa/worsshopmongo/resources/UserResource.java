package com.luizrosa.worsshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luizrosa.worsshopmongo.domain.User;
import com.luizrosa.worsshopmongo.dto.UserDTO;
import com.luizrosa.worsshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
//		User luiz = new User("1", "Luiz Rosa", "luiz@email.com");
//		User maria = new User("2", "Maria", "maria@email.com");
//		List<User> list = new ArrayList<>();
		List<User> list = service.findAll();
//		list.addAll(Arrays.asList(luiz,maria));
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
