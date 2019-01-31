package com.apress.messaging.cloud.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import com.apress.messaging.domain.Person;


public class TestStream {
	@StreamListener(TestProcess.INPUT)
	public void process(Message<Person> person) {
		System.out.println("log:"+person.getPayload());
	}
}
