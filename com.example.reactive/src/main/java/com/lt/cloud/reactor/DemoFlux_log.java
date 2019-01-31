package com.lt.cloud.reactor;

import java.util.Date;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class DemoFlux_log {

	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		Flux<String> flux=Flux.just("JAVA","SPRING").log();
		flux.subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) {
				
				
			}
		});

	}

}
