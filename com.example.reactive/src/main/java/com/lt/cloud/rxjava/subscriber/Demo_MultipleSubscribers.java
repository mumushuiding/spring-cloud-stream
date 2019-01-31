package com.lt.cloud.rxjava.subscriber;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Demo_MultipleSubscribers {
	public static void main(String[] args) {
		String[] monthArray= {"Jan","Feb","Mar"};
		List<String> months=Arrays.asList(monthArray);
		
		Observable<Object> observable=
				Observable.create(subscriber->{
					try {
						System.out.println("Creating ");
						months.stream().forEach(data->subscriber.onNext(data));
					} catch (Exception e) {
						subscriber.onError(e);
					}
				}).cache();//添加cache()方法之后， create()方法只会执行一次
		observable.subscribe(System.out::println);
		observable.subscribe(System.out::println);
	}
}
