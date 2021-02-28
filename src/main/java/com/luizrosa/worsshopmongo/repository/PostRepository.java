package com.luizrosa.worsshopmongo.repository;

import java.util.Date;
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
	// ?1 pois o que interessa é o minDate se fosse o text seria ?0 e o maxDate seria ?2
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } ,{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } },  { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
