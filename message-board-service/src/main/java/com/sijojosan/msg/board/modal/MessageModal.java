package com.sijojosan.msg.board.modal;

import javax.validation.constraints.NotNull;


public class MessageModal  {


	private Long messageID;
	
	@NotNull(message = "User field is mandatory")
	private String user;
	
	@NotNull(message = "Heading of the message is mandatory")
	private String header;
	
	@NotNull(message = "Body of the message is mandatory")
	private String body;
	
	private long messageTimeStamp;

	public Long getMessageID() {
		return messageID;
	}

	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public long getMessageTimeStamp() {
		return messageTimeStamp;
	}

	public void setMessageTimeStamp(long messageTimeStamp) {
		this.messageTimeStamp = messageTimeStamp;
	}
	
	
}
