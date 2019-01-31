package com.apress.messaging.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StreamClient {
	@Output("person")
	MessageChannel output();
	
}
