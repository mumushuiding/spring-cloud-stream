package com.lt.cloud.rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DefaultSubscriber;

public class DemoDefaultSubscriber {

	public static void main(String[] args) {
		Flowable.range(2, 5).subscribe(new 
				DefaultSubscriber<Integer>() {

					@Override
					public void onNext(Integer t) {
						System.out.println("Value:"+t);
						
					}

					@Override
					public void onError(Throwable t) {
						t.printStackTrace();
						
					}

					@Override
					public void onComplete() {
						System.out.println("Its Done!!");
						
					}
					@Override
					protected void onStart() {
						request(2);
					}
				});

	}

}
