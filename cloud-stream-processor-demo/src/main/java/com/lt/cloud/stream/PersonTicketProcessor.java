package com.lt.cloud.stream;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

import com.lt.cloud.domain.Person;
import com.lt.cloud.domain.Ticket;

import reactor.core.publisher.Flux;

@EnableBinding(TestProcess.class)
public class PersonTicketProcessor {
	private List<String> movieTitles = Arrays.asList("Dead Pool 2","Pitch Perfect 3","Avatar 2","Tarzan 2","Cars 3"); 
	private Random rand = new Random();
	
	@StreamListener(TestProcess.INPUT)
	public void process1(Message<Person> person) {
		System.out.println("log:"+person.getPayload());

	}
	@StreamListener
	public void receive(@Input(TestProcess.INPUT) Flux<Person> input) {
		input.subscribe(System.out::println);
	}
	//同一时间一个通道只能监听一次
//	@StreamListener(TestProcess.INPUT)
//	@SendTo(TestProcess.OUTPUT)
//	public Person process(Message<Person> person) {
//		System.out.println("log:"+person.getPayload());
//		return person.getPayload();
//
//	}
}
