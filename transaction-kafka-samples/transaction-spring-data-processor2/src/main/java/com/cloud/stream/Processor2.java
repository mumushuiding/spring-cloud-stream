package com.cloud.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;
@SpringBootApplication
@EnableBinding(Processor.class)
@EnableTransactionManagement
@RestController
public class Processor2 
{
	private Logger logger=LoggerFactory.getLogger(Processor2.class);
	private AtomicBoolean shouldFail=new AtomicBoolean(false);
	private Person2Repository repository;
	public Processor2(Person2Repository repository) {
		this.repository=repository;
	}
    public static void main( String[] args )
    {
        SpringApplication.run(Processor2.class, args);
    }
    @Transactional("transactionManager")
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public PersonEvent process(PersonEvent data) {
    	logger.info("Received event={}",data);
    	Person2 person=new Person2();
    	person.setName(data.getName());
    	
    	if (shouldFail.get()) {
			shouldFail.set(false);
			throw new RuntimeException("simulated network error");
		}else {
			shouldFail.set(true);
		}
    	logger.info("Saving person={}",person);
    	Person2 savedPerson=repository.save(person);
//    	int a=1/0;
    	PersonEvent event=new PersonEvent();
    	event.setName(savedPerson.getName());
    	event.setType("PersonSaved");
    	logger.info("Sent event={}",event);
    	return event;
    }
    @RequestMapping("/hello")
    public String hello() {
    	return "hello-world";
    }
}