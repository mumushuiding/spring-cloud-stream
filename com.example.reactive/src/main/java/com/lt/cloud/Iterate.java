package com.lt.cloud;

import java.util.Arrays;
import java.util.List;

public class Iterate {

	public static void main(String[] args) {
		
		List<Integer> numbers=Arrays.asList(12,34,23,45,344,34);
		numbers.stream().forEach(System.out::println);
		
	}

}
