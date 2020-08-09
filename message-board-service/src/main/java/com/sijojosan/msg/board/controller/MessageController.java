package com.sijojosan.msg.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sijojosan.msg.board.controller.request.AddMessageRequest;
import com.sijojosan.msg.board.controller.response.AddMessageResponse;
import com.sijojosan.msg.board.controller.response.BaseResponse;
import com.sijojosan.msg.board.controller.response.GetMessageResponse;
import com.sijojosan.msg.board.service.MessageService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@ControllerAdvice
public class MessageController extends BaseController{
	
	@Autowired
	private MessageService messageService;
	
	
	@ApiOperation(value = "View the list of all messages.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all messages.")
    })
	@GetMapping(value = "/message/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GetMessageResponse> messages() {
		
		ResponseEntity<GetMessageResponse> response  = messageService.getAllMessages();
		
		return response;
	}
	
	
	@ApiOperation(value = "View the list of all messages which have all the vowels in the message heading.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved messages.")
    })
	@GetMapping(value = "/message/vowels", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GetMessageResponse> messagesVowels() {
		
		ResponseEntity<GetMessageResponse> response  = messageService.getMessagesWithVowels();
		
		return response;
	}
	
	
	@ApiOperation(value = "Post a new message.")
	@ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully posetd the message."),
            @ApiResponse(code = 400, message = "Mandatory fields missing.")
    })
	@PostMapping(value = "/message/add", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AddMessageResponse> messageAdd(@Valid @RequestBody AddMessageRequest addMessageRequest) {
		
		ResponseEntity<AddMessageResponse> response  = messageService.addMessage(addMessageRequest);
		
		return response;
	}
	
	@ApiOperation(value = "Delete a specific message.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the specified message."),
            @ApiResponse(code = 204, message = "Message to be deleted was not found.")
    })
	@DeleteMapping(value = "/message/{messageID}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<BaseResponse> messageDelete(@Valid @PathVariable(value = "messageID") Long messageID) {
		
		ResponseEntity<BaseResponse> response  = messageService.deleteMessage(messageID);
		
		return response;
	}
	
	
	


}
