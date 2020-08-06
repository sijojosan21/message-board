package com.sijojosan.msg.board.controller.response;

public enum ResponseCode {
	
	FAILED("COD000","Failed"),
	
	SUCCESS("COD001","Success"),
	
	MANDATORY_FIELDS_MISSING("COD002","Some Mandatory fields are missing."),
	
	MESSAGE_NOT_FOUD("COD003","Message not found");
	
	
	

	private String responseCode;
	
	private String responseMessage;

	private ResponseCode(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}
	
}
