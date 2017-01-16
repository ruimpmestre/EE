package com.ee.fizzbuzz;


public class FizzBuzz {

	public static String FIZZ = "fizz";
	public static String BUZZ = "buzz";
	public static String FIZZBUZZ = "fizzbuzz";
	public static final String LUCKY = "lucky";

	public static String fizzBuzz(int i) {
		if(i%15==0) {
			return FIZZBUZZ;
		} else if(i%3==0) {
			return FIZZ;
		} else if(i%5==0) {
			return BUZZ;
		} else {
			return String.valueOf(i);
		}
	}

	public static String continuousFizzBuzz(int min, int max) {
		StringBuilder result = new StringBuilder();
		for(int i = min; i<=max; ++i) {
			result.append(fizzBuzz(i)).append(" ");
		}
		return result.toString();
	}

	public static String luckyFizzBuzz(int i) {
		String output = (String.valueOf(i).contains("3")) ? LUCKY : fizzBuzz(i);
		return output;
	}


	public static String continuousLuckyFizzBuzz(int min, int max) {
		StringBuilder result = new StringBuilder();
		for(int i = min; i<=max; ++i) {
			result.append(luckyFizzBuzz(i)).append(" ");
		}
		return result.toString();
	}

	public static String getReport() {
		return "";
	}

	public static int getReportCounter(String key) {
		return -1;
	}

	
	public static void main(String[] args) {
		System.out.println(FizzBuzz.continuousLuckyFizzBuzz(1,20));
	}
}
