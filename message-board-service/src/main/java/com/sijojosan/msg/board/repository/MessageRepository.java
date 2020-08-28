package com.sijojosan.msg.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sijojosan.msg.board.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
	
	public List<Message> findAllByOrderByMessageTimeStampDesc();
	
	@Query("Select m from Message m where lower(m.header) like %:searchQuery%")
	public List<Message> searchMessages(String searchQuery);

}
