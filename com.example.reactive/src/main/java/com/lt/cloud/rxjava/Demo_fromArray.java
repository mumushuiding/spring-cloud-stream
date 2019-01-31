package com.lt.cloud.rxjava;

import io.reactivex.Observable;

public class Demo_fromArray {

	public static void main(String[] args) {
		String[] monthArray= {"Jan","Feb","Mar"};
		Observable.fromArray(monthArray).subscribe(item->
				System.out.println(item),error->System.out.println(error),
				()->System.out.println("Emission completed")
				);
	}

}
