package com.ee.fizzbuzz;

import java.util.LinkedHashMap;


public class FizzBuzz {

	public static String FIZZ = "fizz";
	public static String BUZZ = "buzz";
	public static String FIZZBUZZ = "fizzbuzz";
	public static final String LUCKY = "lucky";
	public static final String INTEGER = "integer";

	//LinkedHashMap preserves order of insertion
	@SuppressWarnings("serial")
	private static LinkedHashMap<String,Integer> counters = 
	new LinkedHashMap<String,Integer>() 
	{ { put(FIZZ,0); put(BUZZ,0); put(FIZZBUZZ,0); 
	put(LUCKY,0); put(INTEGER,0); }}; //initialize counters


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

	//Lucky Fizz Buzz
	
	public static String luckyFizzBuzz(int i) {
		String output = (String.valueOf(i).contains("3")) ? LUCKY : fizzBuzz(i);
		report(output);
		return output;
	}

	public static String continuousLuckyFizzBuzz(int min, int max) {
		StringBuilder result = new StringBuilder();
		for(int i = min; i<=max; ++i) {
			result.append(luckyFizzBuzz(i)).append(" ");
		}
		return result.toString();
	}

	
	//Reporting
	
    @SuppressWarnings("serial")
	public static void resetCounters() {
      counters = new LinkedHashMap<String,Integer>() 
              { { put(FIZZ,0); put(BUZZ,0); put(FIZZBUZZ,0); 
                  put(LUCKY,0); put(INTEGER,0); }}; //initialize counters
    }

	public static void report(String key) {
		try{
			Integer.parseInt(key);
			// is an integer!
			key = INTEGER;
		} catch (NumberFormatException e) {
			// not an integer!          
		}
		FizzBuzz.counters.put(key, FizzBuzz.counters.get(key) + 1);
	}


	public static String getReport() {
		StringBuilder result = new StringBuilder();
		for(String key: FizzBuzz.counters.keySet()) {
			result.append(key)
			.append(": ")
			.append(FizzBuzz.counters.get(key))
			.append(" ");
		}
		return result.toString();
	}

	public static int getReportCounter(String key) {
		return FizzBuzz.counters.get(key);
	}


	public static void main(String[] args) {
		System.out.println(FizzBuzz.continuousLuckyFizzBuzz(1,20) + getReport());
	}
}
