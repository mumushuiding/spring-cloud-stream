package com.lt.cloud.rxjava.threads;

import java.util.Date;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Demo_SubscriberON {

	public static void main(String[] args) {
		Date start=new Date();
		Observable.fromCallable(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("Observable thread is:-" +
						Thread.currentThread().getName());
				return 20;
			}
		}).filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) throws Exception {
				System.out.println("operator thread is:-" +
						Thread.currentThread().getName());
				return t > 10;
				
			}
		}).subscribeOn(Schedulers.newThread()).defaultIfEmpty(1).subscribe(new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("emitted:-" + t);
				
			}

			@Override
			public void onError(Throwable e) {
				System.out.println(e.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("Subscriber thread is:-"+Thread.currentThread().getName());
						System.out.println("sequence completed successfully");
				
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end=new Date();
		System.out.println("time:"+(end.getTime()-start.getTime()));
	}
	
}
