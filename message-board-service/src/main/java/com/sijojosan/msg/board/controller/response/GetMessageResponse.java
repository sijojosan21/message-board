package com.sijojosan.msg.board.controller.response;

import java.util.ArrayList;
import java.util.List;

import com.sijojosan.msg.board.modal.MessageModal;

public class GetMessageResponse extends BaseResponse {

	private List<MessageModal> messages = new ArrayList<>();

	public List<MessageModal> getMessages() {
		return messages;
	}

}
