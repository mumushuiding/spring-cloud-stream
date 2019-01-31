package com.apress.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.reactive.FluxSender;

import com.apress.messaging.cloud.stream.StreamClient;
import com.apress.messaging.cloud.stream.TestProcess;

@SpringBootApplication
@EnableBinding(value= {StreamClient.class,TestProcess.class})
public class CloudStreamSourceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamSourceDemoApplication.class, args);
	}
}
