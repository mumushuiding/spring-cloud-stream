package com.lt.cloud.rxjava;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Demo_Create_Observable {
	public static void main(String[] args) {
		//例子1
//		Observable<String> observable=Observable.just("welcome to rxjava","hello world");
//		observable.subscribe(System.out::println);
//		observable.subscribe(s->System.out.println("lt:"+s));
		
		//例子2
		Integer[] nums= {1,36,8,9};
		List<Integer> numList=Arrays.asList(nums);
		Observable.just(numList).subscribe(item->System.out.println(item));
		
	}
}
