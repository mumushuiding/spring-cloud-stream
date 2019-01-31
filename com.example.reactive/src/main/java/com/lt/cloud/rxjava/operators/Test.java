package com.lt.cloud.rxjava.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lt.cloud.JsonUtils;

import io.reactivex.Observable;



public class Test {

	public static void main(String[] args) {
		List<Balance> list=new ArrayList<>();
		list.add(new Balance(1L, 2.0));
		list.add(new Balance(1L, 2.0));
		list.add(new Balance(2L, 3.0));
		list.add(new Balance(2L, 2.0));
		list.add(new Balance(3L, 2.0));
		list.add(new Balance(3L, 8.0));
		List<Balance> result=new ArrayList<>();
		list.stream().map(item->item.getB_AdItemID()).distinct().forEach(item2 -> {
			System.out.println(item2);
			Balance ba=null;
			for (Balance balance : list) {
				System.out.println("balance.getB_AdItemID():"+balance.getB_AdItemID()+",item2:"+item2+"="+balance.getB_AdItemID().equals(item2));
				if(balance.getB_AdItemID().equals(item2)) {
					ba=balance;
					break;
				};
				
			}
			//不重复的广告ID，和对应的平账总额
			Double sum=list.stream().filter(item3->item3.getB_AdItemID().equals(item2))
					.map(item4->item4.getB_Amount())
					.reduce((acc,cur)->acc+cur).get();
			if (sum>0) {
				ba.setB_Amount(sum);
				result.add(ba);
			}
		});
		System.out.println(JsonUtils.getGson().toJson(result));

	}
}
