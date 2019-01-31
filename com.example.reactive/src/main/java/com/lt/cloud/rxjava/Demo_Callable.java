package com.lt.cloud.rxjava;

import java.util.Date;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class Demo_Callable {

	public static void main(String[] args) {
		Date start=new Date();
		Observable.fromCallable(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("thread is:-"+Thread.currentThread().getName());
				Thread.sleep(1000);
				System.out.println("thread is:-"+Thread.currentThread().getName());
				return 20;
			}
		}).filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) throws Exception {
				System.out.println("thread is:-"+Thread.currentThread().getName());
				return t>10;
			}
		}).defaultIfEmpty(1).subscribe(new Observer<Integer>() {

			@Override
			public void onSubscribe(Disposable d) {
				
				
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("emitted:-"+t);
				
			}

			@Override
			public void onError(Throwable e) {
				System.out.println(e.getMessage());
				
			}

			@Override
			public void onComplete() {
				System.out.println("sequence completed successfully");
				
				
			}
		});
		Date end=new Date();
		System.out.println("time:"+(end.getTime()-start.getTime()));
	}

}
