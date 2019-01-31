package com.lt.cloud.rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class DemoDefer {

	public static void main(String[] args) {
		String[] monthArray= {"jan","feb","mar"};
		List<String> months=Arrays.asList(monthArray);
		Observable.defer(()->
			Observable.just(monthArray).create(subscriber->{
				try {
					months.stream().forEach(value->subscriber.onNext(value));
					subscriber.onComplete();
				} catch (Exception e) {
					subscriber.onError(e);
				}
			})).subscribe(item->System.out.println(item),error->System.out.println(error),
					()->System.out.println("Emission completed"));
	}

}
