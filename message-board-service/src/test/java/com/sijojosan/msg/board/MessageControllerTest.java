package com.sijojosan.msg.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sijojosan.msg.board.controller.request.AddMessageRequest;
import com.sijojosan.msg.board.controller.response.AddMessageResponse;
import com.sijojosan.msg.board.controller.response.BaseResponse;
import com.sijojosan.msg.board.controller.response.GetMessageResponse;
import com.sijojosan.msg.board.modal.MessageModal;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(Alphanumeric.class)
class MessageControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private static long messageID = 0;

	@Test
	@Order(1)
	void t1MessageAdd() {

		AddMessageRequest req = new AddMessageRequest();
		MessageModal mm = new MessageModal();
		mm.setBody("Junit Message Body");
		mm.setHeader("Junit Message Header");
		mm.setUser("Junit");
		req.setMessage(mm);

		ResponseEntity<AddMessageResponse> response = this.restTemplate.postForEntity(
				"http://localhost:" + port + "message-board/api/message/add", req, AddMessageResponse.class);

		assertEquals(201, response.getStatusCodeValue());

		AddMessageResponse val = response.getBody();

		assertEquals("COD001", val.getResponseCode());

		messageID = val.getMessage().getMessageID();
	}

	@Test
	void t2Messages() {

		ResponseEntity<GetMessageResponse> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "message-board/api/message/all", GetMessageResponse.class);

		assertEquals(200, response.getStatusCodeValue());

		GetMessageResponse val = response.getBody();

		assertEquals("COD001", val.getResponseCode());

		AtomicBoolean msgFound = new AtomicBoolean(false);
		val.getMessages().forEach(msg -> {
			if (msg.getMessageID() == messageID) {
				msgFound.set(true);
			}
		});

		assertTrue(msgFound.get());
	}

	@Test
	void t3MessagesVowels() {

		ResponseEntity<GetMessageResponse> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "message-board/api/message/vowels", GetMessageResponse.class);

		assertEquals(200, response.getStatusCodeValue());

		GetMessageResponse val = response.getBody();

		assertEquals("COD001", val.getResponseCode());

		AtomicBoolean msgFound = new AtomicBoolean(false);
		val.getMessages().forEach(msg -> {
			if (msg.getMessageID() == messageID) {
				msgFound.set(true);
			}
		});

		assertTrue(!msgFound.get());
	}
	
	@Test
	void t4MessageDelete() {


		ResponseEntity<BaseResponse> response = this.restTemplate
				.exchange("http://localhost:" + port + "message-board/api/message/"+messageID
				, HttpMethod.DELETE, null, 
				BaseResponse.class);

		assertEquals(200, response.getStatusCodeValue());



	}

}
