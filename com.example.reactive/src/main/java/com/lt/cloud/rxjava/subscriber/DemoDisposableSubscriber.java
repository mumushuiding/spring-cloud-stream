package com.lt.cloud.rxjava.subscriber;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class DemoDisposableSubscriber {

	public static void main(String[] args) {
		DisposableSubscriber<Long> disposableSubscriber=new DisposableSubscriber<Long>() {

			@Override
			public void onNext(Long t) {
				if(t==7)
					dispose();//当值达到7时，取消接收元素
					System.out.println("value :-" + t);
				
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				
			}

			@Override
			public void onComplete() {
				System.out.println("Its Done !!");
				
			}
			@Override
			protected void onStart() {
				request(Long.MAX_VALUE);
			}
		};
		
		Flowable.rangeLong(5, 4).subscribe(disposableSubscriber);
		disposableSubscriber.dispose();
	}

}
