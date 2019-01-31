package com.lt.cloud.rxjava;

import io.reactivex.Observable;

public class Demo_Cold_Observable {

	public static void main(String[] args) {
		Observable<Object> observable=Observable.create(observer->{
			observer.onNext("I am Hot Observable " + Math.random()*100);
		});
		observable.subscribe(System.out::println);
		observable.subscribe(System.out::println);
	}

}
