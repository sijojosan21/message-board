package com.sijojosan.msg.board.controller.response;

import java.util.ArrayList;
import java.util.List;

public class BaseResponse {

	private String responseCode;
	
	private String responseMessage;
	
	private List<String> additionalErrors;
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public List<String> getAdditionalErrors() {
		
		if(this.additionalErrors==null) {
			additionalErrors = new ArrayList<>();
		}
		
		return additionalErrors;
	}

	public void updateResponseCode(ResponseCode code) {
		this.responseCode = code.getResponseCode();
		this.responseMessage = code.getResponseMessage();
	}
	
}
