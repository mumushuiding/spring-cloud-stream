package com.lt.cloud.test;

public class Test {

	public static void main(String[] args) {
		String aString="cba";
		String xString="cba";
		System.out.println(aString.indexOf(xString));
		if(aString.indexOf(",")>-1) {
			if(aString.indexOf(xString)==0) {
				aString=aString.replace(xString+",", "");
			}else {
				aString=aString.replace(","+xString, "");
			}
		}else {
			aString=aString.replace(xString, "");
		}
		
		System.out.println(aString);
	}

}
