package com.sijojosan.msg.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long messageID;

	@Column(name = "UserName")
	private String user;

	@Column(name = "Header")
	private String header;

	@Column(name = "Body")
	private String body;

	@Column(name = "Message_TimeStamp")
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
