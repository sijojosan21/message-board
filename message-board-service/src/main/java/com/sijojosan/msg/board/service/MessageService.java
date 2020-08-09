package com.sijojosan.msg.board.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sijojosan.msg.board.controller.request.AddMessageRequest;
import com.sijojosan.msg.board.controller.response.AddMessageResponse;
import com.sijojosan.msg.board.controller.response.BaseResponse;
import com.sijojosan.msg.board.controller.response.GetMessageResponse;
import com.sijojosan.msg.board.controller.response.ResponseCode;
import com.sijojosan.msg.board.entity.Message;
import com.sijojosan.msg.board.modal.MessageModal;
import com.sijojosan.msg.board.repository.MessageRepository;

import ma.glasnost.orika.MapperFacade;

@Service
public class MessageService {

	@Autowired
	private MapperFacade mapper;
	
	private static final String VOWEL_SET_REGX = "^(?=.*a)(?=.*e)(?=.*i)(?=.*o)(?=.*u).*$";

	@Autowired
	private MessageRepository messageRepository;

	public ResponseEntity<AddMessageResponse> addMessage(AddMessageRequest request) {

		AddMessageResponse response = new AddMessageResponse();
		response.updateResponseCode(ResponseCode.FAILED);

		MessageModal messageToAdd = request.getMessage();

		messageToAdd.setMessageTimeStamp(Calendar.getInstance().getTimeInMillis());

		Message m = mapper.map(messageToAdd, Message.class);

		m = messageRepository.save(m);

		messageToAdd.setMessageID(m.getMessageID());

		response.updateResponseCode(ResponseCode.SUCCESS);
		response.setMessage(messageToAdd);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<GetMessageResponse> getAllMessages() {

		GetMessageResponse response = new GetMessageResponse();
		response.updateResponseCode(ResponseCode.FAILED);

		List<Message> messages = (List<Message>) messageRepository.findAllByOrderByMessageTimeStampDesc();

		messages.forEach(m -> {
			response.getMessages().add(mapper.map(m, MessageModal.class));
		});

		response.updateResponseCode(ResponseCode.SUCCESS);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<BaseResponse> deleteMessage(long messageID) {

		BaseResponse response = new BaseResponse();
		response.updateResponseCode(ResponseCode.FAILED);
		
		Optional<Message> m = messageRepository.findById(messageID);
		
		if(m.isPresent()) {
			messageRepository.delete(m.get());
			response.updateResponseCode(ResponseCode.SUCCESS);
		} else  {
			response.updateResponseCode(ResponseCode.MESSAGE_NOT_FOUD);
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	public ResponseEntity<GetMessageResponse> getMessagesWithVowels() {

		GetMessageResponse response = new GetMessageResponse();
		response.updateResponseCode(ResponseCode.FAILED);

		List<Message> messages = (List<Message>) messageRepository.findAllByOrderByMessageTimeStampDesc();

		messages.forEach(m -> {
			
			if(m.getHeader().toLowerCase().matches(VOWEL_SET_REGX)) {
				response.getMessages().add(mapper.map(m, MessageModal.class));
			}
		});

		response.updateResponseCode(ResponseCode.SUCCESS);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
