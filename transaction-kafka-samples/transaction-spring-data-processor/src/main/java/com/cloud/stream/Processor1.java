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
public class Processor1 
{
	private Logger logger=LoggerFactory.getLogger(Processor1.class);
	private AtomicBoolean shouldFail=new AtomicBoolean(false);
	private PersonRepository repository;
	public Processor1(PersonRepository repository) {
		this.repository=repository;
	}
    public static void main( String[] args )
    {
        SpringApplication.run(Processor1.class, args);
    }
    @Transactional("transactionManager")
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public PersonEvent process(PersonEvent data) {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	logger.info("Received event={}",data);
    	Person person=new Person();
    	person.setName(data.getName());
    	
    	if (shouldFail.get()) {
			shouldFail.set(false);
			throw new RuntimeException("simulated network error");
		}else {
			shouldFail.set(true);
		}
    	logger.info("Saving person={}",person);
    	Person savedPerson=repository.save(person);
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
