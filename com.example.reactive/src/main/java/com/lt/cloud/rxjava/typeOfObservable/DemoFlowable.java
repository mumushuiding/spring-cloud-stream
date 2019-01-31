package com.lt.cloud.rxjava.typeOfObservable;

import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class DemoFlowable {

	public static void main(String[] args) {
		Flowable<String> monthmaybe=Flowable.create(emitter->{
			try {
				String[] monthArray= {"Apl","May","Jun"};
				for (String string : monthArray) {
					emitter.onNext(string);
				}
				emitter.onComplete();
			} catch (Exception e) {
				emitter.onError(e);
			}
		}, BackpressureStrategy.MISSING);
		
		monthmaybe.subscribe(System.out::println);

	}

}
