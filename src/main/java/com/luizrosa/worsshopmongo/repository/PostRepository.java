package com.luizrosa.worsshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.luizrosa.worsshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	// title é o campo, ?0 o 1° parametro, o "i" pra ignorar maiuscula/minuscula
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); // Query Methods
	
}
