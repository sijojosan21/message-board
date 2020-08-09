package com.sijojosan.msg.board.controller.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.sijojosan.msg.board.modal.MessageModal;


public class AddMessageRequest {
	
	
	@NotNull(message = "Message is mandatory")
	@Valid
	private MessageModal message;

	public MessageModal getMessage() {
		return message;
	}

	public void setMessage(MessageModal message) {
		this.message = message;
	}
	
	
	

}
