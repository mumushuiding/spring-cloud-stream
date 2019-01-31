package com.cloud.stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class App 
{
	private final Logger logger=LoggerFactory.getLogger(App.class);
	private Source source;
	public App(Source source) {
		this.source=source;
	}
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    @PostMapping()
    public String sendMessage(@RequestBody PersonEvent incoming) {
    	PersonEvent personEvent=new PersonEvent();
    	personEvent.setType("CreatePerson");
    	personEvent.setName(incoming.getName());
    	source.output().send(MessageBuilder.withPayload(personEvent).build());
    	logger.info("Person sendt={}",personEvent);
    	return "Person sendt"; 
    }
    @RequestMapping("/send/{name}")
    public String send(@PathVariable String name) {
    	PersonEvent personEvent=new PersonEvent();
    	personEvent.setType("CreatePerson");
    	personEvent.setName(name);
    	source.output().send(MessageBuilder.withPayload(personEvent).build());
    	logger.info("Person sendt={}",personEvent);
    	return "Person sendt"; 
    }
    @RequestMapping("/hello")
    public String hello() {
    	return "hello-world";
    }
}

