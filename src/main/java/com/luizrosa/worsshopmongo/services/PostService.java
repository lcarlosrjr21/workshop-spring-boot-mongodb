package com.luizrosa.worsshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizrosa.worsshopmongo.domain.Post;
import com.luizrosa.worsshopmongo.repository.PostRepository;
import com.luizrosa.worsshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo; // dependencia para o banco de dados

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
//		return repo.findByTitleContainingIgnoreCase(text); // Query Methods
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // acrescentando 24h na datamax
		return repo.fullSearch(text, minDate, maxDate);
	}
}