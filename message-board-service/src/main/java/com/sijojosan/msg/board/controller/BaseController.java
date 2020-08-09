package com.sijojosan.msg.board.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sijojosan.msg.board.controller.response.BaseResponse;
import com.sijojosan.msg.board.controller.response.ResponseCode;

public class BaseController extends ResponseEntityExceptionHandler {

	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {

	    BaseResponse res = new BaseResponse();
		res.updateResponseCode(ResponseCode.MANDATORY_FIELDS_MISSING);
		res.getAdditionalErrors().add(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
	  } 
}
