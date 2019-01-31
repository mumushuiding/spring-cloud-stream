package com.lt.cloud.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_Create_Observer {

	public static void main(String[] args) {
		Observable<Long> observable=Observable.rangeLong(11, 3);
		
		Observer<Long> observer=new Observer<Long>() {

			@Override
			public void onSubscribe(Disposable d) {
				//d.dispose();//抛弃之前的资源
				System.out.println("资源已经被抛弃："+d.isDisposed());
				
			}

			@Override
			public void onNext(Long t) {
				System.out.println("value:"+t);
				
			}

			@Override
			public void onError(Throwable e) {
				e.printStackTrace();
				
			}

			@Override
			public void onComplete() {
				System.out.println("on complete");
				
			}
		};
		
		observable.subscribe(observer);
	}

}
