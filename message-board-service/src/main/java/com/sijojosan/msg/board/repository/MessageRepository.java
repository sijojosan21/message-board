package com.sijojosan.msg.board.repository;

import org.springframework.data.repository.CrudRepository;

import com.sijojosan.msg.board.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
