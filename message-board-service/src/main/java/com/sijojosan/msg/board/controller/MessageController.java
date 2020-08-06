package com.sijojosan.msg.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sijojosan.msg.board.controller.request.AddMessageRequest;
import com.sijojosan.msg.board.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	
	@GetMapping(value = "/message/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> messages() {
		
		ResponseEntity<?> response  = messageService.getAllMessages();
		
		return response;
	}
	
	@GetMapping(value = "/message/vowels", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> messagesVowels() {
		
		ResponseEntity<?> response  = messageService.getMessagesWithVowels();
		
		return response;
	}
	
	@PostMapping(value = "/message/add", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> messageAdd(@RequestBody AddMessageRequest addMessageRequest) {
		
		ResponseEntity<?> response  = messageService.addMessage(addMessageRequest);
		
		return response;
	}
	
	@DeleteMapping(value = "/message/{messageID}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> messageDelete(@PathVariable(value = "messageID") Long messageID) {
		
		ResponseEntity<?> response  = messageService.deleteMessage(messageID);
		
		return response;
	}
	

}
