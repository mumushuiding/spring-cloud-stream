package com.lt.cloud.rxjava.typeOfObservable;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;

public class SingleDemo{

	public static void main(String[] args) {
		Single<String> month=Single.create(emitter->{
			String[] monthArray= {"Jan","Feb","Mar"};
			List<String> months=Arrays.asList(monthArray);
			try {
//				if (months!=null && !months.isEmpty()) {
//					emitter.onSuccess(months);
//				}
				months.stream().forEach(item->emitter.onSuccess(item));
			} catch (Exception e) {
				emitter.onError(e);
			}
		});
		month.subscribe(System.out::println);
	}

}
