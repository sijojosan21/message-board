package com.sijojosan.msg.board.controller.request;

import com.sijojosan.msg.board.modal.MessageModal;

public class AddMessageRequest {

	private MessageModal message;

	public MessageModal getMessage() {
		return message;
	}

	public void setMessage(MessageModal message) {
		this.message = message;
	}
	
	
	

}
