package com.apress.messaging.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.integration.channel.FluxMessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apress.messaging.cloud.stream.StreamClient;
import com.apress.messaging.cloud.stream.TestProcess;
import com.apress.messaging.domain.Person;

import reactor.core.publisher.Flux;

@RestController
public class SourceController {

	@Autowired
	private TestProcess testProcess;
	@GetMapping("/send1")
	public void send1() {
		Person person=new Person("first", "last", new Date(), "110", "181457121@qq.com", false);
		testProcess.outputTest().send(MessageBuilder.withPayload(person).build());
	}
	
	@GetMapping("/sendFlux")
	public void send2(@Output(TestProcess.OUTPUT)FluxSender output){
		Person person=new Person("first", "last", new Date(), "110", "181457121@qq.com", false);
		List<Person> list=new ArrayList<>();
		list.add(person);
		list.add(person);
		output.send(Flux.<Person>fromStream(list.stream()));
	}
}
