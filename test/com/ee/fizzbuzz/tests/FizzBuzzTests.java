package com.ee.fizzbuzz.tests;

import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.Test;
import com.ee.fizzbuzz.FizzBuzz;

  
public class FizzBuzzTests {
    
    @Test
    public void fizzBuzzTests() {

      // assert statements
      assertEquals("fizzBuzz(1)", "1", FizzBuzz.fizzBuzz(1));
      assertEquals("fizzBuzz(2)", "2", FizzBuzz.fizzBuzz(2));
      assertEquals("fizzBuzz(3)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(3));
      assertEquals("fizzBuzz(15)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(15));
      assertEquals("fizzBuzz(4)", "4", FizzBuzz.fizzBuzz(4));
      assertEquals("fizzBuzz(5)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(5));
      assertEquals("fizzBuzz(6)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(6));
      assertEquals("fizzBuzz(9)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(9));
      assertEquals("fizzBuzz(10)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(10));
      assertEquals("fizzBuzz(11)", "11", FizzBuzz.fizzBuzz(11));
      assertEquals("fizzBuzz(12)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(12));
      
      assertEquals("fizzBuzz(21)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(21));
      assertEquals("fizzBuzz(25)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(25));
      assertEquals("fizzBuzz(30)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(30));
      
      assertEquals("fizzBuzz(0)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(0));
      assertEquals("fizzBuzz(MAXINT)", String.valueOf(Integer.MAX_VALUE), FizzBuzz.fizzBuzz(Integer.MAX_VALUE));
      assertEquals("fizzBuzz(MAXINT+1)", String.valueOf(Integer.MIN_VALUE), FizzBuzz.fizzBuzz(Integer.MAX_VALUE+1));

      assertEquals("fizzBuzz(-1)", "-1", FizzBuzz.fizzBuzz(-1));
      assertEquals("fizzBuzz(-3)", FizzBuzz.FIZZ, FizzBuzz.fizzBuzz(-3));
      assertEquals("fizzBuzz(-5)", FizzBuzz.BUZZ, FizzBuzz.fizzBuzz(-5));
      assertEquals("fizzBuzz(-15)", FizzBuzz.FIZZBUZZ, FizzBuzz.fizzBuzz(-15));
      
    }
    
    
    @Test
    public void continuousfizzBuzzTests() {
      assertEquals("continuousFizzBuzz(1,20)", 
                    "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz ", 
                   FizzBuzz.continuousFizzBuzz(1,20));
      assertEquals("continuousFizzBuzz(1,1)",
                    FizzBuzz.fizzBuzz(1),
                   FizzBuzz.continuousFizzBuzz(1,1).trim());
      assertEquals("continuousFizzBuzz(1,0)",
                    "",
                   FizzBuzz.continuousFizzBuzz(1,0));
      assertEquals("continuousFizzBuzz(3,3)",
                    FizzBuzz.fizzBuzz(3),
                   FizzBuzz.continuousFizzBuzz(3,3).trim());
      assertEquals("continuousFizzBuzz(5,5)",
                    FizzBuzz.fizzBuzz(5),
                   FizzBuzz.continuousFizzBuzz(5,5).trim());
      assertEquals("continuousFizzBuzz(15,15)",
                    FizzBuzz.fizzBuzz(15),
                   FizzBuzz.continuousFizzBuzz(15,15).trim());
    }

  
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(FizzBuzzTests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
