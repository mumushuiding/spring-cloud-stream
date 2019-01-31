package com.lt.cloud.rxjava;

import io.reactivex.Observable;

import io.reactivex.observables.ConnectableObservable;

public class Demo_Hot_Observable {
	public static void main(String[] args) {
		
		//仅当connect方法调用时才释放元素
		ConnectableObservable<Object> observable=
				Observable.create(observer->{
					observer.onNext("I am Hot Observable "+Math.random()*100);
					observer.onComplete();
				}).publish();//publish 返回一个ConnectableObservable
		observable.subscribe(consumer->System.out.println("message:"+consumer));
		observable.subscribe(consumer->System.out.println("message:"+consumer));
		observable.connect();
	}
}
