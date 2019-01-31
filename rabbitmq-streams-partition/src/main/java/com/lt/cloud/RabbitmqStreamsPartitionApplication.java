package com.lt.cloud;

import java.util.Random;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(Source.class)
public class RabbitmqStreamsPartitionApplication {
	private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final String[] data = new String[] {
            "abc1", "def1", "qux1",
            "abc2", "def2", "qux2",
            "abc3", "def3", "qux3",
            "abc4", "def4", "qux4",
            };

	public static void main(String[] args) {
		new SpringApplicationBuilder(RabbitmqStreamsPartitionApplication.class)
		.web(false).run(args);
	}
	@InboundChannelAdapter(channel=Source.OUTPUT,poller=@Poller(fixedRate="5000"))//poller轮询
	public Message<?> generate(){
		String value=data[RANDOM.nextInt(data.length)];
		System.out.println("Sending:"+value);
		return MessageBuilder.withPayload(value).setHeader("partitionKey", value)
				.build();
		
	}
}
