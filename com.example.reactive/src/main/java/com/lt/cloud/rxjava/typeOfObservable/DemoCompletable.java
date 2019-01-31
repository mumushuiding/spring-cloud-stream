package com.lt.cloud.rxjava.typeOfObservable;

import io.reactivex.Completable;

public class DemoCompletable {

	public static void main(String[] args) {
		Completable completable=Completable.fromAction(()->
		System.out.println("Welcome to Completable"));
		completable.subscribe();

	}

}
