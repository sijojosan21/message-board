package com.sijojosan.msg.board.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sijojosan.msg.board.modal.MessageModal;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddMessageResponse extends BaseResponse {

	private MessageModal message;

	public MessageModal getMessage() {
		return message;
	}

	public void setMessage(MessageModal message) {
		this.message = message;
	}
	
}
