package com.lt.cloud.rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.subscribers.ResourceSubscriber;

public class DemoResourceSubscriber {

	public static void main(String[] args) {
		ResourceSubscriber<Long> resourceSubscriber=new ResourceSubscriber<Long>() {

			@Override
			public void onNext(Long t) {
				System.out.println("Value:"+t);
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				dispose();
				
			}

			@Override
			public void onComplete() {
				System.out.println("Its Done!!");
				dispose();
			}
		};
		Flowable.rangeLong(5, 4).subscribe(resourceSubscriber);
		resourceSubscriber.dispose();
	}

}
