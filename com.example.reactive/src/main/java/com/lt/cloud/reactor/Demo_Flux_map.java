package com.lt.cloud.reactor;

import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class Demo_Flux_map {

	public static void main(String[] args) {
		Flux<String> flux=Flux.just("JAVA","SPRING").
				map((item)->{
					if(item.length()>=0) return item+ " has length:-"+item.length();
					else return item+ "length:- cannot be calculated";
				});
		flux.subscribe(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
		});

	}

}
