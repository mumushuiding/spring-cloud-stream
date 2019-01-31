package com.apress.messaging.cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TestProcess {
	String INPUT="inputTest";
	String INPUT1="inputTest2";
	String OUTPUT="outputTest";
	@Output("outputTest")
	MessageChannel outputTest();
	@Input("inputTest")
	SubscribableChannel inputTest();
}
